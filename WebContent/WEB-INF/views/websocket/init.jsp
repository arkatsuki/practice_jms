<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>
<!-- tomcat -->
<c:set var="jsPrefix" value="/practice_jms" />
<!-- jetty -->
<%-- <c:set var="jsPrefix" value="" /> --%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<!-- BEGIN HEAD -->
<head>
	<!-- TITLE BEGIN -->
	<title>practice</title>
	<!-- TITLE END -->
	<!-- META BEGIN -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
</head>
<!-- END HEAD -->
<!-- 必须在其它js之前引入jquery -->
<script type="text/javascript" src="${jsPrefix }/static/public/scripts/jquery/jquery-1.9.1.min.js?time=<%=new Date().getTime() %>" ></script>
<script type="text/javascript" src="${jsPrefix }/static/public/scripts/sockjs-1.1.4.js?time=<%=new Date().getTime() %>" ></script>
<script type="text/javascript" src="${jsPrefix }/static/public/scripts/stomp-2.3.3.js?time=<%=new Date().getTime() %>" ></script>

<!-- BEGIN BODY -->
<body class="page-md page-header-fixed">

welcome to websocket/stomp
<input id="message" value=""></input>
<button id="stopConnection">stopConnection</button>
<button id="sendToServer">sendToServer</button>
<button id="triggerServerSendToBrowser">triggerServerSendToBrowser</button>
<div id="output"></div>

</body>
<script type="text/javascript" src="${jsPrefix }/static/jms_v2/js/websocket/init.js?time=<%=new Date().getTime() %>" ></script>
<!-- END BODY -->
</html>