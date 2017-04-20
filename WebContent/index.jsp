<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
hello <br>
<a href="user/variable/1">testPathVariable</a><br/><br/>
	
<a href="user/param?username=jackie&age=12">testRequestParam</a><br/><br/>

<a href="user/testCookieValue">testCookieValue</a><br/><br/>

<a href="user/testRequestHeader">testRequestHeader</a><br/><br/>

<form action="user/testPojo" method="post">
    username: <input type="text" name="username"><br>
    password: <input type="password" name="password"><br>
    email: <input type="text" name="email"><br>
    age: <input type="text" name="age"><br>
    city: <input type="text" name="address.city"><br>
    province: <input type="text" name="address.province"><br>
    <input type="submit" value="submit">
</form><br/><br/>


<a href="user/testModelAndView">testModelAndView</a><br/><br/>

<a href="user/i18n?locale=zh_CN">中文</a>
<br><br>
 
<a href="user/i18n?locale=en_US">英文</a>

</body>
</html>