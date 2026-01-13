package com.example.step04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("CALL: SessionServlet#doGet()");

        HttpSession session = request.getSession();

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print(getOutput(session));
        out.close();
    }

    private String getOutput(HttpSession session) {
        String output = """
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                    <meta charset="UTF-8">
                    <title>Session Test</title>
                </head>
                <body>
                
                <h1>Session Test</h1>
                """;

        output += session.isNew() ?
                "<p>A new session has been created.</p>" :
                "<p>Reuse the previously created session.</p>";

        output += String.format("""
                <ul>
                    <li>Session ID: %s</li>
                    <li>Session creation time: %s</li>
                    <li>Last session access time: %s</li>
                    <li>Session active interval: %d seconds</li>
                </ul>
                
                </body>
                </html>
                """, session.getId(), new Date(session.getCreationTime()),
                            new Date(session.getLastAccessedTime()), session.getMaxInactiveInterval());

        return output;
    }
}