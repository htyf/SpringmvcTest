<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery.js"></script>
<script>
    $(function(){
        $("#testJson").click(function(){
            var url = this.href;
            var args = {};
            $.post(url, args, function(data){
                for(var i=0; i<data.length; i++){
                    var id = data[i].id;
                    var lastName = data[i].lastName;
                    alert(id + ": " + lastName);
                }
            })
            return false;
        })
    })
</script>
<title>REST风格的CRUD</title>
</head>
<body>
<a href="emps/getAll">list all employees</a><br/>

<a href="emps/testJson" id="testJson">testJson</a>
<br><br>

<!-- 文件上传 -->
<form action="emps/testFileUpload" method="POST" enctype="multipart/form-data">
    File: <input type="file" name="file"/>
    Desc: <input type="text" name="desc"/>
    <input type="submit" value="Submit"/>
</form><br/>

<!-- 文件下载 -->
<a href="emps/testResponseEntity" id="testJson">testResponseEntity</a><br/>
</body>
</html>