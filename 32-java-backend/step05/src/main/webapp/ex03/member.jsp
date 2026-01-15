<%@ page contentType="text/html; charset=UTF-8"
         import="com.example.step05.ex02.*"
         import="java.util.List"
         pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");

    MemberVo param = new MemberVo();
    param.setUsername(request.getParameter("username"));
    param.setPassword(request.getParameter("password"));
    param.setName(request.getParameter("name"));
    param.setEmail(request.getParameter("email"));

    MemberDao memberDao = new MemberDao();

    if (param.getUsername() != null) { memberDao.insertMember(param); }

    List<MemberVo> memberList = memberDao.getMemberList();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
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
    <% if (memberList.isEmpty()) { %>
        <tr>
            <td colspan="6">There are no registered members.</td>
        </tr>
    <% } else { %>
        <% for (MemberVo memberVo : memberList) { %>
            <tr>
                <td><%= memberVo.getId() %></td>
                <td><%= memberVo.getUsername() %></td>
                <td><%= memberVo.getPassword() %></td>
                <td><%= memberVo.getName() %></td>
                <td><%= memberVo.getEmail() %></td>
                <td><%= memberVo.getCreatedAt() %></td>
            </tr>
        <% } %>
    <% } %>
    </tbody>
</table>

<p><a href="member-form.html">Register New Member</a></p>

</body>
</html>
