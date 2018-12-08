<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%-- jstl 与 tomacat7 问题 重要--%>
<head>
    <title>用户列表</title>
</head>
<body>
<table border="1">
    <tr>
        <td>用户ID</td>
        <td>用户名</td>
        <td>密码</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>
                <a href="grantRoleView?id=${user.id}">赋予角色</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="add-user.jsp">添加用户</a>
</body>


</html>
