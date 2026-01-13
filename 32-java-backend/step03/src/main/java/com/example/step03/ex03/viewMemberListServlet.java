package com.example.step03.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewMemberList")
public class viewMemberListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("CALL: viewMemberList#doGet()");

        /* List의 참조 자료형이 MemberVo로 고정된 상황에만 사용! 컴파일러에게 오류를 표시하지 않도록 설정
        @SuppressWarnings("unchecked")
        List<MemberVo> memberList = (List<MemberVo>)request.getAttribute("memberList");
         */
        
        List<?> memberList = (List<?>) request.getAttribute("memberList");

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
    private StringBuilder getOutput(List<?> memberList) {
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

        for (Object obj : memberList) {
            if (obj instanceof MemberVo memberVo) {
                output.append(String.format("""
                            <tr>
                                <td>%d</td>
                                <td>%s</td>
                                <td>%s</td>
                                <td>%s</td>
                                <td>%s</td>
                                <td>%s</td>
                            </tr>
                        """, memberVo.getId(),memberVo.getUsername(), memberVo.getPassword(),
                        memberVo.getName(), memberVo.getEmail(), memberVo.getCreatedAt()));
            }
        }

        output.append("""
                    </tbody>
                </table>
                
                </body>
                </html>
                """);

        return output;
    }
}