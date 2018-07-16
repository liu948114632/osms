<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>addOrder</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type"content="text/html;charset=utf-8">
 <script type='text/javascript' src='/osms/dwr/interface/login.js'></script>
<script type='text/javascript' src='/osms/dwr/engine.js'></script>
<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript" src="js/login_on.js"></script>

<script type='text/javascript' src='/osms/dwr/util.js'></script>
<script type="text/javascript">
	$(document).ready(function(){
		isLogin('<%=session.getAttribute("pwd")%>');
		
		dwr.engine._execute("dwr", 'login', 'getShops', function(result){
			for(var i=0;i<result.length;i++){
				if(result[i].type==2){
					$("#accountId").html($("#accountId").html()
							+"<option value=\""+result[i].id+"\" >"+result[i].name+"</option>");
				}
			}
    	});
		
	});
	
	function login(){
		dwr.engine._execute("dwr", 'login', 'sayHello', $("#username").val(), function(result){
	        alert(result);
	    });
	}
</script>
  </head>
  
  <body>
  	<form method="post" action="DownloadOrder" id="order" >
	<table style="display: block;margin-left: 40%" >
		<tr>
			<td>店铺</td>
			<td>
				<select id="accountId" style="width: 170;" name="accountId">
					<%--<option value="" selected="selected">请选择</option>
				--%></select>
			</td>
		</tr>
		<tr>
			<td>shop_order_id</td>
			<td>
				<input name="shopOrderCode" id="shopOrderCode"/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" value="重新下载Ebay订单" name="addOrder"/>
			</td>
		</tr>
	</table>
	</form>
  </body>
</html>
