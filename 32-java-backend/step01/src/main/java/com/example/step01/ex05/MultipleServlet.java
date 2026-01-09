package com.example.step01.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multiple")
public class MultipleServlet extends HttpServlet {
    public MultipleServlet() {
        super();
        System.out.println("CALL: MultipleServlet#MultipleServlet()");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("CALL: MultipleServlet#init()");
    }

    @Override
    public void destroy() {
        System.out.println("CALL: MultipleServlet#destroy()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: MultipleServlet#doGet()");

        request.setCharacterEncoding("UTF-8");

        String number = request.getParameter("number");
        System.out.println("Number: " + number);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        StringBuilder output = new StringBuilder("""
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                    <meta charset="UTF-8">
                    <title>Multiplication Table</title>
                </head>
                <body>
                
                <h1>Multiplication Table</h1>
                """);

        if (number != null) {
            try {
                int paresdNumber = Integer.parseInt(number);

                if (paresdNumber < 2 || paresdNumber > 9) {
                    throw new RuntimeException();
                }

                output.append("<pre>");

                for (int i = 1; i <= 9; i++) {
                    output.append(String.format("%d * %d = %2d\n", paresdNumber, i, paresdNumber * i));
                }

                output.append("</pre>");
            } catch (Exception e) {
                output.append("<p>value is an invalid value.</p>");
            }
        }

        output.append("""
                <form action="multiple" method="get">
                    Multiplication table for
                    <input type="number" name="number" min="2" max="9" step="1">
                    <input type="submit" name="print" value="Print">
                </form>
                
                </body>
                </html>
                """);
        out.print(output);

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: MultipleServlet#doPost()");
    }
}