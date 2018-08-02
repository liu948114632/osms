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

<title>resumeSeaTransData</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

 <script type='text/javascript' src='/osms/dwr/interface/login.js'></script>
<script type='text/javascript' src='/osms/dwr/engine.js'></script>
<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript" src="js/login_on.js"></script>

<script type='text/javascript' src='/osms/dwr/util.js'></script>
<script type="text/javascript">
	$(document).ready(function() {
		isLogin('<%=session.getAttribute("pwd")%>');
		
		dwr.engine._execute("dwr", 'login', 'getShops', function(result){
			for(var i=0;i<result.length;i++){
				$("#shopId").html($("#shopId").html()
						+"<option value=\""+result[i].id+"\" >"+result[i].name+"</option>");
			}
    	});
	});
	
	function resume(){
		$.post(
			"./resumeSeaTransData",
			function(data){
				alert(data);
			}
		)
	}
	
</script>
</head>
<body>
	<div style="margin-top:30px;margin-left: 50px" >
		<button onclick="resume()">补货订单生成补货计划以及备货计划</button>
	</div>
</body>
</html>