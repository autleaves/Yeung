<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="inc/nosession.jspf" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<title>登陆</title>
<link rel="SHORTCUT ICON" href="images/myfavicon.ico" />
<link rel="stylesheet" type="text/css" href="<%=SERVER%>/css/special-css/global.css" />
<link rel="stylesheet" type="text/css" href="<%=SERVER%>/css/valclogon.css" />
<link rel="stylesheet" type="text/css" href="<%=SERVER%>/css/block-css/simplefooter2.css" />

<script type="text/javascript" language="javascript" src="http://localhost:8077/Yaye/js/logon.js"></script>

<script type="text/javascript" language="javascript">
	onload = function() {
		get('logonid').focus();
	}
	function changebtn(disp){
		if(disp == '0'){
			document.getElementById('subtn2').style.display="none";
			document.getElementById('subtn').style.display="";
		}else{
			document.getElementById('subtn').style.display="none";
			document.getElementById('subtn2').style.display="";
			document.getElementById('subtn2').style.cursor="pointer";
			
		}		
	}
	function showError(code){
		var err = get('lo_show_err');
		switch (code) {
			case '1667001' : err.innerHTML="×验证码错误！";
				break;
			case '1667003' : err.innerHTML="×用户名或密码错误！";
				break;
			default : break;
		}
	}
	function changeValc(){
		get('valcImg').style.src="http://localhost:8077/Yaye/valcode.do";
	}
	function get(objId){
		return document.getElementById(objId);
	}

</script>

</head>

<body>
<div id="logon_navHead">
	<span class="rnav"><a href="#">设为首页</a></span>
	<span class="rnav"><a href="#">加入收藏</a></span>
	<span class="rnav" id="rnlast"><a href="#">客服中心</a></span>
</div>
<div style="clear:both;"></div>
<div id="back_index"><a href="<%=SERVER%>">返回首页&gt;&gt;</a></div>
<div id="hrf_1"></div>
<div id="logon_main">
	<div id="lo_left">
    	<img src="<%=SERVER%>/images/logonimages/tutu_mm.jpg" alt="tutu" width="400" height="300" />
	</div>
	<div id="lo_right">
		<form name="logonform" id="logonform" action="<%=SERVER%>/valcLogon.do" method="post"  onsubmit="return checkValcLogonForm();">
			<fieldset id="loginfield">
				<span class="to_block"  id="lo_heading">登陆RedRose<span id="lo_heading_oth">—不一样的色彩</span></span>
				<span class="to_block" id="lo_show_err"><html:errors /><logic:present name="MY_RESPONSE_ERROR" scope="request"><bean:write name="MY_RESPONSE_ERROR" scope="request"/></logic:present></span>
				<!-- <span class="to_block" id="lo_username"><label class="labstyle" for="username" ACCESSKEY="1">帐&nbsp;&nbsp;号：</label><input autocomplete="off"  maxlength="12" type="text" id="username" tabindex="1" value="" class="textinput" onfocus="cleartext();" /></span>
				<span class="to_block" id="lo_passwd"><label class="labstyle" for="password">密&nbsp;&nbsp;码：</label><input autocomplete="off" maxlength="16" type="password" id="password" tabindex="2" class="textinput" /></span>
				 -->
				<span class="to_block" id="lo_logonid"><label class="labstyle" for="logonid" ACCESSKEY="1">帐&nbsp;&nbsp;号：</label><input autocomplete="off"  maxlength="12" type="text" id="logonid" name="logonid" tabindex="1" value="" class="textinput" /></span>
				<span class="to_block" id="lo_passwd"><label class="labstyle" for="password">密&nbsp;&nbsp;码：</label><input autocomplete="off" maxlength="16" type="password" name="password" id="password" tabindex="2" class="textinput" /></span>
				
				<span class="to_block" id="lo_validatecode"><label class="labstyle" for="valcode">验证码：</label><input autocomplete="off" maxlength="4" type="text" id="validatecode" name="validatecode" tabindex="3" class="textinput" /></span>
				<span class="to_block" id="lo_valcode_img"><img id="valcImg" src="<%=SERVER%>/valcode.do" alt="valcode" />&nbsp;<span id=""><a href="javascript:changeValc();">看不清?换一张图片?</a></span></span>
				
				<span class="to_block" id="lo_remfor"><input type="checkbox" id="" name="" /><span id="remember">记住账号</span><span id="forgetpasswd"><a href="">忘记密码?</a></span></span>
				<span class="to_block" id="lo_logreg">
					<input type="image" src="<%=SERVER%>/images/btn-signin.gif" alt="login" width="66" height="28" id="subtn" />
					<!-- <img src="images/btn-signin.gif" alt="login" width="66" height="28" id="subtn"  onmouseover="changebtn('1');" style="cursor:pointer;" />
					<img src="images/btn-signin2.gif" alt="login2"  id="subtn2" width="66" height="28" style="display:none;" onmouseout="changebtn('0')" onclick="submitlogin('logonform')" /> -->
				<span id="registhref"><a href="">注册一个帐号?</a></span></span>
			</fieldset>
		</form>
	</div>
</div>
<div style="clear:both;"></div>
<div id="newdynamic">
	
</div>
<!--<div id="hrf_2"></div>-->
<div id="footer">
	<div id="about_redRose">
		<p>Copyright(c) 2009 - 2019 RedRose Inc. All Rights Reserved </p>
		<p id="contact">客服电话:027-88888888  传真:020-xxxxxxxx</p>
	</div>
</div>
</body>
</html>