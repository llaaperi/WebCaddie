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
	<form:input type="hidden" path="courseId" value="${round.course.id}"/>
	
	<c:out value="${round.course.name}"/>
	
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
				<c:forEach items="${round.course.holes}" var="hole" varStatus="status">
					<c:if test="${status.index==9}">
						<td>${round.course.getLengthWhite9()}</td>
					</c:if>
					<td>${hole.lenWhite}</td>
				</c:forEach>
				<td>${round.course.getLengthWhite18()}</td>
				<td>${round.course.getLengthWhite()}</td>
			</tr>
			<tr bgcolor="#FFFF00">
				<c:forEach items="${round.course.holes}" var="hole" varStatus="status">
					<c:if test="${status.index==9}">
						<td>${round.course.getLengthYellow9()}</td>
					</c:if>
					<td>${hole.lenYellow}</td>
				</c:forEach>
				<td>${round.course.getLengthYellow18()}</td>
				<td>${round.course.getLengthYellow()}</td>
			</tr>
			<tr bgcolor="FF0000">
				<c:forEach items="${round.course.holes}" var="hole" varStatus="status">
					<c:if test="${status.index==9}">
						<td>${round.course.getLengthRed9()}</td>
					</c:if>
					<td>${hole.lenRed}</td>
				</c:forEach>
				<td>${round.course.getLengthRed18()}</td>
				<td>${round.course.getLengthRed()}</td>
			</tr>
			<!-- PAR -->
			<tr>
				<th>Par</th>
				<c:forEach items="${round.course.holes}" var="hole" varStatus="status">
					<c:if test="${status.index==9}">
						<td id="parSum9">${round.course.getPar9()}</td>
					</c:if>
					<td id='par${status.index}'>${hole.par}</td>
				</c:forEach>
				<td id="parSum18">${round.course.getPar18()}</td>
				<td id="parSum">${round.course.getPar()}</td>
			</tr>
			<!-- HANDICAP -->
			<tr>
				<th>HCP</th>
				<c:forEach items="${round.course.holes}" var="hole" varStatus="status">
					<c:if test="${status.index==9}">
						<td></td>
					</c:if>
					<td>${hole.hcp}</td>
				</c:forEach>
				<td></td>
			</tr>
			<!-- STROKES -->
			<tr>
			<th>Strokes</th>
			<c:forEach var="i" begin="0" end="17">
				<c:if test="${i==9}">
					<td></td>
				</c:if>
				<td><input name='strokes[${i}]' value='${round.strokes[i]}' maxlength='2' size='2'/></td>
			</c:forEach>
			<td></td>
			</tr>
			<!-- Points -->
			<tr>
				<th>Points</th>
				<c:forEach items="${round.course.holes}" var="hole" varStatus="status">
					<c:if test="${status.index==9}">
						<td id="pointSum9">&nbsp;</td>
					</c:if>
					<td id='point${status.index}'>0</td>
				</c:forEach>
				<td id="pointSum18">&nbsp;</td>
				<td id="pointSum">&nbsp;</td>
			</tr>
		</table>
	
	<input type="submit" value="Save round"/>
</form:form>
</body>
</html>
