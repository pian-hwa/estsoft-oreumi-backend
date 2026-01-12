package com.example.step03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("CALL: SecondServlet#doGet()");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        String output = """
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                    <meta charset="UTF-8">
                    <title>Dispatch Forward Test</title>
                </head>
                <body>
                
                <h1>Dispatch Forward Test</h1>
                
                </body>
                </html>
                """;

        out.println(output);
        out.close();
    }
}