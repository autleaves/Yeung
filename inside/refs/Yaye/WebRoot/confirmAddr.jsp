<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="mil.yaye.yours.vo.AddressVO,mil.yaye.yours.pojo.User"%>
<%@ include file="inc/common_withsession.jspf"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
  <title>buystep2  -RedRose商城</title>
	<%@ include file="inc/meta_css_script.jspf"%>
	<meta http-equiv="keywords" content="RedRose电子商城,女性,女性内衣">
	<meta http-equiv="description" content="TRedRose电子商城">
	<!-- self links -->
	<link href="<%=SERVER%>/css/buystepcommon.css" rel="stylesheet" type="text/css" />
	<link href="<%=SERVER%>/css/buystep2.css" rel="stylesheet" type="text/css" />
	<!-- self javascript -->
	<script type="text/javascript" language="javascript" src="http://localhost:8077/Yaye/js/values/area.js"></script>
	<script type="text/javascript" language="javascript" src="http://localhost:8077/Yaye/js/values/CitysValue.js"></script>
	<script type="text/javascript" language="javascript" src="http://localhost:8077/Yaye/js/values/CountrysValue.js"></script>
	<script type="text/javascript" language="javascript" src="http://localhost:8077/Yaye/js/values/ProvincesValue.js"></script>
	<script type="text/javascript">
		function show_addrForm(){
			if(get('radio_close').checked == true){
				get('span_close').style.display="none";
				get('newAddr_form').style.display="block";
				get('radio_open').checked=true;
			}
		}
		function hide_addrForm(){
			if(get('radio_close').checked == false){
				get('span_close').style.display="block";
				get('newAddr_form').style.display="none";
				get('radio_open').checked=false;
			}
		}
		function checkAddrForm(){
			var addr = document.getElementsByName('addr');
			var flag = false;
			for(var i=0; i<addr.length; i++){
				if(addr[i].checked){
					flag=true;
					break;
				}
			}
			if(flag == false){
				alert('您还没有选择一个收货人地址,请选择!');
			}
			return flag;
		}
		function get(obj){
			return document.getElementById(obj);
		}
	</script>
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
<div id="buystep2_main">
	<h2>确认收货地址:<span>(你可以从您的历史收货地址中选择一个,也可以重新填写一个新的地址)</span></h2>
	<logic:present name="ADDR_MAP" scope="session">
	<form name="addrform" id="addrform" action="<%=SERVER%>/buy/confirmaddr.do" method="post" onsubmit="return checkAddrForm();">
	<div id="addrs_wrapper">
		<%
		Map<String, AddressVO> addrs = (Map<String, AddressVO>)session.getAttribute("ADDR_MAP");
		Set<String> addrKeySet = addrs.keySet();
		Iterator<String> iter_addrKeySet = addrKeySet.iterator();
		String addrkey = null;
		AddressVO addrVO = null;
		User user = null;
		while(iter_addrKeySet.hasNext()){
			addrkey = iter_addrKeySet.next();
			addrVO = addrs.get(addrkey);
			user = addrVO.getUser();
			String value = "ADDR_" + addrVO.getAddressId();
			%>
			<p class="addrs"><input type="radio" name="addr" value="<%=value%>" onclick="hide_addrForm()" /><%=addrVO.getProvince()%>&nbsp;<%=addrVO.getCity()%>&nbsp;<%=addrVO.getSelfaddress()%>（收货人：<%=user.getUsername()%>）</p>
			<%
		}
		%>
		<p class="addrs" id="span_close"><input type="radio" name="addr" id='radio_close' onclick="show_addrForm()" />使用其它地址</p>
		<div id="newAddr_form">
			<span><input type="radio" name="addr" value="ADDR_NEW" id="radio_open" />使用其它地址</span>
			<h4>请填写地址信息</h4>
				<p id="adspa_spa1" class="adspa">
					<input type="hidden" name="country" id="country" value="zh" />
					<span>省：<span class="re_vip">*</span><select name="province" id="province" onchange="loadCitys(this.value)">
							<option value="0">-选择省份-</option>
						</select></span>
					<span>市：
						<select name="city" id="city">
							<option value="0">-选择城市-</option>
						</select></span>
					<span>邮政编码：<span class="re_vip">*</span><input type="text" name="zipcode" id="zipcode" alt="邮政编码:" /></span>
				</p>
				<p id="adspa_spa2" class="adspa">
					街道地址：<span class="re_vip">*</span><textarea name="selfaddr" id="selfaddr" style="width: 370px; height: 30px;"></textarea>
				</p>
				<p class="hr"></p>
				<p id="adspa_spa3" class="adspa">
					<span>收货人姓名：<span class="re_vip">*</span><input type="text" name="consignee" id="consignee" /></span>
				</p>
				<p id="adspa_spa4" class="adspa">
					<span>电话：<input type="text" name="tel" id="tel" /></span>
				</p>
				<p id="adspa_spa5" class="adspa">
					<span>手机：<input type="text" name="mobile" id="mobile" /><label>电话和手机请至少填写一个</label></span>
				</p>
		</div>
		<div id="btns">
			<a href="<%=SERVER%>/buy/myshopcart.do"><img src="<%=SERVER%>/images/back.jpg" width="106" height="28" /></a>&nbsp;&nbsp;&nbsp;<input type="image" src="<%=SERVER%>/images/an_05.gif" width="105" height="28" />
		</div>
	</div>
	</form>
	</logic:present>
</div>
<div style="clear:both;"></div>
<div id="footer">
	<script type="text/javascript" language="javascript">writefooter();</script>
</div>
</body>
</html:html>
