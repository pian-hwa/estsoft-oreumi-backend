package com.example.step01.ex04;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet {
    public LoginServlet4() {
        super();
        System.out.println("CALL: LoginServlet4#LoginServlet()");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("CALL: LoginServlet4#init()");
    }

    @Override
    public void destroy() {
        System.out.println("CALL: LoginServlet4#destroy()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: LoginServlet4#doGet()");

        doHandle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: LoginServlet4#doPost()");

        doHandle(request, response);
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // TODO: 비즈니스 로직(business login)

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String output = "<!DOCTYPE html>\n<html><head><meta charset\"UTF-8\">" +
                "<title>Your Request</title></head>" +
                "<body><h1>Your Request</h1>" +
                "<ul><li>Method: " + request.getMethod() + "</li>" +
                "<li>Username: " + username + "</li><li>Password: " + password + "</li>" +
                "</ul></body></html>";

        out.print(output);

        out.close();
    }
}