<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Course</title>
<script type="text/javascript">

/*
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
*/
function updateAll(){
	updateSum("white");
	updateSum("yellow");
	updateSum("red");
	updateSum("par");
}
function updateSum(id){
	var sum = 0;
	var sum9 = 0;
	for(var i = 0; i < 18; i++){
		sum += Number(document.getElementById(id+i).value);
		if(i==8){
			document.getElementById(id+"Sum9").innerHTML = sum;
			sum9 = sum;
		}
	}
	document.getElementById(id+"Sum18").innerHTML = sum - sum9;
	document.getElementById(id+"Sum").innerHTML = sum;
}
</script>

</head>
<body onload="updateAll();">
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
		<!-- HOLE NUMBERS AND HEADERS -->
		<tr>
			<th>Hole</th>
			<c:forEach var="i" begin="1" end="18">
				<c:if test="${i==10}">
					<th>Out</th>
				</c:if>
				<th><c:out value="${i}"/></th>
			</c:forEach>
			<th>In</th>
			<th>Total</th>
		</tr>
		<!-- LENGTH -->
		<tr>
			<th rowspan="3">Length</th>
			<c:forEach items="${course.holes}" var="hole" varStatus="status">
				<c:if test="${status.index==9}">
					<td id="whiteSum9">&nbsp;</td>
				</c:if>
				<td><input id='white${status.index}' name="holes[${status.index}].lenWhite" value="${hole.lenWhite}" onChange='updateSum("white");' maxlength="3" size="1"/></td>
			</c:forEach>
			<td id="whiteSum18">&nbsp;</td>
			<td id="whiteSum">&nbsp;</td>
		</tr>
		<tr bgcolor="#FFFF00">
			<c:forEach items="${course.holes}" var="hole" varStatus="status">
				<c:if test="${status.index==9}">
					<td id="yellowSum9">&nbsp;</td>
				</c:if>
				<td><input id='yellow${status.index}' name="holes[${status.index}].lenYellow" value="${hole.lenYellow}" onChange='updateSum("yellow");' maxlength="3" size="1"/></td>
			</c:forEach>
			<td id="yellowSum18">&nbsp;</td>
			<td id="yellowSum">&nbsp;</td>
		</tr>
		<tr bgcolor="FF0000">
			<c:forEach items="${course.holes}" var="hole" varStatus="status">
				<c:if test="${status.index==9}">
					<td id="redSum9">&nbsp;</td>
				</c:if>
				<td><input id='red${status.index}' name='holes[${status.index}].lenRed' value='${hole.lenRed}' onChange='updateSum("red");' maxlength='3' size='1'/></td>
			</c:forEach>
			<td id="redSum18">&nbsp;</td>
			<td id="redSum">&nbsp;</td>
		</tr>
		<!-- PAR -->
		<tr>
			<th>Par</th>
			<c:forEach items="${course.holes}" var="hole" varStatus="status">
				<c:if test="${status.index==9}">
					<td id="parSum9">&nbsp;</td>
				</c:if>
				<td><input id='par${status.index}' name='holes[${status.index}].par' value='${hole.par}' onChange='updateSum("par");' maxlength='2' size='1'/></td>
			</c:forEach>
			<td id="parSum18">&nbsp;</td>
			<td id="parSum">&nbsp;</td>
		</tr>
		<!-- HANDICAP -->
		<tr>
			<th>HCP</th>
			<c:forEach items="${course.holes}" var="hole" varStatus="status">
				<c:if test="${status.index==9}">
					<td></td>
				</c:if>
				<td><input name='holes[${status.index}].hcp' value='${hole.hcp}' maxlength='2' size='1'/></td>
			</c:forEach>
			<td></td>
		</tr>
	
	</table>
	<input type="submit" value="Save course"/>
</form:form>


</body>
</html>
