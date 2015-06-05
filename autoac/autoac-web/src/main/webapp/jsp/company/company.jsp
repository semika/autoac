<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company Maintenance</title>
<jsp:include page="../common/header.jsp"></jsp:include>
<script type="text/javascript" src="../js/company/company.js"></script>
</head>
<body>
<script type="text/javascript">
	var CONTEXT_ROOT = "<%=request.getContextPath()%>";
	var company;
	Ext.onReady(function() {
		Ext.QuickTips.init();
		// turn on validation errors beside the field globally
	    Ext.form.Field.prototype.msgTarget = 'side';
	
		company = new Ext.Company();
		company.onLoad();
	});
</script>
<div id="grid" style="padding-bottom: 10px;"></div>
<div id="form-container"></div>
</body>
</html>