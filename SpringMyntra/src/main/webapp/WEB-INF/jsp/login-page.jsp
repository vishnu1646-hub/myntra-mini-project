<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login page</title>
<style type="text/css">
table {
	padding: 10px;
	border: 2px solid #000000;
	border-radius: 5px;
}

table.logincenter {
	border: 5px solid black;
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
<body>
	<form:form action="loginForm">
		<table class="logincenter">
			<caption>
				<h2>Login</h2>
			</caption>
			<tr>
				<td>Username<form:errors path="userName" /></td>
				<td>:<form:input path="userName" /></td>
			</tr>
			<tr>
				<td>Password<form:errors path="password" /></td>
				<td>:<form:password path="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="login"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>