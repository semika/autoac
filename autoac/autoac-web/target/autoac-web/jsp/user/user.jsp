<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Maintenance</title>

<!--<link rel="stylesheet" type="text/css" href="../ext-js/resources/css/ext-all.css" />
<link rel="stylesheet" type="text/css" href="../css/util.css" />
<link rel="stylesheet" type="text/css" href="../ext-js/ux/statusbar/css/statusbar.css" />

<script type="text/javascript" src="../ext-js/adapter/ext/ext-base-debug.js"></script>
<script type="text/javascript" src="../ext-js/ext-all-debug.js"></script>

<script type="text/javascript" src="../ext-js/ux/Reorderer.js"></script>
<script type="text/javascript" src="../ext-js/ux/ToolbarReorderer.js"></script>
<script type="text/javascript" src="../ext-js/ux/ToolbarDroppable.js"></script>
<script type="text/javascript" src="../ext-js/ux/statusbar/StatusBar.js"></script>

<script type="text/javascript" src="../js/common/common.js"></script>
-->
<jsp:include page="../common/header.jsp"></jsp:include>
<script type="text/javascript" src="../js/user/user.js"></script>
</head>
<body>
<script type="text/javascript">
var CONTEXT_ROOT = "<%=request.getContextPath()%>";
var user;
Ext.onReady(function() {
	Ext.QuickTips.init();
	// turn on validation errors beside the field globally
    Ext.form.Field.prototype.msgTarget = 'side';

    //var bd = Ext.getBody();
	
	user = new Ext.User();
	user.onLoad();
});
</script>
<div id="grid-example" style="padding-bottom: 10px;"></div>
<div id="form-container"></div>
</body>
</html>