<%@ page contentType="text/html; charset=UTF-8"
         import="com.example.step05.ex02.*"
         import="java.util.List"
         pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");

    MemberDao memberDao = new MemberDao();
    List<MemberVo> memberList = memberDao.getMemberListByName(name);
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
    </tbody>
</table>

<p><a href="index.html">Lookup a Member</a></p>

</body>
</html>
