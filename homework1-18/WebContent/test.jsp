<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		在进行文件上传的时候, 必须使用:enctype="multipart/form-data"
	 -->
	<form action="${pageContext.request.contextPath }/FileUpLoadServlet" 
	method="post" enctype="multipart/form-data">
	
		昵称:<input type="text" name="nickname">
		<br>
		密码:<input type="password" name="password">
		<br>
		头像:<input type="file" name="img">
		<br>
		<input type="submit">
	
	
	</form>

</body>
</html>
