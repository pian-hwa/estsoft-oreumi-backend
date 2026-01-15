package com.example.step05.ex07;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: MemberController#doGet()");

        MemberDao memberDao = new MemberDao();

        String viewPage = "member-list";

        String action = request.getPathInfo().replace("/", "");
        System.out.println("action: " + action);
        request.setAttribute("action", action);

        switch (action) {
            case "register" ->
                viewPage = "member-form";
            case "update" -> {
                viewPage = "member-form";

                String username = request.getParameter("username");

                // TODO: username 정보가 유효한 값인지, members 테이블에 있는지 확인하고,
                //       그렇지 않으면 적절한 뒷처리를 한다.

                MemberVo memberVo = memberDao.getMember(username);
                request.setAttribute("memberVo", memberVo);
            }
            case "delete" -> {
                String id = request.getParameter("id");

                // TODO: id 정보가 유효한 값인지, members 테이블에 있는지 확인하고,
                //       그렇지 않으면 적절한 뒷처리를 한다.

                memberDao.deleteMember(id);

                response.sendRedirect(request.getContextPath() + "/member/list");
                return;
            }
        }

        if (viewPage.equals("member-list")) {
            List<MemberVo> memberList = memberDao.getMemberList();
            request.setAttribute("memberList", memberList);
        }

        String viewPageUri = String.format("/ex07/%s.jsp", viewPage);
        request.getRequestDispatcher(viewPageUri).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALL: MemberController#doPost()");

        MemberDao memberDao = new MemberDao();

        String action = request.getPathInfo().replace("/", "");
        System.out.println("action: " + action);

        // TODO: 클라이언트에서 전송한 데이터는 반드시 검증하고 사용한다.

        MemberVo memberVo = new MemberVo(
                0,
                request.getParameter("username"),
                request.getParameter("password"),
                request.getParameter("name"),
                request.getParameter("email"),
                null
        );

        if (action.equals("register")) {
            // TODO: username이나 email처럼 중복되면 안 되는 컬럼은 꼭 확인한다.

            memberDao.insertMember(memberVo);

            // TODO: 테이블에 새로운 레코드가 제대로 추가됐는지 확인한다.
        } else if (action.equals("update")) {
            // TODO: username 정보가 members 테이블에 있는지 확인한다.
            // TODO: username이나 email처럼 중복되면 안 되는 컬럼은 꼭 확인한다.

            memberDao.updateMember(memberVo);

            // TODO: 테이블에 새로운 레코드가 제대로 갱신됐는지 확인한다.
        }

        response.sendRedirect(request.getContextPath() + "/member/list");
    }
}