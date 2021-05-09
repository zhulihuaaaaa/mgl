<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" import="java.util.*"%>
<!--header start-->
<header class="ui-header ui-header-positive clearfix">
	<script type="text/javascript">
    	function changeUrl(uiasUrl,code){
    		var URL = uiasUrl+"/auth/setCookie";
    		//JSON跨域解决getScript动态添加脚本 
    		$.ajax({
    			type : "get",
    			async : false,
    			url : URL,
    			dataType : "jsonp",
    			jsonp : "systemCode",
    			jsonpCallback : code,
    			success : function(json) {
    				window.location = uiasUrl;
    			}
    		});	
    	}
    </script>
	<div class="ui-col ui-col-20">
		<h2 class="logo">
			<a href="${ctx}/main">BOSS管理系统</a>
		</h2>
	</div>
	<div class="ui-col ui-col-60">
		<ul class="header-nav-sys">
			<c:forEach items="${privSystem}" var="item" varStatus="status">
				<li>
					<c:if test="${item.systemCode == 'CRM'}">
						<i class="ico-crm-sprite ico-crm-sys"></i>
					</c:if>
					<c:if test="${item.systemCode == 'SETTLEMENT'}">
						<i class="ico-crm-sprite ico-settle-sys"></i> 
					</c:if>
					<a href="${item.systemUrl}" onclick="changeUrl('${uiasUrl}','${item.systemCode}')">${item.systemName}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div class="ui-col ui-col-80">
		<ul class="top-menu pull-right">
			<li>
				<a class="menu-down" href="javascript:;"><i class="icon-people"></i>${loginName}</a>
				<div class="dropdown-menu">
					<a href="${uiasUrl}/auth/edPwdShow">修改密码</a>
					<a href="${uiasUrl}/auth/logout">退出</a>
				</div>
			</li>
		</ul>
	</div>
</header>