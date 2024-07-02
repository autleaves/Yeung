<%@ page pageEncoding="utf-8"%>
<%@ page import="mil.yaye.yours.vo.InitVO" %>
<%@ include file="inc/common.jspf" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html lang="true">
  <head>
     <%--<html:base />--%>
    <title><bean:write name="productVO" property="productname"/> -RedRose商城</title>
	<%@ include file="inc/meta_css_script.jspf" %>
	<!-- self links -->
	<link href="<%=SERVER%>/css/product.css" rel="stylesheet" type="text/css" />
	<link href="<%=SERVER%>/css/cartHelper.css" rel="stylesheet" type="text/css" />
	<!-- self javascript -->
	<script type="text/javascript" src="<%=SERVER%>/js/cartHelper.js"></script>
	<script type="text/javascript">
		
	</script>
  </head>
  
  <body>
    <div id="header">
		<!--<%@ include file="inc/header.jspf" %>-->
		<script type="text/javascript" language="javascript">writeheader();</script>
		<script type="text/javascript" language="javascript">FillLogon();FillNavwords();FillSearchwords();FillKeywords();</script>
	</div>
	<div style="clear: both;"></div>
	<div id="curr_location" class="">
		您的位置：
		<a href="<%=SERVER%>/index.html">首页</a>&nbsp;&gt;
		<logic:notEmpty name="catalogMap" scope="request">
			<%
				Map<Integer, InitVO> catalog = (Map<Integer, InitVO>) request.getAttribute("catalogMap");
				for(int i = catalog.size() - 1; i >= 0; i--){
					InitVO initVO = catalog.get(i);
			%>
			<a href="<%=SERVER%>/category.do?categoryid=<%=initVO.getKey()%>"><%=initVO.getValue()%></a>&nbsp;&gt;
			<%
				}
			%>
			<!--<logic:iterate name="catalogMap" id="cata" scope="request">
				<a href="/category.do?categoryid=<bean:write name='cata' property='key' />"><bean:write name="cata" property="value"/></a>&nbsp;&gt;
			</logic:iterate>-->
			<span id="product_name_loc" onmouseover="javascript:this.style.color='#FF0000'" onmouseout="javascript:this.style.color=''"><bean:write name="productVO" property="productname" /></span>
		</logic:notEmpty>
	</div>
	<div id="product_info" class="">
		<div id="prod_thr_le" class="prod_thr">
	   		<li id="product_image"><a href=""><img src='<%=SERVER%>/<bean:write name="productVO" property="thumbnail" />' width='170' height='170' /></a></li>
			<li id="zoom_bt"><a href=""><img src="<%=SERVER%>/images/ce_lp_018.gif" width="79" height="20" /></a></li>
		</div>
		<div id="prod_thr_ce" class="prod_thr">
			<span id="product_name" class="prod_span_toblock"><bean:write name="productVO" property="productname" /></span>
			<span id="" class="prod_span_toblock">市场价：<span id="product_market_price">￥%market_price%</span>&nbsp;&nbsp;&nbsp;商城价：<span id="product_our_price">￥<bean:write name="productVO" property="price"/></span></span>
			<span id="product_comment" class="prod_span_toblock">查看商品评价：<a href=""><img src="<%=SERVER%>/images/view_comment.jpg" width="79" height="20" /></a>
				<a id="buy_a" href="<%=SERVER%>/buy/immedbuy.do?productid=<bean:write property="productId" name="productVO" />"><img src="<%=SERVER%>/images/mall_buybtn02_ws.gif" width="86" height="23" /></a></span>
			<span id="" class="prod_span_toblock">商品描述：<br/>
		  <span id="product_description"><bean:write name="productVO" property="description" /></span></span>
	  	</div>
		<div id="prod_thr_ri" class="prod_thr">
			<span id="thr_ri_hea">RedRose品牌店</span>
			<span id="thr_ri_hea_2">不一样的色彩&nbsp;&nbsp;不一样的体验。。。</span>
			<li><a href="javascript:addproduct();"><img src="<%=SERVER%>/images/put_cart_bt.jpg" width="105" height="27" /></a></li>
			<li><a href=""><img src="<%=SERVER%>/images/youan_03.gif" width="105" height="27" /></a></li>
			<li><a href=""><img src="<%=SERVER%>/images/youan_04.gif" width="105" height="27" /></a></li>
	  	</div>
	</div>
	<div style="clear: both;"></div>
	<!--<div id="other_products">
		<span>您可能还对以下商品感兴趣</span>
	</div>-->
	<div id="footer">
		<script type="text/javascript" language="javascript">
			writefooter();
		</script>
	</div>
	<!-- z-index层 -->
	<div id="waitLayer">
		<!--<p id="waly_top"></p>
		<div id="waly_cont">
			<img src="../images/indicator.gif" /><span>请等待...</span>
		</div>
		<p id="waly_bottom"></p>-->
	</div>
	<div id="cartHelper">
		<!--<p id="hper_top"><img id="hper_close" src="../images/cahper_close.jpg" alt="close layer" style="cursor:pointer;" onclick="close_cartHelper();"/></p>
		<div id="hper_cont">
			<h2>购物车共有<span>5</span>件宝贝</h2>
			<p id="hpcn_btns"><a href=""><img src="../images/cahper_vica.jpg" /></a><a href=""><img src="../images/cahper_cone.jpg" /></a></p>
		</div>
		<p id="hper_bottom"></p>-->
	</div>
  </body>
</html:html>
