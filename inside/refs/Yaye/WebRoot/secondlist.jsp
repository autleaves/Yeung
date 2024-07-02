<%@ page pageEncoding="utf-8"%>
<%@ page import="mil.yaye.yours.common.Constants,mil.yaye.yours.util.PageHelper"%>
<%@ page import="mil.yaye.yours.vo.ProductVO"%>
<%@ include file="inc/common.jspf" %>
<%
PageHelper pageHelper = (PageHelper)request.getAttribute(Constants.PAGINATE_HELPER);
Integer categoryId = (Integer) pageHelper.getParameter("categoryId");
List<ProductVO> productlist = (List<ProductVO>)request.getAttribute("productlist");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html lang="true">
<head>
	<title>二级导航页面</title>
	<%@ include file="inc/meta_css_script.jspf" %>
	<!-- self links and javascript -->
	<link href="css/secondlist.css" rel="stylesheet" type="text/css" />
	<link href="css/block-css/searchbox.css" rel="stylesheet" type="text/css" />
	<link href="css/block-css/paginatebar.css" rel="stylesheet" type="text/css" />
	<!--<script type="text/javascript" src="js/utils/paginatebar.js"></script>-->
</head>

<body>
<div id="header">
	<%--<%@ include file="inc/header.jspf" %>--%>
	<script type="text/javascript" language="javascript">writeheader();</script>
	<script type="text/javascript" language="javascript">FillLogon();FillNavwords();FillSearchwords();FillKeywords();</script>
</div>
<div style="clear: both;"></div>
<div id="search_statistic_result" class="">
	RedRose商城在<span id="ser_sta_re_ca" class="ser_sta_result">&quot;女性服饰&quot;</span>分类中查找<span id="ser_sta_re_ke" class="ser_sta_result">&quot;背心/吊带衫&quot;</span>，为您找到相关结果<span id="ser_sta_re_nu" class="ser_sta_result"><bean:write property='totalRecord' name='pageHelper' /></span>条
</div>
<div id="secn_main">
	<div id="secn_left">
		<div id="search_box">
    	<img src="images/sear_up.jpg" width="242" height="7" />
		<div id="seb_cont">
	    	<img src="images/searpr_sosotops.gif" width="74" height="16" />
			<p class="seb_p"><label>品&nbsp;&nbsp;&nbsp;&nbsp;牌：</label>
			<select id="seb_brands" name="seb_brands">
				<option value="">婷美康美婷</option>
			</select></p>
			<p class="seb_p"><label>类&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
			<select id="seb_category" name="seb_category">
				<option value="">婷美康美婷</option>
				<option value="">纤诗婷</option>
			</select></p>
			<p class="seb_p"><label>关&nbsp;键&nbsp;字：</label><input type="text" id="" name="" /></p>
			<p class="seb_p"><label>价格范围：</label><input type="text" id="" name="" style="width: 53px;" /><span>&nbsp;~&nbsp;</span><input type="text" id="" name="" style="width: 53px;" /></p>
			<p id="subprbtn"><a href=""><img src="images/sear_soso.gif" width="170" height="25" /></a></p>
		</div>
    	<img src="images/sear_down.jpg" width="242" height="8" />
		</div>
		<div id="searchbrands_box">
		<img src="images/sear_up.jpg" width="242" height="7" />
		<div id="sebbr_cont">
	    	<img src="images/searbr_cytops.gif" width="135" height="16" />
			<p class="seb_p"><label>请选择品牌：</label>
			<select id="sebbr_brands" name="sebbr_brands">
				<option value="">婷美康美婷</option>
			</select></p>
			<p class="seb_p"><label>您所在城市：</label>
			<select id="sebbr_province" name="sebbr_province">
				<option value="">请选择</option>
				<option value=""></option>
			</select>
			<select id="sebbr_city" name="sebbr_city">
				<option value="">请选择</option>
				<option value=""></option>
			</select></p>
			<p id="subbrbtn"><a href=""><img src="images/sear_soso.gif" width="170" height="25" /></a></p>
		</div>
    	<img src="images/sear_down.jpg" width="242" height="8" />
		</div>
	</div>
	<div id="secn_right_productslist">
		<div id="list_head">
			<img src="images/keywords_up7.jpg" width="700" height="4" />
			<div class="display">
				显示方式：
				<img src="images/list_on.gif" alt="横列式图标" id="ChangeStyleImg01" title="横列式" onclick="changeProducView('bar')" height="15" width="18" />
				<img src="images/block_off.gif" alt="分块式图标" id="ChangeStyleImg02" title="分块式" onclick="changeProducView('block')" height="15" width="18" />
				<span class="fav">
				<img src="images/mall_myf_ws.gif" alt="收藏目录图标" class="GoodsTopL01OTFimg" title="查看您的收藏目录" height="15" width="19" />
				<a href="" target="_blank">查看您的收藏目录</a>
				</span>
			</div>
			<div class="orderinfo">
				排序方式：&nbsp;时间：
				<img id="time1" onclick="changeOrder('t1')" src="images/ico_sortdescena.gif"  alt="按更新时间从近到远" height="15" width="18" />
				<img id="time0" onclick="changeOrder('t0')" src="images/ico_sortascdis.gif" alt="按更新时间从远到近" height="15" width="18" />
				价格：
				<img id="price0" onclick="changeOrder('p0')" src="images/ico_sortascdis.gif"  alt="按商品价格从高到低" height="15" width="18" />
				<img id="price1" onclick="changeOrder('p1')" src="images/ico_sortdescdis.gif" alt="按商品价格从低到高" border="0" height="15" width="18" />
				
				<span class="shownumber">
					每页显示商品数量：
					<a href="http://localhost:8077/Yaye/category.do?categoryid=<%=categoryId%>&page=<bean:write property='currentPage' name='pageHelper'/>&size=20"><img alt="" src="images/20-2.gif"/></a>
					<a href="http://localhost:8077/Yaye/category.do?categoryid=<%=categoryId%>&page=<bean:write property='currentPage' name='pageHelper'/>&size=40"><img alt="" src="images/40-1.gif"/></a>
					<a href="http://localhost:8077/Yaye/category.do?categoryid=<%=categoryId%>&page=<bean:write property='currentPage' name='pageHelper'/>&size=80"><img alt="" src="images/80-1.gif"/></a>
					<!--<input type="image" name="Img_ProductCount20" id="Img_ProductCount20" src="images/20-2.gif" />
					<input type="image" name="Img_ProductCount40" id="Img_ProductCount40" src="images/40-1.gif" />
					<input type="image" name="Img_ProductCount80" id="Img_ProductCount80" src="images/80-1.gif" />-->
				</span>
			</div>
			<img src="images/keywords_down7.jpg" width="700" height="4" />
		</div>
		<div id="list_wrapper">
			<div><img src="images/keywords_up7.jpg" width="700" height="4" /></div>
			<div id="products">
				<logic:present name="productlist" scope="request">
					<logic:iterate id="model" name="productlist" scope="request" type="mil.yaye.yours.vo.ProductVO">
						<div class="goods">
							<div class="goodscheckbox">
								<input type="checkbox" class="" />
							</div>
							<div class="goodsimage">
								<!--<img src="" width="170" height="170" />	-->
						    	<img src="<%=Constants.SERVER%>/<bean:write property='minimage' name='model' />" />															
							</div>
							<div class="goodsinfo">
								<p>商品名称：<a target="_blank" href="<%=SERVER%>/productshtmls/product_<bean:write property='productId' name='model'/>.htm" onclick="javascript:thirdview();"><bean:write property="productname" name="model"/></a>
		                        </p>
		                        <p>详细信息：<span><bean:write name="model" property="description"/></span></p>
		                        <p>更新时间：2008-04-18 20:33:00</p>
							</div>
							<div class="goodsbuy">
								<p class="fBlack01">商城价：<span class="price"><bean:write name="model" property="price"/>.00元</span></p>
		                        <p><img src="<%=Constants.SERVER%>/images/mall_buybtn02_ws.gif" style="cursor: pointer;" alt="购买按钮" title="立即购买" onclick="AddProductToCart(<bean:write property='productId' name='model' />,?)" />
		                        </p>
		                        <p><span class="goodsfav"><a href=""><img src="images/mall_myf02_ws.gif" alt="收藏夹图标" title="收藏" /></a></span>
		                            <a href="">收藏</a>
		                        </p>
							</div>
						</div>
						<div style="clear: both;"></div>
					</logic:iterate>
				</logic:present>
			</div>
			<!--CSS Green style pagination-->
			<div id="paginatebar" class="scott">
				<!-- <script type="text/javascript" language="javascript">writepaginatebar();</script> -->
				<%
				if(productlist.size() > 0){%>
					<span>共&nbsp;<span><bean:write property="totalPage" name="pageHelper"/></span>&nbsp;页</span>&nbsp;<span>共&nbsp;<span><bean:write property="totalRecord" name="pageHelper"/></span>&nbsp;项</span>&nbsp;&nbsp;
					<logic:equal value="1" property="currentPage" name="pageHelper" scope="request">
						<span class='disabled'>首页</span>&nbsp;&nbsp;&nbsp;
						<span class='disabled'>&nbsp;&lt;&nbsp;</span>
					</logic:equal>
					<logic:notEqual value="1" property="currentPage" name="pageHelper" scope="request">
						<a href='http://localhost:8077/Yaye/category.do?categoryid=<%=categoryId%>&size=<bean:write property='pageSize' name='pageHelper'/>&page=1'>首页</a>&nbsp;&nbsp;&nbsp;
						<a href='http://localhost:8077/Yaye/category.do?categoryid=<%=categoryId%>&size=<bean:write property='pageSize' name='pageHelper'/>&page=<bean:write property="prevPage" name="pageHelper"/>'>&nbsp;&lt;&nbsp;</a>
					</logic:notEqual>
					<%--设定分页栏显示6个页码--%><%--list里放的是page编号--%><!---->
					<logic:iterate id="model" property="list" name="pageHelper" scope="request">
							<logic:equal value="${pageHelper.currentPage}" name="model">
								<span class='current'><bean:write property='currentPage' name='pageHelper' /></span>							
							</logic:equal>
							<logic:notEqual value="${pageHelper.currentPage}" name="model">
								<a href="http://localhost:8077/Yaye/category.do?categoryid=<%=categoryId%>&size=<bean:write property='pageSize' name='pageHelper'/>&page=<bean:write name='model' />"><bean:write name="model" /></a>
							</logic:notEqual>
					</logic:iterate>
					
					<logic:equal value="${pageHelper.totalPage}" property="currentPage" name="pageHelper" scope="request">
						<span class='disabled'>&nbsp;&gt;&nbsp;</span>
						&nbsp;&nbsp;&nbsp;<span class='disabled'>末页</span>
					</logic:equal>
					<logic:notEqual value="${pageHelper.totalPage}" property="currentPage" name="pageHelper" scope="request">
						<a href='http://localhost:8077/Yaye/category.do?categoryid=<%=categoryId%>&size=<bean:write property='pageSize' name='pageHelper'/>&page=<bean:write property='nextPage' name='pageHelper' />'>&nbsp;&gt;&nbsp;</a>
						&nbsp;&nbsp;&nbsp;<a href='http://localhost:8077/Yaye/category.do?categoryid=<%=categoryId%>&size=<bean:write property='pageSize' name='pageHelper'/>&page=<bean:write property='totalPage' name='pageHelper' />'>末页</a>
					</logic:notEqual>
				<%}else{%>
					<span>共&nbsp;<span><bean:write property="totalPage" name="pageHelper"/></span>&nbsp;页</span>&nbsp;<span>共&nbsp;<span><bean:write property="totalRecord" name="pageHelper"/></span>&nbsp;项</span>&nbsp;&nbsp;
					<span class='disabled'>首页</span>&nbsp;&nbsp;&nbsp;
					<span class='disabled'>&nbsp;&lt;&nbsp;</span>
					<span class='disabled'>&nbsp;&gt;&nbsp;</span>
					&nbsp;&nbsp;&nbsp;<span class='disabled'>末页</span>
				<%}
				%>
			</div>
			<div><img src="images/keywords_down7.jpg" width="700" height="4" /></div>
			</div>
	</div>
	<div style="clear:both;"></div>
</div>
<div style="clear: both;"></div>
<div id="footer">
	<script type="text/javascript" language="javascript">writefooter();</script>
</div>
</body>
</html:html>
