<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<base href="${pageContext.request.contextPath}/"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><sitemesh:write property='title'/></title>
        <%-- contextPath is there because of path structure (webcaddie/something) --%>
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.0/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-spacelab.min.css" />
        <link rel="stylesheet" type="text/css" href="css/custom.css" />
        <!-- Scripts here because sitemesh is used -->
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script><!-- Must be defined before bootstrap -->
    	<script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.0/js/bootstrap.min.js"></script>
        <sitemesh:write property='head'/>
	</head>  
	
	<body>
		
		<div class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">WebCaddie</a>
				</div>
				
				<sec:authorize var="loggedIn" access="isAuthenticated()" />
				<sec:authorize var="isAdmin" access="hasRole('ROLE_ADMIN')" />
				
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li id="homePage"><a href="">Home</a></li>
						
						<c:if test="${loggedIn}">
							<li id="scoresPage"><a href="scores">Scores</a></li>
						</c:if>
						<!--
						<li id="registrarPage" class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Registrar <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="registrar">Agents</a></li>
								
								<c:if test="${isAdmin}">
									<li><a href="registrar/users">Users</a></li>
								</c:if>
								<c:if test="${!isAdmin}">
									<li class='disabled' id="usersPage"><a>Users</a></li>
								</c:if>
							</ul>
						</li>
						<li id="analyserPage"><a href="analyser">Analyser</a></li>
						<li id="simulatorPage"><a href="simulator">Simulator</a></li>
						 -->
						
					</ul>
					
					<div class="navbar-form navbar-right">
						<c:choose>
							<c:when test="${loggedIn}">
								You are logged in as <sec:authentication property="principal.username"/>
			    			 		<a href="<c:url value="j_spring_security_logout"/>">Logout</a>
			    			 		<br/>
			    			 		<a href="javascript:void(0)" onclick="openEditProfileModal('<sec:authentication property="principal.username"/>')">Edit profile</a>
							</c:when>
							<c:otherwise>
								<a href="<c:url value="login"/>" class="btn btn-primary">Login</a>
								<a href="<c:url value="register"/>" class="btn btn-default">Register</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div> <!-- /navbar -->
		
		<div id="wrap">
			<div id="main" class="container clear-top">
				<sitemesh:write property='body'/>
			</div>
		</div>
	   	
    	<footer class="footer text-center">
    		<hr>
        	<p>Copyright &copy; 2013 Lauri L‰‰peri</p>
    	</footer>
		
    	<script>
	    	$(document).ready(function() {
	    		//var path = location.pathname.match(/\/monitor\/(.*)/)[1];
	    		var path = location.pathname;
	    		if(path.match("/registrar")){
	    			$('.navbar li.active').removeClass('active');
	    			$('#registrarPage').addClass("active");
	    		}else
    			if(path.match("/analyser")){
	    			$('.navbar li.active').removeClass('active');
	    			$('#analyserPage').addClass("active");
	    		}else
	    		if(path.match("/simulator")){
	    			$('.navbar li.active').removeClass('active');
	    			$('#simulatorPage').addClass("active");
	    		}else{
	    			$('.navbar li.active').removeClass('active');
	    			$('#homePage').addClass("active");
	    		}
	    	});
	    	
	    	//Edit modal
			function openEditProfileModal(login) {
				console.log("Edit user: " + login);
				
				$("#user_edit_login").val('');
				$("#user_edit_email").val('');
				$("#user_edit_password").val('');
				
				$.ajax({
		            type: "GET",
		            url: "${pageContext.request.contextPath}/registrar/getUser",
		            data: {login: login},
		            success: function(response) {
		            	console.log(response);
		                var user = response;
						$("#user_edit_login").val(user.login);
						$("#user_edit_email").val(user.email);
		            }
		        }).done(function(){
		        	$("#editUserModal").modal('show');
		     	});
			}
	    	
    	</script>
    	
	</body>
</html> 