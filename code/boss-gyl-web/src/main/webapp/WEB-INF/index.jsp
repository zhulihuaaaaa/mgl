<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"/><!--输当前所在的项目名称  -->
<!--jquery  -->
<script
	src="<%=request.getContextPath()%>/plugin/jquery/jqueryv2.1.4.js">
</script>
<script type="text/javascript">
	var uias,crm,uiasUrlCookie;
	$.ajax({
		type : "post",
		url : "${ctx}/init/initUrl",
		async : false,
		success : function(data) {
			uias = data.UIAS;
			crm = data.CRM;
			uiasUrlCookie= data.UIAS_URL_COOKIE;
		}
	});
	if (uiasUrlCookie != "" && uiasUrlCookie !=null) {
		var uiasUrlCookies = uiasUrlCookie.split(',');
        getCookiePage(uiasUrlCookies);
	}
	
	function getCookiePage(urlJson) {
		$.ajax({
			type : "get",
			async : false,
			url : urlJson[0] +"/auth/getCookie",
			dataType : "jsonp",
			jsonp : "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
			jsonpCallback : "callbackparam",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
			success : function(json) {
				document.cookie = "loginName=" + json.loginName;
				document.cookie = "systemCode="+ json.systemCode;
				document.cookie = "cuu="+ encodeURIComponent(urlJson[0]);
				window.location = crm+"/main";
				return false;
			},
			error : function(error) {
				$.ajax({
					type : "get",
					async : false,
					url : urlJson[1] +"/auth/getCookie",
					dataType : "jsonp",
					jsonp : "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
					jsonpCallback : "callbackparam",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
					success : function(json) {
						document.cookie = "loginName=" + json.loginName;
						document.cookie = "systemCode="+ json.systemCode;
						document.cookie = "cuu="+ encodeURIComponent(urlJson[1]);
						window.location = crm+"/main";
						return false;
					},
					error : function(error) {
						
					}
				});
			}
		});
	}
	
</script>
</head>
<body>
</body>
</html>
