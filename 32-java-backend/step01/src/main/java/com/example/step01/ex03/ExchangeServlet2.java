package com.example.step01.ex03;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/exchange2")
public class ExchangeServlet2 extends HttpServlet {
    private static final double USD_RATE = 0.00068;
    private static final double EUR_RATE = 0.00058;
    private static final double JPY_RATE = 0.106;
    private static final double CNY_RATE = 0.00475;

    public ExchangeServlet2() {
        super();
        System.out.println("CALL: ExchangeServlet2#ExchangeServlet()");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("CALL: ExchangeServlet2#init()");
    }

    @Override
    public void destroy() {
        System.out.println("CALL: ExchangeServlet2#destroy()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: ExchangeServlet2#doGet()");

        request.setCharacterEncoding("UTF-8");

        String command = request.getParameter("command");
        String krw = request.getParameter("krw");
        String currency = request.getParameter("currency");

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
                """;

        if (command != null && command.equals("calculate")) {
            double exchangeRate = switch (currency) {
                case "usd" -> USD_RATE;
                case "eur" -> EUR_RATE;
                case "jpy" -> JPY_RATE;
                case "cny" -> CNY_RATE;
                default -> 0;
            };

            double amount = Integer.parseInt(krw) * exchangeRate;

            output += String.format("<p>KRW %s = %s %.2f</p>", krw, currency.toUpperCase(), amount);
        }

        output += """
                <form action="exchange2" method="get">
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
        System.out.println("CALL: ExchangeServlet2#doPost()");
    }
}