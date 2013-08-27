<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><sitemesh:write property='title'/></title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/style.css" />
        <sitemesh:write property='head'/>
	</head>  
	
	<body>
		
		<div id='container_div'>
		
			<div id="header_div">
			
				<div id="title_div">
					<H1>WebCaddie</H1>
				</div>
        		
        		<div id="login_div">
					<sec:authorize var="loggedIn" access="isAuthenticated()" />
					<c:choose>
						<c:when test="${loggedIn}">
							You are logged in as <sec:authentication property="principal.username"/>
	     			 		<a href="<c:url value="j_spring_security_logout"/>">Logout</a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/user-login"/>">Login</a>
							<a href="<c:url value="/user-register"/>">Register</a>
						</c:otherwise>
					</c:choose>
				</div>
    		</div>
    		
    		<div id="navigation_div">
    			<a class='navlink' href="${pageContext.request.contextPath}">Home</a>
        		<a class='navlink' href="${pageContext.request.contextPath}/courses">Courses</a>
        		<a class='navlink' href="${pageContext.request.contextPath}/rounds">Rounds</a>
    		</div>
    		
    		<div id="content_div">
    			<sitemesh:write property='body'/>
    		</div>
    		
	    	<div id="footer_div">
	        	Copyright 2013 Lauri Laaperi - All Rights Reserved
	    	</div>
	    	
		</div>
	</body>
</html> 