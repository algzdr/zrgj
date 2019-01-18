<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			.all{
				margin:auto;
            	position:relative; 
            	width: 700px;
            	height: 400px;
            	/*border: 1px solid green;*/ 
			}
		</style>
	<script type="text/javascript">
			function checkPsw(){
				var psw = document.getElementById("psw").value;
				var pswAgain = document.getElementById("pswAgain").value;
				if(psw !== pswAgain){
					document.getElementById("pswError").innerHTML="两次密码不一样";
				}				
			}
		</script>
	</head>
	<body>
	<%-- <c:if test="${request.getAttribute('str') == 'false' }">
		<script type="text/javascript">
		alert("注册成功");	
	 	</script>
	</c:if> --%>
	<%
	 	if(request.getAttribute("str") == "false"){
	 		
	%>
	<script type="text/javascript">
		alert("注册失败，请完善信息！");
	</script>
	<%} %>
		<div style="text-align: center;" class="all">
		<form style="width: 700px;height: 700px; align-content: center;" class="all"
		action="${pageContext.request.contextPath }/registerServlet" method="post">
			<fieldset>
				<legend style="align-content: center;">注册页面</legend>				
				<p style="align-content: center;">
				&nbsp;昵&nbsp;称
				<input type="text" placeholder="nickname" name="userName" id="userName" />	                        
				</p>
				<p>
				&nbsp;密&emsp;码
				<input type="password" placeholder="password" name="psw" id="psw" />				
				</p>
				<p>
				确定密码
				<input type="password" placeholder="passwordAgain" name="pswAgain" id="pswAgain" onblur="checkPsw()"/>
				</p>
				<span id="pswError"></span>
				<p>
					手机号
					<input type="tel" name="tel" id="tel" />
				</p>
				<input type="submit" value="点击注册"  />
			</fieldset>
		</form>
		</div>
	</body>
</html>
	
