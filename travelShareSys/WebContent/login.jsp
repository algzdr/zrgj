<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		function alt() {
			alert("注册成功！");
		}
	</script>
</head>
<body>
	<%
	 	if(request.getAttribute("str") == "true"){
	 		
	%>
	<script type="text/javascript">
		alert("注册成功");	
	</script>
	<%} %>
	
	<form action="${pageContext.request.contextPath }/loginServlet" method="post" >
		用户名：<input type="text" name="name" id="name" >
		<br>
		密码：<input type="password" name="password" id="password">
		<br>
		请输入验证码：<input type="text" name="code" style="width: 80px;" />
         	<img id="imgObj" alt="验证码"src="${pageContext.request.contextPath}/codeServlet">
         	<a href="#" onclick="changeImg()">换一张</a>
         	<br/> 
		<input type="submit" value="登录"> 
		<input type="reset" value="重置">
		${requestScope.error_msg }
	</form> 
	
</body>
<script type="text/javascript">
    /* $(function() {

    }); */

    function changeImg(){
		// 获取到img的空间对象
		var val = document.getElementById("imgObj");
		// 每次重新访问地址
		val.src="${pageContext.request.contextPath }/codeServlet?date=" + new Date();
	}
    
    // 时间戳
    // 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
    function chgUrl(url) {
        var timestamp = (new Date()).valueOf();
        url = url.substring(0, 20);
        if ((url.indexOf("&") >= 0)) {
            url = url + "×tamp=" + timestamp;
        } else {
            url = url + "?timestamp=" + timestamp;
        }
        return url;
    }

</script>
</html>