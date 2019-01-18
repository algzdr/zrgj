<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/updateInfoServlet" method="post">
		用户id：<input type="text" name="userId" id="userId" value="${requestScope.userId }" readonly >
		<br>
		用户名：<input type="text" name="name" id="name" value="${requestScope.userName }" >
		<br>
		密码：<input type="text" name="password" id="password" value="${requestScope.password }">
		<br>
		电话：<input type="text" name="tel" id="tel" value="${requestScope.phoneNum }">
		<input type="submit" value="修改"> 
	</form>
</body>
</html>