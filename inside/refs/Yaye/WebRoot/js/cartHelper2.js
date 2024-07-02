function addproduct(id){
	writeWaitLayer();
	get('waitLayer').style.display='block';
	alert('Here..正在进行Ajax异步请求......');
	get('waitLayer').style.display='none';
	writeCartHelper();
	get('cartHelper').style.display='block';
}
function close_cartHelper(){
	document.getElementById('cartHelper').style.display='none';
}
function get(obj){
	return document.getElementById(obj);
}
function writeWaitLayer(){
	get('waitLayer').innerHTML=
		"<h2 id='waly_top'></h2>"
		+"<div id='waly_cont'>"
			+"<img src='../images/indicator.gif' /><span>请等待...</span>"
		+"</div>"
		+"<p id='waly_bottom'></p>";
	}
function writeCartHelper(){
	get('cartHelper').innerHTML=
		"<p id='hper_top'><img id='hper_close' src='../images/cahper_close.jpg' alt='close layer' style='cursor:pointer;' onclick='close_cartHelper();'/></p>"
		+"<div id='hper_cont'>"
			+"<h2>购物车共有<span>5</span>件宝贝</h2>"
		+"<p id='hpcn_btns'><a href=''><img src='../images/cahper_vica.jpg' /></a><a href=''><img src='../images/cahper_cone.jpg' /></a></p>"
		+"</div>"
		+"<p id='hper_bottom'></p>";
}