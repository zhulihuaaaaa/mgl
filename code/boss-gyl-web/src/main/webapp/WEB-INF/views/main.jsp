<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="./include/head.jsp"%>
</head>
<body>
	<section id="container">
		<!--header start-->
		<%@include file="./include/navgation.jsp"%>
		<!--header end-->
		<!--sidebar start-->
		<%@include file="./include/left_menu.jsp"%>
		<!--sidebar end-->
		<section class="main-content">
			<section class="wrapper">
				<div>
				    <img src="${ctx}/images/index.png">
				</div>
			</section>
		</section>
	</section>
</body>
<%@include file="./include/footer.jsp"%>
<script type="text/javascript">
	var ctx = "${ctx}";
</script>
</html>
