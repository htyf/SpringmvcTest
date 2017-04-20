<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="add" method="POST" modelAttribute="employee">
		<!-- path 属性对应 html 表单标签的 name 属性值 -->
            LastName: <form:input path="lastName" />
		<br>
    Email:<form:input path="email"></form:input>
		<br>

		<%
			Map<String, String> genders = new HashMap<String, String>();
				genders.put("1", "male");
				genders.put("0", "female");
				request.setAttribute("genders", genders);
		%>
    Gender:<form:radiobuttons path="gender" items="${genders }" />
		<br>
    Department:<form:select path="department.id" items="${departments }"
			itemLabel="departmentName" itemValue="id"></form:select>
		<br>
		<input type="submit" value="Submit" />
	</form:form>




	<%-- 
 为什么使用form标签:可以更快速开发表单页面，而且可以方便的进行表单值的回显
 <form:radiobuttons>这个标签中有一下属性：

　　　　items：存放具体的数据集合，可以是String、Map或List类型

　　　　itemValue：指定radio的value值，可以使集合中bean的一个属性值

　　　　itemLabel：radio的label值
  --%>
</body>
</html>