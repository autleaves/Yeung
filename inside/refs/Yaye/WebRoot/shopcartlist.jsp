<%@ page pageEncoding="utf-8"%>
<%@ include file="inc/common_withsession.jspf"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
  <%--<html:base />--%>
  <title>buystep1 -RedRose商城</title>
	<%@ include file="inc/meta_css_script.jspf"%>
	<meta http-equiv="keywords" content="RedRose电子商城,女性,女性内衣">
	<meta http-equiv="description" content="TRedRose电子商城">
	<!-- self links -->
	<link href="<%=SERVER%>/css/buystepcommon.css" rel="stylesheet" type="text/css" />
	<link href="<%=SERVER%>/css/buystep1.css" rel="stylesheet" type="text/css" />
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
<div id="buystep1_main" class="">
  <h2 id="buysteps_top"><img src="<%=SERVER%>/images/buysteps_top.jpg" height="38" /></h2>
  <div id="buystep1_content" class="">
		<div id="buysts_tips">
		商城提示：我们按照不同的商户生成订单，此次购物您从北京联想直销中心  1 家商户中购买了商品，因此生成1张订单。
北京联想直销中心 是新浪商城的经销商之一，您所购买的产品由他们提供，并为您提供更多的服务。
请您确认每张订单的收货地址和付款方式。
		</div>
		<bean:size id="prodsnum" name="SHOPCART_SIMPLE_INFO" scope="session" />
		<logic:lessEqual value="0" name="prodsnum">
			对不起,你还没有挑选任何宝贝!
		</logic:lessEqual>
		<logic:greaterThan value="0" name="prodsnum">
			<logic:present name="SHOPCART_PARTICULAR" scope="session">
			<div id="buy_productslist">
				<table width="100%" cellspacing="1" cellpadding="0">
					<tbody>
					<tr height="20">
						<td width="70"><input type="checkbox" name="selectall" />全选</td>
						<td width="270">商品</td>
						<td>获积分&lt;点&gt;</td>
						<td>单价&lt;元&gt;</td>
						<td>数量</td>
						<td>优惠</td>
						<td>合计&lt;元&gt;</td>
						<td width="70"></td>
					<tr>
				<logic:iterate id="model" name="SHOPCART_PARTICULAR" scope="session">
					<tr>
						<td><input type="checkbox" name="pr" /></td>
						<td class="buy_tab_td"><img src="<%=SERVER%>/productshtmls/prod_<bean:write property='productId' name='model' />.html" width='84' height='63' /><bean:write property="productname" name="model" /></td>
						<td class="buy_tab_td">10</td>
						<td class="buy_tab_td"><bean:write property="price" name="model" /></td>
						<td class="buy_tab_td"><a href="javascript:;" class="minus">-</a>
			<input type="text" value="1" class="text-amount" max="<bean:write property='quantity' name='model'/>" now="1" /><a href="javascript:;" class="plus">+</a></td>
						<td class="buy_tab_td">无</td>
						<td class="buy_tab_td"><bean:write property='price' name='model' /></td>
						<td class="buy_tab_td"><a href="<%=SERVER%>/buy/delete.do?productid=<bean:write property='productId' name='model' />"><img src="<%=SERVER%>/images/mall_myf02_ws.gif" width="13" height="10" />删除</a></td>
					</tr>
				</logic:iterate>
					</tbody>
				</table>
			</div>
			<div id="buy_totalmoney">
				您所选购的商品价格总计为：<span>xxx元</span>&nbsp;总计数量为<span>n</span>个&nbsp;您可获取积分<span>n</span>点
			</div>
		    <a href="javascript:window.history.back();"><img src="<%=SERVER%>/images/an_03.gif" width="106" height="28" /></a>&nbsp;&nbsp;&nbsp;
			<a href="<%=SERVER%>/buy/backaddrs.do"><img src="<%=SERVER%>/images/an_05.gif" width="105" height="28" /></a>
			</logic:present>
		</logic:greaterThan>
  </div>
  <h2 id="buysteps_bottom"><img src="<%=SERVER%>/images/buysteps_bottom.jpg" height="7" /></h2>
</div>
<div style="clear:both;"></div>
<div id="footer">
	<script type="text/javascript" language="javascript">writefooter();</script>
</div>
</body>
</html:html>
