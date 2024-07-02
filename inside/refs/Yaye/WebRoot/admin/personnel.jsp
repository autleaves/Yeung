<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for DynaValidatorForm form</title>
	</head>
	<body>
		<html:form action="/personnel">
			password : <html:password property="password"/><html:errors property="password"/><br/>
			username : <html:text property="username"/><html:errors property="username"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>

