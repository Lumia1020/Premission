<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加权限</title>
</head>
<body>
<form method="post" action="addPermission">
    <p> <label for="name">权限名：</label> <input type="text" name="name" id="name"></p>
    <p> <label for="description">权限描述：</label>
        <textarea name="description" id="description" cols="30" rows="10"></textarea>
    </p>
    <p> <input type="submit" value="提交"/> <input type="reset" value="重置"> </p>
</form>
</body>
</html>