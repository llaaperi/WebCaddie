<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Round</title>
</head>
<body>
<h1>
	Round 
</h1>
<form:form modelAttribute="round" action="saveRound" method="POST" >
	<form:input type="hidden" path="id"/>
	<input type="submit" value="Save round"/>
</form:form>
</body>
</html>
