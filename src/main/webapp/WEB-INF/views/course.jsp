<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Course</title>
<script type="text/javascript">
function closeSelf(){
    
	boolean valid = false;
    if(valid){
       alert("Adding new course");
       document.forms['courseForm'].submit();
       self.close();
    }else{
       alert("Invalid form");
    }
}
</script>

</head>
<body>
<h1>
	Add new course
</h1>

<form:form modelAttribute="course" action="saveCourse" method="POST" >
	<form:input type="hidden" path="id"/>
	
	<table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="slope">Slope</form:label></td>
        <td><form:input path="slope" /></td>
    </tr>
	</table>
	
	<table border="1">
		<!-- HOLE NUMBER -->
		<tr>
			<th>Hole</th>
			<c:forEach var="i" begin="1" end="18">
				<c:if test="${i==10}">
					<th>Out</th>
				</c:if>
				<th><c:out value="${i}"/></th>
			</c:forEach>
			<th>In</th>
		</tr>
		<!-- LENGTH -->
		<tr>
			<th rowspan="3">Length</th>
			<c:forEach items="${course.holes}" var="hole" varStatus="status">
				<c:if test="${status.index==9}">
					<td>sum</td>
				</c:if>
				<td><input name="holes[${status.index}].lenWhite" value="${hole.lenWhite}" maxlength="3" size="3"/></td>
			</c:forEach>
			<td>sum</td>
		</tr>
		<tr bgcolor="#FFFF00">
			<c:forEach items="${course.holes}" var="hole" varStatus="status">
				<c:if test="${status.index==9}">
					<td>sum</td>
				</c:if>
				<td><input name="holes[${status.index}].lenYellow" value="${hole.lenYellow}" maxlength="3" size="3"/></td>
			</c:forEach>
			<td>sum</td>
		</tr>
		<tr bgcolor="FF0000">
			<c:forEach items="${course.holes}" var="hole" varStatus="status">
				<c:if test="${status.index==9}">
					<td>sum</td>
				</c:if>
				<td><input name="holes[${status.index}].lenRed" value="${hole.lenRed}" maxlength="3" size="3"/></td>
			</c:forEach>
			<td>sum</td>
		</tr>
		<!-- PAR -->
		<tr>
			<th>Par</th>
			<c:forEach items="${course.holes}" var="hole" varStatus="status">
				<c:if test="${status.index==9}">
					<td>sum</td>
				</c:if>
				<td><input name="holes[${status.index}].par" value="${hole.par}" maxlength="2" size="2"/></td>
			</c:forEach>
			<td>sum</td>
		</tr>
	
	</table>
	<input type="submit" value="Save course"/>
</form:form>


</body>
</html>
