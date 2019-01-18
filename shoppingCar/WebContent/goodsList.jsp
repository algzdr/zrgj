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
	<table border="1" cellspacing = "0">
		<thead>
			<tr>
				<th>商品编号</th>
				<th>商品名称</th>
				<th>购买单价</th>
				<th>商品类别</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list }" var="i">
				<tr>
					<td>${i.goodsId }</td>
					<td>${i.goodsName }</td>
					<td>${i.goodsPrice }</td>
					<td>${i.category }</td>
					<td><a href="${pageContext.request.contextPath }/ShoppingServlet?goodsId=${i.goodsId}&goodsName=${i.goodsName}&goodsPrice=${i.goodsPrice}&category=${i.category}&cmd=join" >加入购物车</a></td>
				</tr>
			</c:forEach>
			<tr>
			</tr>
		</tbody>
		<a href="${pageContext.request.contextPath }/ShoppingServlet?cmd=findCar">查看购物车</a>
	</table>

</body>
</html>