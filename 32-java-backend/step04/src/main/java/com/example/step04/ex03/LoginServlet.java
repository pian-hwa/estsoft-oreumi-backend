package com.example.step04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: LoginServlet#doGet()");

        printErrorPage(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: LoginServlet#doPost()");

        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null) {
            printErrorPage(request, response);
            return;
        }

        MemberVo memberVo = new MemberVo();
        memberVo.setUsername(username);
        memberVo.setPassword(password);

        MemberDao memberDao = new MemberDao();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String output = """
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                    <meta charset="UTF-8">
                    <title>Log-in Status</title>
                </head>
                <body>
                
                <h1>Log-in Status</h1>
                """;

        if (memberDao.isValidLogin(memberVo)) {
            HttpSession session = request.getSession();
            session.setAttribute("isLoggedIn", true);
            session.setAttribute("username", username);

            output += String.format("""
                    <p>You have logged in <code>%s</code>.</p>
                    <p><a href="viewMember">View member information</a></p>
                    """, username);
        } else {
            output += """
                    <p>Invalid username or password.</p>
                    <p><a href="login.html">Please log in again.</a></p>
                    """;
        }

        output += "</body></html>";

        out.println(output);
        out.close();


    }

    /**
     * 오류 페이지 출력
     * 
     * @param request HttpServletRequest 인스턴스
     * @param response HttpServletResponse 인스턴스
     */
    protected void printErrorPage(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String output = """
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                    <meta charset="UTF-8">
                    <title>Log-in Status</title>
                </head>
                <body>
                
                <h1>Log-in Status</h1>
                
                <p>Invalid access!</p>
                <p><a href="login.html">Please log in again.</a></p>
                
                </body>
                </html>
                """;

        out.println(output);
        out.close();
    }
}