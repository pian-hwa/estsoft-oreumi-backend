package com.example.step02.ex04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/member4")
public class MemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("CALL: MemberServlet4#doGet()");

        request.setCharacterEncoding("UTF-8");

        String command = request.getParameter("command");
        String id = request.getParameter("id");

        if (command != null && command.equals("delete") && id != null) {
            MemberDao memberDao = new MemberDao();
            memberDao.deleteMember(id);
        }

        printMemberList(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: MemberServlet4#doPost()");

        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if (username != null && password != null && name != null && email != null) {
            MemberVo memberVo = new MemberVo(0, username, password, name, email, null);

            MemberDao memberDao = new MemberDao();

            memberDao.insertMember(memberVo);
        }

        printMemberList(request, response);
    }

    /**
     * 회원 목록을 클라이언트에 응답
     */
    protected void printMemberList(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        MemberDao memberDao = new MemberDao();
        List<MemberVo> memberList = memberDao.getMemberList();

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print(getOutput(memberList));
        out.close();
    }

    /**
     * HTML 형식으로 회원 목록을 생성
     *
     * @param memberList 회원 목록
     * @return HTML 형식의 문자열
     */
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
                            <th>Delete</th>
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
                            <td><a href="member4?command=delete&id=%d">[X]</a></td>
                        </tr>
                    """, memberVo.getId(),memberVo.getUsername(), memberVo.getPassword(),
                                    memberVo.getName(), memberVo.getEmail(), memberVo.getCreatedAt(), memberVo.getId()));
        }

        output.append("""
                    </tbody>
                </table>
                
                <p>
                    <a href="member-form.html">Membership Registration</a>
                </p>
                
                </body>
                </html>
                """);

        return output;
    }
}