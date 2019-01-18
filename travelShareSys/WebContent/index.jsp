<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</script>
</head>
<body>

	<h1>欢迎进入系统</h1>
	当前用户：${sessionScope.user.userName }
	
	上次登录时间: ${requestScope.lastTime }
	<a href="${pageContext.request.contextPath }/login.jsp" name="close" id="close" value="关闭" onclick="javascript:return del();">退出</a>
	<c:if test="${sessionScope.user == null }">
		<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
		<a href="${pageContext.request.contextPath }/register.jsp">注册</a>
	</c:if>
	<c:if test="${sessionScope.user != null}">
		<a href="${pageContext.request.contextPath }/travelShareServlet?ope=userList">用户信息</a>
	</c:if>
</body>

<script type="text/javascript">
function logout(){
<%
	session.invalidate(); //运用invalidate()比较好，退出时使session失效
%>
}
</script>
</html>