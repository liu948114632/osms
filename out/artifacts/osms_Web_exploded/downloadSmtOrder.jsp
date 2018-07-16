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
				if(result[i].type==3){
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
  	<form method="post" action="DownloadSmtOrder" id="order" >
	<table style="display: block;margin-left: 40%" >
		<tr>
			<td>店铺</td>
			<td>
				<select id="accountId" style="width: 170;" name="accountId">
				</select>
			</td>
		</tr>
		<tr>
			<td>剩余发货天数</td>
			<td>
				<input name="leftDays" id="leftDays" value="5"/>
			</td>
		</tr>
		<tr>
			<td>json</td>
			<td>
				<textarea name="json" id="json" style="margin: 0px; width: 350px; height: 550px;"
				>
				{
    "receiptAddress": {
        "zip": "6163",
        "phoneNumber": "94186899",
        "province": "Western Australia",
        "address2": "",
        "phoneArea": "08",
        "phoneCountry": "61",
        "contactPerson": "Belinda Orlando",
        "mobileNo": "0411777975",
        "city": "Perth",
        "country": "AU",
        "detailAddress": "18 Bosnich Way Spearwood"
    },
    "gmtModified": "2017-05-20 01:47:50",
    "buyerInfo": {
        "lastName": "Orlando",
        "loginId": "au1125684344wlgc",
        "firstName": "Belinda",
        "country": "AU"
    },
    "isPhone": false,
    "buyerloginid": "au1125684344wlgc",
    "logisticsAmount": {
        "amount": 3.06,
        "cent": 306,
        "currencyCode": "USD",
        "currency": {
            "defaultFractionDigits": 2,
            "currencyCode": "USD",
            "symbol": "$"
        }
    },
    "orderMsgList": [],
    "childOrderExtInfoList": [
        {
            "unitPrice": {
                "amount": 2.39,
                "cent": 239,
                "currencyCode": "USD",
                "currency": {
                    "defaultFractionDigits": 2,
                    "currencyCode": "USD",
                    "symbol": "$"
                }
            },
            "quantity": 0,
            "sku": "\"{\"sku\":[{\"skuImg\":\"HTB1HJNEOpXXXXXoXFXXq6xXFXXXL.jpg\",\"selfDefineValue\":\"Green2\",\"pName\":\"Color\",\"pValueId\":1254,\"pValue\":\"Sky Blue\",\"showType\":\"colour_atla\",\"pId\":14,\"order\":1}]}\"",
            "productName": "Jewelry DIY  Beads Flower Painted Glass Round Beads, Mixed Color, Blue Violet,Royal Blue,Green,Red,White,12mm, Hole: 1mm",
            "productId": 32767377349
        },
        {
            "unitPrice": {
                "amount": 2.39,
                "cent": 239,
                "currencyCode": "USD",
                "currency": {
                    "defaultFractionDigits": 2,
                    "currencyCode": "USD",
                    "symbol": "$"
                }
            },
            "quantity": 0,
            "sku": "\"{\"sku\":[{\"skuImg\":\"HTB1BxpNOpXXXXXZXpXXq6xXFXXXv.jpg\",\"selfDefineValue\":\"BlueViolet2\",\"pName\":\"Color\",\"pValueId\":175,\"pValue\":\"Green\",\"showType\":\"colour_atla\",\"pId\":14,\"order\":1}]}\"",
            "productName": "Jewelry DIY  Beads Flower Painted Glass Round Beads, Mixed Color, Blue Violet,Royal Blue,Green,Red,White,12mm, Hole: 1mm",
            "productId": 32767377349
        }
    ],
    "issueInfo": {
        "issueStatus": "NO_ISSUE"
    },
    "logisticInfoList": [],
    "id": 84024287405382,
    "issueStatus": "NO_ISSUE",
    "frozenStatus": "NO_FROZEN",
    "logisticsStatus": "WAIT_SELLER_SEND_GOODS",
    "orderAmount": {
        "amount": 12.62,
        "cent": 1262,
        "currencyCode": "USD",
        "currency": {
            "defaultFractionDigits": 2,
            "currencyCode": "USD",
            "symbol": "$"
        }
    },
    "sellerSignerFullname": "nice beads",
    "initOderAmount": {
        "amount": 12.62,
        "cent": 1262,
        "currencyCode": "USD",
        "currency": {
            "defaultFractionDigits": 2,
            "currencyCode": "USD",
            "symbol": "$"
        }
    },
    "oprLogDtoList": [
        {
            "id": 253770923885382,
            "gmtModified": "2017-05-20 01:13:20",
            "memo": "\"{\"apContractId\":\"2017052032007101360014987079\",\"parameterMap\":{},\"parameterNames\":[],\"paymentContractId\":\"2017052032007101360014987079\",\"paymentType\":\"MIXEDCARD\",\"receiptNo\":\"2017052031007206360011668431\"}\"",
            "gmtCreate": "2017-05-20 01:13:20",
            "actionType": "front_pay_online_success",
            "childOrderId": 84024287405382,
            "orderId": 84024287405382,
            "operator": "ipayMsg"
        },
        {
            "id": 253771043455382,
            "gmtModified": "2017-05-20 01:13:18",
            "gmtCreate": "2017-05-20 01:13:18",
            "actionType": "front_create_order",
            "childOrderId": 84024287405382,
            "orderId": 84024287405382,
            "operator": "au1125684344wlgc"
        }
    ],
    "childOrderList": [
        {
            "lotNum": 5,
            "productAttributes": "\"{\"sku\":[{\"skuImg\":\"HTB1HJNEOpXXXXXoXFXXq6xXFXXXL.jpg\",\"selfDefineValue\":\"Green2\",\"pName\":\"Color\",\"pValueId\":1254,\"pValue\":\"Sky Blue\",\"showType\":\"colour_atla\",\"pId\":14,\"order\":1}]}\"",
            "orderStatus": "WAIT_SELLER_SEND_GOODS",
            "productUnit": "Lots",
            "skuCode": "GLAA-J087-12mm-B10",
            "productId": 32767377349,
            "id": 84024287415382,
            "logisticsType": "CPAM",
            "frozenStatus": "NO_FROZEN",
            "issueStatus": "NO_ISSUE",
            "productCount": 2,
            "fundStatus": "PAY_SUCCESS",
            "initOrderAmt": {
                "amount": 4.78,
                "cent": 478,
                "currency": {
                    "defaultFractionDigits": 2,
                    "currencyCode": "USD",
                    "symbol": "$"
                }
            },
            "productPrice": {
                "amount": 2.39,
                "cent": 239,
                "currencyCode": "USD",
                "currency": {
                    "defaultFractionDigits": 2,
                    "currencyCode": "USD",
                    "symbol": "$"
                }
            },
            "productName": "Jewelry DIY  Beads Flower Painted Glass Round Beads, Mixed Color, Blue Violet,Royal Blue,Green,Red,White,12mm, Hole: 1mm"
        },
        {
            "lotNum": 5,
            "productAttributes": "\"{\"sku\":[{\"skuImg\":\"HTB1BxpNOpXXXXXZXpXXq6xXFXXXv.jpg\",\"selfDefineValue\":\"BlueViolet2\",\"pName\":\"Color\",\"pValueId\":175,\"pValue\":\"Green\",\"showType\":\"colour_atla\",\"pId\":14,\"order\":1}]}\"",
            "orderStatus": "WAIT_SELLER_SEND_GOODS",
            "productUnit": "Lots",
            "skuCode": "GLAA-J087-12mm-B08",
            "productId": 32767377349,
            "id": 84024287425382,
            "logisticsType": "CPAM",
            "frozenStatus": "NO_FROZEN",
            "issueStatus": "NO_ISSUE",
            "productCount": 2,
            "fundStatus": "PAY_SUCCESS",
            "initOrderAmt": {
                "amount": 4.78,
                "cent": 478,
                "currency": {
                    "defaultFractionDigits": 2,
                    "currencyCode": "USD",
                    "symbol": "$"
                }
            },
            "productPrice": {
                "amount": 2.39,
                "cent": 239,
                "currencyCode": "USD",
                "currency": {
                    "defaultFractionDigits": 2,
                    "currencyCode": "USD",
                    "symbol": "$"
                }
            },
            "productName": "Jewelry DIY  Beads Flower Painted Glass Round Beads, Mixed Color, Blue Violet,Royal Blue,Green,Red,White,12mm, Hole: 1mm"
        }
    ],
    "gmtCreate": "2017-05-20 01:13:18",
    "sellerOperatorLoginId": "cn1510958771",
    "paymentType": "MIXEDCARD",
    "loanInfo": {},
    "orderStatus": "WAIT_SELLER_SEND_GOODS",
    "buyerSignerFullname": "Belinda Orlando",
    "loanStatus": "pay_success",
    "gmtPaySuccess": "2017-05-20 01:13:19",
    "fundStatus": "PAY_SUCCESS"
}
				</textarea>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" value="下载Smt订单" name="addOrder"/>
			</td>
		</tr>
	</table>
	</form>
  </body>
</html>
