<%@ page import="org.springframework.beans.factory.BeanFactory" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.itecheasy.core.fba.AmazonReportService" %>
<%@ page import="com.itecheasy.core.system.Shop" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.itecheasy.core.task.SyncAmazonAgedItemReportTask" %><%--
  ~ Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
  ~ Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
  ~ Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
  ~ Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
  ~ Vestibulum commodo. Ut rhoncus gravida arcu.
  --%>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/11
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type='text/javascript' src='/osms/dwr/interface/login.js'></script>
    <script type='text/javascript' src='/osms/dwr/engine.js'></script>
    <script type="text/javascript" src="js/jQuery.js"></script>
    <script type="text/javascript" src="js/login_on.js"></script>

    <script type='text/javascript' src='/osms/dwr/util.js'></script>

    <script type="text/javascript">
        $(document).ready(function() {
                isLogin('<%=session.getAttribute("pwd")%>');
            });
    </script>
</head>
<body>
<%
//    String shopId = request.getParameter("id");

//    if(shopId != null) {
//        out.println("你输入的shopId:"+shopId);
        BeanFactory bf = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
        SyncAmazonAgedItemReportTask amazonReportService = (SyncAmazonAgedItemReportTask) bf.getBean("syncAmazonAgedItemReportTask");

//        List<Shop> shopList = new ArrayList<Shop>();
//        Shop s = new Shop();
//        s.setId(Integer.parseInt(shopId));
//        shopList.add(s);
        amazonReportService.resetEverydaySync();
        amazonReportService.syncAmazonAgedItemReport();
//    }
%>

<form >
<%--id: <input name="id"  />--%>
<input type="submit" value="同步亚马逊获取库龄报告表">
</form>

</body>
</html>
