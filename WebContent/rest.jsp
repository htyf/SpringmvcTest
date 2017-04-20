<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="rest/testRestPut/1" method="post">
		<input type="hidden" name="_method" value="PUT" /> <input
			type="submit" value="testRestPut" />
	</form>
	<br />
	<br />

	<form action="rest/testRestDelete/1" method="post">
		<input type="hidden" name="_method" value="DELETE" /> <input
			type="submit" value="TestRest DELETE" />
	</form>
	<br>
	<br>

	<form action="rest/testRestPost/2" method="post">
		<input type="submit" value="testRestPost">
	</form>
	<br />
	

	<a href="rest/testRest/1">testRest</a><br />
	
	
	
	
	<br />
	<br />
</body>
</html>