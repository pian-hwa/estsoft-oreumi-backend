package com.example.step03.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getContext")
public class GetContextServlet extends HttpServlet {
    public GetContextServlet() {
        super();
        System.out.println("CALL: GetContextServlet#GetContextServlet()");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("CALL: GetContextServlet#init()");
    }

    @Override
    public void destroy() {
        System.out.println("CALL: GetContextServlet#destroy()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: GetContextServlet#doGet()");

        ServletContext servletContext = getServletContext();
        List<?> memberList = (List<?>) servletContext.getAttribute("memberList");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        String output = String.format("""
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                    <meta charset="UTF-8">
                    <title>Get ServletContext</title>
                </head>
                <body>
                
                <h1>Get ServletContext</h1>
                
                <ul>
                    <li>%s</li>
                    <li>%s</li>
                </ul>
                
                </body>
                </html>
                """, memberList.get(0), memberList.get(1));

        out.println(output);
        out.close();
    }
}