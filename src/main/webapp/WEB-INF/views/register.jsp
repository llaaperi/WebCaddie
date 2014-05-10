<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Register page</title>
	</head>

	<body>
		
		<h1>Register</h1>
		
		<p>
		Register new agent. You receive agent ID after you have registered successfully.
		</p>
		<div class="register">
			<form role="form" action="registerUser" method="POST">
				<div class="form-group">
						<label for="login">Username</label>
						<input id="login" name="login" type="text" class="form-control" placeholder="Username" size="30" maxlength="40"  />
					</div>
					
					<div class="form-group">
						<label for="password">Password</label>
						<input id="password" name="password" type="password" class="form-control" size="30" maxlength="32" placeholder="Password"/>
					</div>
				<button type="submit" class="btn btn-default">Register</button>
			</form>
		</div>
		
	</body>
</html>