<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database Connection</title>
</head>
<body>
<div align = "center">
<h1>User Login</h1>
<form action = "LoginServlet" method = post>
<table>
<tr><td>Enter name:</td><td><input type = text name = textName></td></tr>
<tr><td>Enter marks:</td><td><input type = text name = textMarks></td></tr>
<tr><td><input type = submit value = Login></td><td><input type = reset></td></tr>

</table>
</form>
</div>
</body>
</html>