<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证码页面</title>
<body>
    <form action="${pageContext.request.contextPath}/checkCode" method="post">
        请输入验证码：<input type="text" name="code" style="width: 80px;" />
         	<img id="imgObj" alt="验证码"src="${pageContext.request.contextPath}/codeServlet">
         	<a href="#" onclick="changeImg()">换一张</a>
         	<br/> 
         	<input type="submit" value="提交" />
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