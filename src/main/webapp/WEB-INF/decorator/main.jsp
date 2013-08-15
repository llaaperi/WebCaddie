<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><sitemesh:write property='title'/></title>
        <link rel="stylesheet" type="text/css" href="resources/styles/style.css" />
        <sitemesh:write property='head'/>  
	</head>  
	
	<body>
		
		<div id='container'>
		
			<div id="header">
        		<H1>WebCaddie</H1>
        		
				<sec:authorize var="loggedIn" access="isAuthenticated()" />
				<c:choose>
					<c:when test="${loggedIn}">
						You are logged in as <sec:authentication property="principal.username"/>
     			 		<a href="<c:url value="j_spring_security_logout"/>">Logout</a>
					</c:when>
					<c:otherwise>
						<a href="<c:url value="spring_security_login"/>">Login</a>
					</c:otherwise>
				</c:choose>
    		</div>
    		
    		<div id="navigation">
    			<a class='navlink' href=".">Home</a>
        		<a class='navlink' href="courses">Courses</a>
        		<a class='navlink' href="rounds">Rounds</a>
    		</div>
    		
    		<div id="body">
    			<sitemesh:write property='body'/>
    		</div>
    		
	    	<div id="footer">
	        	Copyright 2013 Lauri Laaperi - All Rights Reserved
	    	</div>

		</div>
	</body>
</html> 