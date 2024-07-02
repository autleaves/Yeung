<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="mil.yaye.yours.vo.AddressVO"%>
<%@ include file="inc/common_withsession.jspf"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
   	<title>确认订单  -RedRose商城</title>
	<%@ include file="inc/meta_css_script.jspf"%>
	<meta http-equiv="keywords" content="RedRose电子商城,女性,女性内衣">
	<meta http-equiv="description" content="TRedRose电子商城">
	<!-- self links -->
	<link href="<%=SERVER%>/css/buystepcommon.css" rel="stylesheet" type="text/css" />
	<link href="<%=SERVER%>/css/buystep3.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="header">
	<script type="text/javascript" language="javascript">writeheader();</script>
	<script type="text/javascript" language="javascript">FillLogon();FillNavwords();FillSearchwords();FillKeywords();</script>
</div>
<div style="clear: both;"></div>
<div id="buysts_buytipimages" class="">
	<img src="<%=SERVER%>/images/guc_04.gif" width="202" height="108" />
	<img src="<%=SERVER%>/images/guc_05-2.gif" width="81" height="108" /><img src="<%=SERVER%>/images/guc_08.gif" width="14" height="108" />
	<img src="<%=SERVER%>/images/guc_07.gif" width="81" height="108" /><img src="<%=SERVER%>/images/guc_08.gif" width="14" height="108" />
	<img src="<%=SERVER%>/images/guc_09.gif" width="119" height="108" /><img src="<%=SERVER%>/images/guc_08.gif" width="14" height="108" />
	<img src="<%=SERVER%>/images/guc_11.gif" width="81" height="108" /><img src="<%=SERVER%>/images/guc_08.gif" width="14" height="108" />
	<img src="<%=SERVER%>/images/guc_13.gif" width="81" height="108" />
	<img src="<%=SERVER%>/images/guc_14.gif" width="39" height="108" />
</div>
<div id="buystep3_main" class="">
	<form name="ordfrm" id="ordfrm" action="<%=SERVER%>/buy/end.do" method="post">
	<div id="bystp3_left">
		<!--<h2 id="order_top">您的此次订单的详细信息如下，请您仔细核对：</h2>-->
		<p id="order_top">您的此次订单的详细信息如下，请您仔细核对：</p>
		<div id="order_info">
			<h3>==订单信息==</h3>
			<ol>
				<li><label>价格总计&lt;元&gt;：</label><span><bean:write property="totalprice" name="CHARGE_LIST" scope="session" /></span></li>
				<li><label>数量总计&lt;件&gt;：</label><span><bean:write property="totalnum" name="CHARGE_LIST" scope="session" /></span></li>
				<li><label>价格优惠&lt;元&gt;：</label><span><bean:write property="discount" name="CHARGE_LIST" scope="session" /></span></li>
				<li><label>可获积分&lt;点&gt;：</label><span><bean:write property="getpoint" name="CHARGE_LIST" scope="session" /></span></li>
				<li><label>&nbsp;&nbsp;&nbsp;&nbsp;运费&lt;元&gt;：</label><span><bean:write property="shipcharge" name="CHARGE_LIST" scope="session" /></span></li>
				<li><label>使用积分&lt;点&gt;：</label><span>无</span></li>
				<li><label>折后总计&lt;元&gt;：</label><span><bean:write property="discountprice" name="CHARGE_LIST" scope="session" /></span></li>
			</ol>
			<p class="hr"></p>
			<h3>==收货人信息==</h3>
			<ol>
				<%
				Map<String, Object> shopcart_map = (Map<String, Object>)session.getAttribute("SHOPCART_MAP");
				Map<String, AddressVO> addrMap = (Map<String, AddressVO>) session.getAttribute("ADDR_MAP");
				AddressVO addrVO = (AddressVO) addrMap.get(shopcart_map.get("ADDR_KEY"));
				%>
				<li><label>&nbsp;&nbsp;收货人：</label><span><%=addrVO.getRealname()%></span></li>
				<li><label>&nbsp;&nbsp;&nbsp;&nbsp;地址：</label><span><%=addrVO.getProvince()%><%=addrVO.getCity()%><%=addrVO.getSelfaddress()%></span></li>
				<li><label>邮政编码：</label><span><%=addrVO.getZipcode()%></span></li>
				<li><label>联系电话：</label><span><%=addrVO.getTel()%></span></li>
				<li><label>&nbsp;&nbsp;&nbsp;&nbsp;手机：</label><span><%=addrVO.getMobile()%></span></li>
			</ol>
			<p class="hr"></p>
			<h3>==订单状态==</h3>
			<ol>
				<li><label>当前状态：</label><span>正在审核中,请您在近期中注意查收</span></li>
			</ol>
		</div>
		<p id="order_bottom"></p>
	</div>
	<div id="bystp3_right">
		<!--<h2>您的此次订单的详细信息如下，请您仔细核对：</h2>-->
		<p id="zf_top">请您选择付款方式：</p>
		<div id="zf_info">
			
		</div>
		<p id="zf_bottom"></p>
		<div id="bystp3_opbtns">
			<!--<p>如果你没有疑问,请点击下一步完成些次购买;如有疑问,可点击上一步进行相关修改</p>-->
			<a href="javascript:window.history.back();"><img src="<%=SERVER%>/images/back.jpg" width="106" height="28" /></a>&nbsp;&nbsp;&nbsp;<input type="image" src="<%=SERVER%>/images/an_05.gif" width="105" height="28" />
		</div>
	</div>
	<div style="clear: both;"></div>
	</form>
</div>
<div style="clear:both;"></div>
<div id="footer">
	<script type="text/javascript" language="javascript">writefooter();</script>
</div>
</body>
</html:html>
