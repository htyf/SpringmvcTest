<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示员工信息</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/scripts/jquery.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/resources/scripts/list.js"></script> --%>
<script type="text/javascript">
	$(function() {
		$(".delete").click(function() {
			var href = $(this).attr("href");
			$("form").attr("action", href).submit();
			return false;
		});
	})
</script>
</head>
<body>
	<c:if test="${empty requestScope.employees}">
        没有员工信息
    </c:if>
	<c:if test="${!empty requestScope.employees }">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<c:forEach items="${requestScope.employees }" var="emp">
				<tr>
					<td>${emp.id }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.gender==0?'Female':'Male' }</td>
					<td>${emp.department.departmentName }</td>
					<td><a href="emp/${emp.id}">Edit</a></td>
					<td><a class="delete" href="delete/${emp.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
	<br>
	<!-- 点击删除按钮提交delete请求时需要用到的表单 
	因为超链接只能发送get请求
	表单只能发送get和post请求
	要发送delete请求和put请求必须用以下方式
	-->
	<form action="" method="POST">
		<input type="hidden" name="_method" value="DELETE" />
	</form>

	<a href="emp">add new employee</a>
	<br />
</body>
</html>