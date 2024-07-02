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
function get(objId){
	return document.getElementById(objId);
}
function required(inp){
	if(get(inp).value==null || get(inp).value==""){
		return false;
	}
	return true;
}
function checkLogonForm(){
	if(!required('logonid')){
		get('lo_show_err').innerHTML="×用户名不能为空！"
		get('logonid').focus();
		return false;
	}
	if(!required('password')){
		get('lo_show_err').innerHTML="×密码不能为空！"
		get('password').focus();
		return false;
	}
	return true;
	// if(required('logonid') && required('password')){
	// 	return true;
	// }else {
	// 	get('lo_show_err').innerHTML="×用户名或密码不能为空！"
	//	get('logonid').focus();
	//	return false;
	// }
}
function checkValcLogonForm(){
	if(!required('logonid')){
		get('lo_show_err').innerHTML="×用户名不能为空！"
		get('logonid').focus();
		return false;
	}
	if(!required('password')){
		get('lo_show_err').innerHTML="×密码不能为空！"
		get('password').focus();
		return false;
	}
	if(!required('valcode')){
		get('lo_show_err').innerHTML="×验证码不能为空！"
		get('valcode').focus();
		return false;
	}
	return true;
}
