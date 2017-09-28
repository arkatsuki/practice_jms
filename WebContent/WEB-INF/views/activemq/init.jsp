<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>
<c:set var="jsPrefix" value="/practice_jms" />
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
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
<script type="text/javascript" src="${jsPrefix }/static/public/scripts/jquery/jquery-1.9.1.min.js" ></script>
<!-- BEGIN BODY -->
<body class="page-md page-header-fixed">

welcome to activemq/init<br>
message:<input id="message"></input><br>
destination:<input id="destination"></input><br>("first.queue","first.topic")
<button id="sendToBroker">sendToBroker</button><br>
<div id="output"></div>

<script type="text/javascript" src="${jsPrefix }/static/jms_v2/js/activemq/init.js" ></script>
</body>
<!-- END BODY -->
</html>