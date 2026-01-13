package com.example.step04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getCookie")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("CALL: GetCookieServlet#doGet()");

        request.setCharacterEncoding("UTF-8");

        Cookie[] cookies = request.getCookies();

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        StringBuilder output = new StringBuilder("""
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                    <meta charset="UTF-8">
                    <title>Set Cookie</title>
                </head>
                <body>
                
                <h1>Set Cookie</h1>
                
                <ul>
                """);

        for (Cookie cookie : cookies) {
            output.append(String.format("<li>%s = \"%s\"</li>",
                    cookie.getName(), URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8)));
        }

        output.append("</ul></body></html>");

        out.println(output);
        out.close();
    }
}