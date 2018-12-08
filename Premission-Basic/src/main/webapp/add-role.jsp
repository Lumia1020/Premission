<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加角色</title>
</head>
<body>
<form method="post" action="addRole">
   <p> <label for="name">角色名：</label> <input type="text" name="name" id="name"></p>
   <p> <label for="description">角色描述：</label> <input type="text" name="description" id="description"></p>
   <p> <input type="submit" value="提交"/> <input type="reset" value="重置"> </p>
</form>
</body>
</html>
