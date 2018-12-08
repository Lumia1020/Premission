<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<table border="1">
    <tr>
        <td>角色ID</td>
        <td>角色名</td>
        <td>角色描述</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${roles}" var="role">
        <tr>
            <td>${role.id}</td>
            <td>${role.name}</td>
            <td>${role.description}</td>
            <td>
                <a href="grantPermissionView?id=${role.id}">赋予角色权限</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="add-role.jsp">添加角色</a>
</body>


</html>
