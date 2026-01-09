package com.example.step01.ex04;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login3")
public class LoginServlet3 extends HttpServlet {
    public LoginServlet3() {
        super();
        System.out.println("CALL: LoginServlet3#LoginServlet()");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("CALL: LoginServlet3#init()");
    }

    @Override
    public void destroy() {
        System.out.println("CALL: LoginServlet3#destroy()");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: LoginServlet3#doPost()");

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
                "<ul><li>Username: " + username + "</li><li>Password: " + password + "</li>" +
                "</ul></body></html>";

        out.print(output);

        out.close();
    }
}