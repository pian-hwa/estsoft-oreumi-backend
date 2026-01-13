package com.example.step03.ex03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: MemberServlet#doGet()");

        MemberDao memberDao = new MemberDao();
        List<MemberVo> memberList = memberDao.getMemberList();

        request.setAttribute("memberList", memberList);

        request.getRequestDispatcher("viewMemberList").forward(request, response);
    }
}