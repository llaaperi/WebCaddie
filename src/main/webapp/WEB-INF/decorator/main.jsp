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
    		</div>
    		
    		<div id="navigation">
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