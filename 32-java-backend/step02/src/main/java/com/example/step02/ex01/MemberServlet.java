package com.example.step02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: MemberServlet#doGet()");

        MemberDao memberDao = new MemberDao();
        List<MemberVo> memberList = memberDao.getMemberList();

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print(getOutput(memberList));
        out.close();
    }

    private StringBuilder getOutput(List<MemberVo> memberList) {
        StringBuilder output = new StringBuilder("""
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                    <meta charset="UTF-8">
                    <title>Member List</title>
                </head>
                <body>
                
                <h1>Member List</h1>
                
                <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Created At</th>
                        </tr>
                    </thead>
                    <tbody>
                """);

        for (MemberVo memberVo : memberList) {
            output.append(String.format("""
                        <tr>
                            <td>%d</td>
                            <td>%s</td>
                            <td>%s</td>
                            <td>%s</td>
                            <td>%s</td>
                            <td>%s</td>
                        </tr>
                    """, memberVo.getId(),memberVo.getUsername(), memberVo.getPassword(), memberVo.getName(),
                                    memberVo.getEmail(), memberVo.getCreatedAt()));
        }

        output.append("</tbody></table></body></html>");

        return output;
    }
}