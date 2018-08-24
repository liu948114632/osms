<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type='text/javascript' src='/osms/dwr/interface/login.js'></script>
<script type='text/javascript' src='/osms/dwr/engine.js'></script>
<script type="text/javascript" src="js/jQuery.js"></script>

<script type='text/javascript' src='/osms/dwr/util.js'></script>
<script type="text/javascript">
	$(document).ready(function() {
		var msg = $("#h2").text();
		if (msg.length > 0) {
			$("#link").css("display", "block");
		}
	});
</script>

</head>

<body>
	<h2 id="h2"><%=(request.getParameter("msg") == null ? "" : request.getParameter("msg"))%></h2>
	<div id="link" style="display: none">
		<a href="addOrder.jsp">添加订单</a>
		<a href="cancelOrder.jsp">取消订单</a>
		<a href="downloadOrder.jsp">重新下载订单</a>
		<a href="downloadSmtOrder.jsp">添加smt订单</a>
		<a href="updateCache">更新店铺缓存</a>
		<a href="resumeSeaTransData.jsp">补货订单生成补货计划以及备货计划</a>
		<a href="report.jsp">getAmazonReport</a>
		<a href="agedReport.jsp">获取亚马逊库龄报告表</a>
	</div>
</body>
</html>
