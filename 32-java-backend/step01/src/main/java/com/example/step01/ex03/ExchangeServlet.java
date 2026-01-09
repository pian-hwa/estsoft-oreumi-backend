package com.example.step01.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exchange")
public class ExchangeServlet extends HttpServlet {
    public ExchangeServlet() {
        super();
        System.out.println("CALL: ExchangeServlet#ExchangeServlet()");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("CALL: ExchangeServlet#init()");
    }

    @Override
    public void destroy() {
        System.out.println("CALL: ExchangeServlet#destroy()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: ExchangeServlet#doGet()");

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        String output = """
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                    <meta charset="UTF-8">
                    <title>Currency Exchange Calculation</title>
                </head>
                <body>
                
                <h1>Currency Exchange Calculation</h1>
                
                <form action="exchange" method="get">
                    <input type="hidden" name="command" value="calculate">
                    KRW <input type="text" name="krw"> to
                    <select name="currency">
                        <option value="usd">US Dollar</option>
                        <option value="eur">Euro</option>
                        <option value="jpy">Japan Yen</option>
                        <option value="cny">China Yuan</option>
                    </select>
                
                    <input type="submit" name="calc" value="Calculate">
                </form>
                
                </body>
                </html>
                """;
        out.print(output);

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: ExchangeServlet#doPost()");
    }
}