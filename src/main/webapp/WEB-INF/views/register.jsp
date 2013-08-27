<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Register page</title>
		<style>
			.error {
				color: red;
			}
		</style>
	</head>
	
	<body>
		<h1>
			Register
		</h1>
		<form:form modelAttribute="user" action="user-save" method="POST">
			<table>
				<tbody>
					<tr>
					<td><form:label path="login">Username:</form:label></td>
					<td><form:input path="login" type="text" size="30" maxlength="40"/></td>
					</tr>
					<tr>
					<td><form:label path="password">Password:</form:label></td>
					<td><form:input path="password" type="password" size="30" maxlength="32" /></td>
					</tr>
					<tr>
					<td></td>
					<td></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" value="Register" />
		</form:form>
	</body>
</html>