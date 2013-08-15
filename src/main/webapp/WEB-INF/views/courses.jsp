<script type="text/javascript">
<!--

//-->
function popup(){
	window.open("course", "window", "width=300,height=200");
}
</script>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Courses 
</h1>

<!-- <a href="javascript:void(0)" onClick="popup();">Add new</a> -->
<a href="<c:url value="/courses/newCourse"/>">Add new</a> 

<c:if test="${not empty courses}">
    <table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
	        <th>Par</th>
	        <th>Slope</th>  
        </tr>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.getId()}</td>
                <td><a href="<c:url value="/courses/viewCourse?id=${course.getId()}"/>">${course.getName()}</a></td>
                <td>${course.getPar()}</td>
                <td>${course.getSlope()}</td>
                <td><a href="<c:url value="/courses/deleteCourse?id=${course.getId()}"/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
