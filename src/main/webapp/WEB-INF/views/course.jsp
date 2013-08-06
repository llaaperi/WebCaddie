<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
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

<form:form name="courseForm" action="saveCourse" method="POST" >
	<form:input type="hidden" path="id"/>
	<table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="par">Par</form:label></td>
        <td><form:input path="par" /></td>
    </tr>
    <tr>
        <td><form:label path="slope">Slope</form:label></td>
        <td><form:input path="slope" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Save course"/>
        </td>
    </tr>
	</table>  
</form:form>


</body>
</html>
