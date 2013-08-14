<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Rounds</title>
</head>
<body>

<script type="text/javascript">
	
function selectCourse(){
	var courseId = document.getElementById("course").value;
	//alert(courseId);
	window.location = "newRound?courseId=" + courseId;
}

</script>

<h1>
	Rounds 
</h1>

<!-- <a href="javascript:void(0)" onClick="popup();">Add new</a> -->
<c:out value="Add new round by selecting course: " />
<select name="course" onchange="selectCourse();">
	<option value="0" selected="selected">Select course</option>
	<c:forEach items="${courses}" var="course">
        <option value="${course.id}"><c:out value="${course.name}" /></option>
    </c:forEach>
</select>
<!--<a href="<c:url value="newRound?courseId=${round.getId()}"/>">Add new</a>  -->

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
                <td><a href="<c:url value="deleteRound?id=${round.getId()}"/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
