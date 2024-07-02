<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="mil.yaye.yours.service.impls.PersonnelServiceImpl"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<jsp:useBean id="JSONRPCBridge" scope="session" class="com.metaparadigm.jsonrpc.JSONRPCBridge"/>
<jsp:useBean id="per" class="PersonnelServiceImpl"/>
<%
	JSONRPCBridge.registerObject("jsPer",per);
%>

<html:html lang="true">
  <head>
    <html:base />
	<link rel="stylesheet" type="text/css" href="styles.css">
	<script src="../js/jsonrpc.js" type="text/javascript"></script>
	<script src="../js/myjs.js" type="text/javascript"></script>
	<script src="../js/prototype.1.4.0.js" type="text/javascript"></script>
	<script type="text/javascript" language="JavaScript">
		//校验登录名：只能输入5-20个以字母开头、可带数字、“_”、“.”的字串 
		function isRegisterUserName(s)
		{ 
			var flag = true;
			var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/; 
			if (!patrn.exec(s)){
				var usernameErr = ${"usernameError"};
				var uHTML = '<bean:message property="loginiframe.error.usernameError" bundle="MyResources">';
				// span 具有style.display属性吗?
				usernameErr.
				flag = false;
			}
			return flag;
		} 
		//校验密码：只能输入6-20个字母、数字、下划线 
		function isPasswd(s) 
		{ 
			var flag = true;
			var patrn=/^(\w){6,20}$/;
			if (!patrn.exec(s)){
				var passwordErr = ${"passwordError"};
				var pHTML = '<bean:message property="loginiframe.error.passwordError" bundle="MyResources">';
				passwordErr.
				flag = false;
			}
			return flag;
		} 
		function clean()
		{
			$F{"username"} = "";
			$F{"password"} = "";
			${"username"}.focus(); // 还有一个select()方法不知
		}
		// Create a JSONRpcClient
		jsonrpc = new JSONRpcClient("JSON-RPC");
		function isExist()
		{
			var username = $F{"username"};	// 我想它也会用name属性检索
			var password = $F{"password"};
			// 防止用户不写任何东西就向透明服务器进行提交,因为那样的话不会触发onblur()事件,就无法进行客户端js验证
			if(isRegisterUserName(username) && isPasswd(password))
			{
				var flag = jsonrpc.jsPer.loginCheck();
				
				if(flag == 1){
					var login = ${"login"};
					var nav = ${"nav"};
					login.style.display = "none";
					nav.style.display = "block";
				}else{
					var err = ${"loginError"}// 在这里我让<html:errors property="loginiframe.label.password"/>显示的内容为我的MyResource.properties中的标签内容
					var sHTML = '<bean:message property="loginiframe.error.loginerror" bundle="MyResources"/>';
					err.innerHTML = sHTML;
				}
				
			}
			
		}
	</script>
  </head>
  
  <body>
    <!-- 此为登陆模块 1.默认显示此模块 2.是否考虑登陆时也用一个验证码,而不只是注册时才用验证码-->
    <div id="login">
    	<fieldset>
    		<legend><bean:message key="loginiframe.label"/></legend>
    		<div id="loginError"></div>
    		<!-- 这里我没有用到通过提交表单方式,我应该在JS中进行判断 -->
    		<label><bean:message key="loginiframe.label.username"/>&nbsp;:&nbsp;</label>
    		<html:text property="username" name="username" tabindex="1" onblur="isRegisterUserName(this.value)" /><span id="usernameError"></span>
    		<label><bean:message key="loginiframe.label.password"/>&nbsp;:&nbsp;</label>
    		<html:text property="password" name="password" tabindex="2" onblur="isPasswd(this.value)" /><span id="passwordError"></span>
    	</fieldset>
    	<ul>
    		<li><html:button property="Login" onclick="isExist()"><bean:message key="loginiframe.label.submit"/></html:button></li>
    		<li><html:button property="clean" onclick="clean()"><bean:message key="loginiframe.label.clean"/></html:button></li>
    	</ul>
    	<ul>
    		<li><html:link page="/regist.jsp"><bean:message key="loginiframe.link.regist"/></html:link></li>
    		<li><html:link page="/findpasswd.jsp"><bean:message key="loginiframe.link.findpasswd"/></html:link></li>
		</ul>
    </div>
    <!-- 此为个人导航模块 1.当用Ajax验证成功后显示此模块 2.是否考虑此模块与登陆模块分开,另写在一个文件中-->
    <div id="nav">
    	
    </div>
  </body>
</html:html>
