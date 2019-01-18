<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
	function del(){
		var r = confirm("确定删除？");
		if(r == true){
			return true;
		}
		else{
			return false;	
		}
	}
	function serch(){
		
	}
	
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/searchServlet" method="post">
		id:<input type="text" name="userId2" id="userId2">
		name:<input type="text" name="userName2" id="userName2">
		<input type="submit" value="搜索"> 
	</form>
	
	<form action="${pageContext.request.contextPath }/updateUserServlet" method="post">
	
	<table border="1" width = "700" cellspacing = "0" class="table" >
		<thead>
			<tr>
				<th>id</th>
				<th>用户名</th>
				<th>密码</th>
				<th>电话</th>
				<th colspan="2">操作</th>
				
			</tr>
		</thead>
		<c:forEach items="${requestScope.list }" var="e">
		<tr>
			<td name="userId" id="userId">${e.userId }</td>
			<td name="userName" id="userName">${e.userName }</td>
			<td name="password" id="password">${e.password }</td>
			<td name="tel" id="tel">${e.phoneNum }</td>
			<td><a href="${pageContext.request.contextPath }/updateUserServlet?userName=${e.userName}&userId=${e.userId }&password=${e.password }&phoneNum=${e.phoneNum } ">修改</a></td>
			<td><a href="${pageContext.request.contextPath }/deleteUserServlet?userId=${e.userId}&ope=delete" onclick="javascript:return del();">删除</a></td>
		</tr>
		</c:forEach>
	</table>
	</form>
</body>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>