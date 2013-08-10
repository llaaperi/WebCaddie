<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Rounds</title>
</head>
<body>
<h1>
	Rounds 
</h1>

<!-- <a href="javascript:void(0)" onClick="popup();">Add new</a> -->
<a href="newRound">Add new</a> 

<c:if test="${not empty rounds}">
    <table border="1">
		<tr>
			<th>ID</th>
			<th>Date</th>
	        <th>Course</th>
	        <th>Score</th>
	        <th>BP</th>  
        </tr>
        <c:forEach var="round" items="${rounds}">
            <tr>
                <td>${round.getId()}</td>
                <td><a href="<c:url value="viewRound?id=${round.getId()}"/>">${round.getDateString()}</a></td>
                <td>${round.getCourse().getName()}</td>
                <td>${course.getScore()}</td>
                <td>1</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
