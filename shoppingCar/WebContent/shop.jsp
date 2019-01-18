<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/ShoppingServlet" method="post">
	
		<!-- 隐士的传入操作命令 -->
		<input type="hidden" name="cmd" value="add"/>
	
		<select name="productId">
			<option value="1">手机</option>
			<option value="2">平板</option>
			<option value="3">电脑</option>
		</select>
		
		输入购买数量：<input type="text" name="number"/>
		<input type="submit" value="购买"/>
	
	</form>

</body>
</html>