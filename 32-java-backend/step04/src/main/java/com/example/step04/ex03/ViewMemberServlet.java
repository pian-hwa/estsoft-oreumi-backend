package com.example.step04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/viewMember")
public class ViewMemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: ViewMemberServlet#doGet()");

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("login.html");
            return;
        }

        boolean isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
        String username = (String) session.getAttribute("username");

        if (!isLoggedIn || username == null) {
            response.sendRedirect("login.html");
            return;
        }

        MemberDao memberDao = new MemberDao();
        MemberVo memberVo = memberDao.getMember(username);

        if (memberVo.getUsername() == null) {
            response.sendRedirect("login.html");
            return;
        }

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String output = String.format("""
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                    <meta charset="UTF-8">
                    <title>Member Information</title>
                </head>
                <body>
                
                <h1>Member Information</h1>
                
                <ul>
                    <li>Username: %s</li>
                    <li>Name: %s</li>
                    <li>Email: %s</li>
                    <li>Created At: %s</li>
                </ul>
                
                </body>
                </html>
                """, memberVo.getUsername(), memberVo.getName(), memberVo.getEmail(), memberVo.getCreatedAt());

        out.println(output);
        out.close();
    }
}