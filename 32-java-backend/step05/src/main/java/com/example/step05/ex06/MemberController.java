package com.example.step05.ex06;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: MemberController#doGet()");

        MemberDao memberDao = new MemberDao();
        List<MemberVo> memberList = memberDao.getMemberList();

        request.setAttribute("memberList", memberList);
        request.getRequestDispatcher("/ex06/member-list.jsp").forward(request, response);
    }
}