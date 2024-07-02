<%@ page pageEncoding="utf-8"%>
<%@ include file="inc/common.jspf" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
	<!--<html:base />-->
    
    <title>用户注册 --RedRose B2C电子商务</title>
	<%@ include file="inc/meta_css_script.jspf" %>
	<meta content="MSHTML 6.00.2900.3462" name=GENERATOR>
	<meta http-equiv="keywords" content="RedRose,红玫瑰,电子商城,女性商城,女性,内衣,服饰,">

	<!--<link rel="SHORTCUT ICON" href="images/myfavicon.ico" />-->
	<link href="<%=SERVER%>/css/block-css/simplefooter.css" rel="stylesheet" type="text/css" />
	<link href="<%=SERVER%>/css/regist.css" rel="stylesheet" type="text/css" />
	
	<script src="<%=SERVER%>/js/offic/date1.js" type="text/javascript"></script>
	<script src="<%=SERVER%>/js/common/simplefooter.js" language="javascript" type="text/javascript"></script>
	<script src="<%=SERVER%>/js/utils/checkregistform.js" language="javascript" type="text/javascript"></script>
	
	<script language=javascript type=text/javascript>
		javascript:window.history.forward(1);//no-cache
	</script>
  </head>
  
<body>
<div id="regnav">
	<span class="rnav"><a href="http://localhost:8077/Yaye/logon.html">登陆</a></span>
	<span class="rnav"><a href="http://localhost:8077/Yaye/regist.html">注册</a></span>
	<span class="rnav"><a href="#">找回密码</a></span>
	<span class="rnav"><a href="#">使用帮助</a></span>
	<span class="rnav" id="rnlast"><a href="http://localhost:8077/Yaye/index.html">首页</a></span>
</div>
<div style="clear:both;"></div><!-- clear float -->
<div id="regist_main">
	<div id="re_heading_wrapper">
		<span id="re_heading">注册一个帐号</span>
		<span id="restep">注册步骤:<span id="restep_now">&nbsp;1.选择登录名</span>&nbsp;-&nbsp;2.注册成功</span>
	</div>
	<div class="hrs"></div><!-- 分隔线 -->
  <form name="regf" id="regf" action="http://localhost:8077/Yaye/regist.do" method="post" onsubmit="return checkForm(this);" >
	<div id="re_logonspa" class="dilis"><!--登陆名begin-->
		<div class="re_left">
			<span class="re_lab_heading">登录RedRose使用的名字（英文、汉字、数字，4-16个字符）</span>
			<span id="re_li_wr_ni" class="re_li_wr"><span class="re_vip">*</span>登录名：<input type="text"  name="logonid" id="logonid" maxlength="16"  alt="登陆名:" /><label class="chk_error" id="chk_logonid"><html:errors property="logonid"/></label></span>
			<input type="button" name="checklogonid" id="checklogonid" value="登陆名&nbsp;&nbsp;是否被占用" style="width: 200px;" onclick="isExist(this.value)" />
		</div>
		<div id="re_right_logonid" class="re_right">登录名：4-16个字符(包括4、16)或2-8个汉字， 请用英文小写、汉字、数字、下划线，不能全部是数字，下划线不能在末尾。</div>
	</div><!--登陆名end-->
	<div style="clear:both;" class="hrs"></div><!-- clear float & 分隔线 -->
	<div id="re_passwdspa"><!--密码begin-->
		<div class="re_left">
			<span class="re_lab_heading">登录密码请在(6-16个字符，区分英文大小写)</span>
			<span class="re_li_wr" id="re_li_wr_pw1"><span class="re_vip">*</span>输入登录密码：<input type="password" name="password" id="password" alt="密码:"  /><label class="chk_error" id="chk_password"><html:errors property="password"/></label></span>
			<div class="passwd_hrs"></div>
			<span class="re_li_wr" id="re_li_wr_pw2">&nbsp;密码强弱提示：<span id="pswstrong"></span></span>
			<div class="passwd_hrs"></div>
			<span class="re_li_wr" id="re_li_wr_pw3"><span class="re_vip">*</span>再次输入密码：<input type="password" name="repasswd" id="repasswd" alt="重复密码:"  /><label class="chk_error" id="chk_repasswd"><html:errors property="repasswd"/></label></span>
		</div>
		<div id="re_right_password" class="re_right">密码为6—16位（包括6、16），限用英文、数字、半角“.”、“-”、“?”和下划线，区分大小写。</div>
	</div><!--密码end-->
	<div style="clear:both;" class="hrs"></div><!-- clear float & 分隔线 -->
	<div id="re_realnamespa"><!--真实姓名begin-->
		<div class="re_left">
			<span class="re_lab_heading">请务必填写真实的姓名</span>
			<span id="re_li_wr_re" class="re_li_wr"><span class="re_vip">*</span>真实姓名：<input type="text" name="realname" id="realname" alt="姓名:"  /><label class="chk_error" id="chk_realname"><html:errors property="realname"/></label></span>
		</div>
		<div id="re_right_realname" class="re_right">密码为6—16位（包括6、16），限用英文、数字、半角“.”、“-”、“?”和下划线，区分大小写。</div>
	</div><!--真实姓名end-->
	<div style="clear:both;" class="hrs"></div><!-- clear float & 分隔线 -->
	<div id="re_birthdayspa"><!--出生日期begin-->
		<div class="re_left">
			<span class="re_lab_heading"></span>
			<span id="re_li_wr_bi" class="re_li_wr"><span class="re_vip">*</span>出生日期：<input type="text" name="birthday" id="birthday" onclick="calendar();" alt="出生日期:" /><label class="chk_error" id="chk_birthday"><html:errors property="birthday"/></label></span>
		</div>
		<div id="re_right_birthday" class="re_right">请填写你的出生日期。</div>
	</div><!--出生日期end-->
	<div style="clear:both;" class="hrs"></div>
	<div id="re_mobilespa"><!--移动电话begin-->
		<div class="re_left">
			<span class="re_lab_heading">请填写一个方便联系你的移动电话</span>
			<span id="re_li_wr_mob" class="re_li_wr"><span class="re_vip">*</span>移动电话：<input type="text" name="mobile" id="mobile" alt="移动电话:" /><label class="chk_error" id="chk_mobile"><html:errors property="mobile"/></label></span>
		</div>
		<div id="re_right_mobile" class="re_right">填写一个方便联系你的移动电话。</div>
	</div><!--移动电话end-->
	<div style="clear:both;" class="hrs"></div><!-- clear float & 分隔线 -->
	<div id="re_telspa"><!--备用电话begin-->
		<div class="re_left">
			<span class="re_lab_heading">请填写一个可联系你的备用电话</span>
			<span id="re_li_wr_tel" class="re_li_wr"><span class="re_vip">*</span>固定电话：<input type="text" name="tel" id="tel" alt="固定电话:" /><label class="chk_error" id="chk_tel"><html:errors property="tel"/></label></span>
		</div>
		<div id="re_right_tel" class="re_right">填写一个可联系你的备用电话。</div>
	</div><!--移动电话end-->
	<div style="clear:both;" class="hrs"></div>
	<div id="re_idcardspa"><!--证件号码begin-->
		<div class="re_left">
			<span class="re_lab_heading"></span>
			<span id="re_li_wr_idc" class="re_li_wr"><span class="re_vip">*</span>身份证号码：<input type="text" name="idcard" id="idcard" alt="证件号码:" /><label class="chk_error" id="chk_idcard"><html:errors property="idcard"/></label></span>
		</div>
		<div id="re_right_idcard" class="re_right">请填写你自己的身份证号码。</div>
	</div><!--证件号码end-->
	<div style="clear:both;" class="hrs"></div><!-- clear float & 分隔线 -->
	<div id="re_addrspa"><!--联系地址begin-->
		<span class="re_lab_heading">填写可以联系你的详细地址名称</span>
		<span id="re_li_wr_addr" class="re_li_wr"><span class="re_vip">*</span>联系地址：
			<select name="country" id="country">
				<option id="" value="">中华人民共和国</option>
			</select>
			<select name="province" id="province">
				<option id="" value="">北京市</option>
				<option id="" value="">重庆市</option>
				<option id="" value="">上海市</option>
				<option id="" value="">湖北省</option>
				<option id="" value="">河北省</option>
				<option id="" value="">济南省</option>
				<option id="" value="">海南省</option>
				<option id="" value="">新疆维吾尔自治区</option>
			</select>
			<select name="city" id="city">
				<option id="" value="">武汉市</option>
				<option id="" value="">齐齐哈尔</option>
				<option id="" value="">哈尔滨市</option>
			</select>&nbsp;&nbsp;
			<input type="text" name="selfaddress" id="selfaddr" alt="地址:" style="width: 210px; height: 24px;" />
			<label class="chk_error" id="chk_selfaddr"><html:errors property="selfaddress"/></label>
		</span>
	</div><!--联系地址end-->
	<div style="clear:both;" class="hrs"></div><!-- clear float & 分隔线 -->
	<div id="re_zipcodespa"><!--邮政编码begin-->
		<div class="re_left">
			<span class="re_lab_heading"></span>
			<span id="re_li_wr_zipc" class="re_li_wr"><span class="re_vip">*</span>邮政编码：<input type="text" name="zipcode" id="zipcode" alt="邮政编码:" /><label class="chk_error" id="chk_zipcode"><html:errors property="zipcode"/></label></span>
		</div>
		<div id="re_right_zipcode" class="re_right">你所在地的邮政编码。</div>
	</div><!--邮政编码end-->
	<div style="clear:both;" class="hrs"></div>
	<div id="re_emailspa"><!--邮箱begin-->
		<div class="re_left">
			<span class="re_lab_heading"></span>
			<span id="re_li_wr_email" class="re_li_wr"><span class="re_vip">*</span>安全邮箱：<input type="text" name="safemail" id="safemail" alt="邮箱:" /><label class="chk_error" id="chk_safemail"><html:errors property="safemail"/></label></span>
		</div>
		<div id="re_right_email" class="re_right">忘记密码时，可凭安全邮箱索取密码。</div>
	</div><!--邮箱end-->
	<div style="clear:both;" class="hrs"></div><!-- clear float & 分隔线 -->
	<div id="re_validatecodespa"><!--验证码begin-->
		<span id="re_li_wr_valc" class="re_li_wr"><span class="re_vip">*</span>输入图片中的字符：<input type="text" name="validatecode" id="validatecode" alt="验证码:" style="width: 70px;" />&nbsp;
		<img id="valcImg" src="" alt="valcode" />
		<!--<img src="http://localhost:8077/Yaye/ValidateCode.do" alt="验证码" name="validatecode" width="100" height="35" id="validatecode" style="background-color: #EEEEEE" />-->&nbsp;<a href="javascript:changeValidateCode();">看不清？换一张</a>
			<label class="chk_error" id="chk_validatecode"><html:errors property="validatecode"/></label>
		</span>
	</div><!--验证码end-->
	<div style="clear:both;"></div>
	<div id="re_protocolspa">
		<span><span class="re_vip">*</span><input type="checkbox" alt="协议:" name="protocol" id="protocol" />我已经看过并同意《<a href="">RedRose网络服务使用协议</a>》。<label class="chk_error" id="chk_protocol"><html:errors property="protocol"/></label></span>
	</div>
	<div style="clear:both;"></div>
	<div id="re_submitButtonspa">
		<input type="submit" id="subm" name="subm" value="提&nbsp;交&nbsp;信&nbsp;息" style="width: 130px;"  />
	</div>
  </form>
</div>

<!--标准尾 begin-->
<div id="footer">
	<div id="aboout_mall">
		RedRose网产品客户服务联系电话:95105670 客服邮箱：webcn@staff.sina.com.cn
	</div>
	<div id="about_redRose">
		<span class="rose"><a href="#">RedRose简介</a></span>
		<span class="rose"><a href="#">About RedRose</a></span>
		<span class="rose"><a href="#">广告服务</a></span>
		<span class="rose"><a href="#">网站律师</a></span>
		<span class="rose" id="rolast"><a href="#">产品答疑</a></span>
		<p id="contact">客服电话:027-88888888  传真:020-xxxxxxxx</p>
		<p>Copyright(c) 2009 - 2019 RedRose Inc. All Rights Reserved </p>
	</div>
</div>
<!--标准尾 end-->

<!-- 这里是为了进行验证表单的一些初使化操作 -->
<script type="text/javascript" language="javascript">
<!--
	input_init();
//-->
</script>
</body>
</html:html>
