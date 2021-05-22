<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring Tiles Login Form</title>
<style type="text/css">
table {
	padding: 10px;
	border: 2px solid #000000;
	border-radius: 5px;
}

table.center {
	border: 5px solid black;
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
<body>
	<form:form action="save">
		<table class="center">
			<caption>
				<h2>Register</h2>
			</caption>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td>:<form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td>:<form:input path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td>:<form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="mobileNumber">MobileNumber</form:label></td>
				<td>:<form:input path="mobileNumber" /></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"><input type="submit" value="register" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>