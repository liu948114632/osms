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
	
</script>
</head>

<body>
<div style="padding-left:35%;padding-top:8%; text-align: left;">
<form method="post" action="cancelOrder" id="order" >
	店铺：<select id="shopId" style="width: 170;" name="shopId">
					<%--<option value="" selected="selected">请选择</option>
				--%>
		</select><span style="color: red">  *</span>	<p/>
	AM订单号：<input type="text" maxlength="30" name="amId" id="amId"/>
	<p/>
	code：&nbsp;&nbsp;<input type="text" maxlength="30" name="code" id="code" /><span style="color: red">(二选一,优先code)</span>
	<p/>
	取消状态：<input type="checkbox" name="canceledStatus" id="canceledStatus"/><font color="red">shippind</font>
	<p/>
	平台：&nbsp;&nbsp;<select name="type"> 
		<option selected="selected" value="1">amazon</option>
		<option value="2">ebay</option>
	</select>
	<p/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="取消订单">
</form>
</div>

</body>
</html>
