<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="exception.jsp" %>
<%
    request.setCharacterEncoding("UTF-8");
    int num = Integer.parseInt(request.getParameter("num"));

    int sum = 0;
    for (int i = 1; i <= num; i++) sum += i;
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Calculate The Sum of Integers</title>
</head>
<body>

<h1>Sum of Integers</h1>

<p>
    The sum from 1 to <%= num %> is <%= sum %>.
</p>

</body>
</html>
