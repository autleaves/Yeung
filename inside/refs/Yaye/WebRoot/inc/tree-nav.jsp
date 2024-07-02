<%@ page language="java" pageEncoding="utf-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<jsp:useBean id="JSONRPCBridge" scope="session" class="com.metaparadigm.jsonrpc.JSONRPCBridge" />
<jsp:useBean id="RemoteBean" scope="session" class="mil.yaye.yours.ajax.RemoteBean" />
<%
JSONRPCBridge.registerObject("RemoteBean",RemoteBean);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>navigation</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<link rel="stylesheet" type="text/css" href="css/special-css/global.css">
	<link rel="stylesheet" type="text/css" href="css/block-css/nav.css">
	<script type="text/javascript" src="../js/jsonrpc.js"></script>
	<script src="../js/prototype.1.4.0.js" type="text/javascript"></script>
	<script type="text/javascript">
		var jsonrpc = new JSONRpcClient("JSON-RPC");
		function showChildren(parentId){
			var hasChildren = jsonrpc.RemoteBean.hasChildren(parentId);
			if(hasChildren == true){
				var 
			}else{
				
			}
		}
	</script>

  </head>
  
  <body>
  <!-- 这里是一些根节点 -->
  	<div id="nav">
  		<ul>
  			<li id="parent1" onmouseover="showChildren()"><bean:message key="nav.menu1"/></li>
  			<li id="parent2" onmouseover="showChildren()"><bean:message key="nav.menu2"/></li>
  			<li id="parent3" onmouseover="showChildren()"><bean:message key="nav.menu3"/></li>
  			<li id="parent4" onmouseover="showChildren()"><bean:message key="nav.menu4"/></li>
  			<li id="parent5" onmouseover="showChildren()"><bean:message key="nav.menu5"/></li>
  		</ul>
  	</div>
  	<!-- 专门用来显示子节点 -->
  	<!-- 自动补全 -->
  </body>
</html:html>
