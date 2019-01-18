<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>商品编号</th>
				<th>商品名称</th>
				<th>购买单价</th>
				<th>购买数量</th>
				<th>总价</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sessionScope.list }" var="i">
				<tr>
					<td>${i.id }</td>
					<td>${i.name }</td>
					<td>${i.price }</td>
					<td>${i.number }</td>
					<td>${i.number * i.price }</td>
					<td><a href="${pageContext.request.contextPath }/ShoppingServlet?userId=${i.id }&cmd=del">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6">总价:XXXXXXX</td>
			</tr>
		</tbody>
	</table>

	<a href="${pageContext.request.contextPath }/ShoppingServlet?cmd=clear">清空购物车</a>
	<a href="${pageContext.request.contextPath }/ShoppingServlet?cmd=findAll">返回商品列表</a>

</body>
</html>