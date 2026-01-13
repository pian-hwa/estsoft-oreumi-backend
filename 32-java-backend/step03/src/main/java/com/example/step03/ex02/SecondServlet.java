package com.example.step03.ex02;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second2")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("CALL: SecondServlet2#doGet()");

        String name = (String)request.getAttribute("name");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        String output = String.format("""
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                    <meta charset="UTF-8">
                    <title>Dispatch Forward Test</title>
                </head>
                <body>
                
                <h1>Dispatch Forward Test</h1>
                
                <ul>
                    <li>Name: %s</li>
                </ul>
                
                </body>
                </html>
                """, name);

        out.println(output);
        out.close();
    }
}