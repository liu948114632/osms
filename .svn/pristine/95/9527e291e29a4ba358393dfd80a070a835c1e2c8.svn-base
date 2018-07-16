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
		
		dwr.engine._execute("dwr", 'login', 'getCountries', function(result){
				for(var i=0;i<result.length;i++){
					$("#country").html($("#country").html()
							+"<option value=\""+result[i].countryCode+"\" >"+result[i].chineseName+"</option>");
				}
	    });
		
		dwr.engine._execute("dwr", 'login', 'getShops', function(result){
			for(var i=0;i<result.length;i++){
				if(result[i].type==1){
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
  	<form method="post" action="addOrder" id="order" >
	<table style="display: block;margin-left: 40%" >
		<tr>
			<th>货运地址</th>
			<td>
			</td>
		</tr>
		<tr>
			<td>国家</td>
			<td>
				<select id="country" style="width: 170;" name="country">
					<option value="" selected="selected">请选择</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>收件人</td>
			<td>
				<input type="text" maxlength="30" id="addressName" name="addressName"/>
			</td>
		</tr>
		<tr>
			<td>地址1</td>
			<td>
				<input type="text" maxlength="30" id="address1" name="address1"/>
			</td>
		</tr>
		<tr>
			<td>地址2</td>
			<td>
				<input type="text" maxlength="30" id="address2" name="address2"/>
			</td>
		</tr>
		<tr>
			<td>地址3</td>
			<td>
				<input type="text" maxlength="30" id="address3" name="address3"/>
			</td>
		</tr>
		<tr>
			<td>州、区、或者省</td>
			<td>
				<input type="text" maxlength="30" name="stateOrRegion"/>
			</td>
		</tr>
		<tr>
			<td>城市</td>
			<td>
				<input type="text" maxlength="30" name="city"/>
			</td>
		</tr>
		<tr>
			<td>邮编</td>
			<td>
				<input type="text" maxlength="30" name="postalCode"/>
			</td>
		</tr>
		<tr>
			<td>电话</td>
			<td>
				<input type="text" maxlength="30" name="phone"/>
			</td>
		</tr>
		<tr>
			<td>店铺</td>
			<td>
				<select id="accountId" style="width: 170;" name="accountId">
					<%--<option value="" selected="selected">请选择</option>
				--%></select>
			</td>
		</tr>
		<tr>
			<th>订单</th>
			<td>
			
			</td>
		</tr>
		<tr>
			<td>客户账号</td>
			<td>
				<input type="text" maxlength="30" name="customerAccount"/>
			</td>
		</tr>
		<tr>
			<td>客户名称</td>
			<td>
				<input type="text" maxlength="30" name="customerName"/>
			</td>
		</tr>
		<tr>
			<td>amazon id</td>
			<td>
				<input type="text" maxlength="30" name="amazonId"/>
			</td>
		</tr>
		<tr>
			<td>FulfillmentChannel</td>
			<td>
				<input type="text" maxlength="30" name="FulfillmentChannel" value="MFN"/>(AFN MFN)
			</td>
		</tr>
		<tr>
			<td>total price</td>
			<td>
				<input type="text" maxlength="30" name="totalPrice"/>
			</td>
		</tr>
		<tr>
			<th>订单项</th>
			<td>
				
			</td>
		</tr>
		<tr>
			<td>商品名称</td>
			<td>
				<input type="text" maxlength="30" name="title"/>
			</td>
		</tr>
		<tr>
			<td>sku</td>
			<td>
				<input type="text" maxlength="30" name="sku"/><span style="color: red;">(请填写在店铺商品列表存在的sku)</span>
			</td>
		</tr>
		<tr>
			<td>购买批量</td>
			<td>
				<input type="text" maxlength="30" name="shopQuantityOrdered"/>
			</td>
		</tr>
		
		<tr>
			<td>购买价格</td>
			<td>
				<input type="text" maxlength="30" name="shopItemPrice"/>
			</td>
		</tr>
		<tr>
			<td>ASIN</td>
			<td>
				<input type="text" maxlength="30" name="asin"/>
			</td>
		</tr>
		<tr>
			<td>item id</td>
			<td>
				<input type="text" maxlength="30" name="itemId"/>
			</td>
		</tr>
			<tr>
			<td>运费</td>
			<td>
				<input type="text" maxlength="30" name="shippingprice"/>
			</td>
		</tr>
		
		<tr>
			<th>订单项2</th>
			<td>
				
			</td>
		</tr>
		<tr>
			<td>商品名称</td>
			<td>
				<input type="text" maxlength="30" name="title2"/>
			</td>
		</tr>
		<tr>
			<td>sku</td>
			<td>
				<input type="text" maxlength="30" name="sku2"/><span style="color: red;">(请填写在店铺商品列表存在的sku)</span>
			</td>
		</tr>
		<tr>
			<td>购买批量</td>
			<td>
				<input type="text" maxlength="30" name="shopQuantityOrdered2"/>
			</td>
		</tr>
		
		<tr>
			<td>购买价格</td>
			<td>
				<input type="text" maxlength="30" name="shopItemPrice2"/>
			</td>
		</tr>
		<tr>
			<td>ASIN</td>
			<td>
				<input type="text" maxlength="30" name="asin2"/>
			</td>
		</tr>
		<tr>
			<td>item id</td>
			<td>
				<input type="text" maxlength="30" name="itemId2"/>
			</td>
		</tr>
		
			<tr>
			<td>运费</td>
			<td>
				<input type="text" maxlength="30" name="shippingprice2"/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" value="增加订单" name="addOrder"/>
			</td>
		</tr>
	</table>
	</form>
  </body>
</html>
