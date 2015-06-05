<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- base library -->
<link rel="stylesheet" type="text/css" href="ext-js/resources/css/ext-all.css" />
<link rel="stylesheet" type="text/css" href="ext-js/ux/statusbar/css/statusbar.css" />

<!-- ExtJS library: base/adapter -->
<script type="text/javascript" src="ext-js/adapter/ext/ext-base.js"></script>
<!-- ExtJS library: all widgets -->
<script type="text/javascript" src="ext-js/ext-all-debug.js"></script>
<script type="text/javascript" src="ext-js/form/states.js"></script>
<link rel="stylesheet" type="text/css" href="ext-js/menu/menus.css" />

<link rel="stylesheet" type="text/css" href="ext-js/tabs/tabs-example.css" />
<script type="text/javascript" src="ext-js/ux/TabCloseMenu.js"></script>
<script type="text/javascript" src="ext-js/ux/statusbar/StatusBar.js"></script>

<script type="text/javascript" src="js/ui/menu/menu.js"></script>
<script type="text/javascript" src="js/ui/menu/tab.js"></script>
<script type="text/javascript" src="js/ui/menu/layout.js"></script>
<script type="text/javascript" src="js/common/autoac.js"></script>
<script type="text/javascript" src="js/login/login.js"></script>
<!-- EXAMPLES -->
<script type="text/javascript" src="ext-js/shared/examples.js"></script>

<script type="text/javascript">
	 var CONTEXT_ROOT = "<%=request.getContextPath()%>";
	 Ext.BLANK_IMAGE_URL = 'ext-js/resources/images/default/s.gif';
</script>

 <style type="text/css">
    html, body {
        font:normal 12px verdana;
        margin:0;
        padding:0;
        border:0 none;
        overflow:hidden;
        height:100%;
    }
    p {
        margin:5px;
    }
    .settings {
        background-image:url(ext-js/shared/icons/fam/folder_wrench.png);
    }
    .nav {
        background-image:url(ext-js/shared/icons/fam/folder_go.png);
    }
    </style>

</head>
<body>
	<div id="west" class="x-hide-display">
    </div>
    <div id="north" class="x-hide-display">
    </div>
    <div id="south" class="x-hide-display">
    	<div id="statusMessage"></div>
    </div>
    
</body>
</html>