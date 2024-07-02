//author:Yaye

function checkForm(fm)
{
	var isPass=true;
	//alert("开始整体验证表彰了........");
	for(var i=0;i<fm.length;i++)
	{
		//这一个条件判断不可少,而且我的html中的<input>标签的alt属性也不能随意更改
		if((fm[i].alt+"").indexOf(":")==-1)
			continue;
		//alert("fm[i].name为:"+fm[i].name);
		if(!input_check(fm[i]))
		{
			//alert("难道没有进入循环里面吗......");
			isPass=false;
			fm[i].style.background='#FF0000';
		}
	}
	if(isPass){
		fm.Submit.disabled=true;
		fm.checklogonid.disabled=true;
		return true;
	}else{
		alert("您填写的信息有误，请根据页面红字更改！");
		return false;
	}
}
function input_init(){
	var frm, i, j;
	for(i=0; i<document.forms.length; i++){
		frm=document.forms[i];
		for(j=0; j<frm.length; j++){
			if((frm[j].alt+"").indexOf(":")==-1)
				continue;
			
			frm[j].onblur = function(){this.style.background=(input_check(this)==true)?'#EEEEEE':'#FF0000'}
			frm[j].onfocus = function(){this.style.background='#CCFF99';}
		}
	}
}
function input_check(obj){
	//alert("进入input_check()方法来了......");
	var name, key;
	var val=obj.value;
	//alert("obj.name为:"+obj.name);
	var oErrshow=getObject("chk_"+obj.name);
	//alert("oErrshow.id为:"+oErrshow.id);
	oErrshow.style.display = "none";
	
	switch(obj.name)
	{
		case "logonid":
			if(!check_logonid()) return false;
			break;
		case "password":
			if(!check_password()) return false;
			break;
		case "repasswd":
			if(!check_repasswd()) return false;
			break;
		case "realname":
			if(!check_realname()) return false;
			break;
		case "birthday":
			if(!check_birthday()) return false;
			break;
		case "tel":
			if(!check_tel()) return false;
			break;
		case "mobile":
			if(!check_mobile()) return false;
			break;
		case "idcard":
			if(!check_idcard()) return false;
			break;
		case "selfaddress":
			if(!check_selfaddress()) return false;
			break;
		case "zipcode":
			if(!check_zipcode()) return false;
			break;
		case "safemail":
			if(!check_email()) return false;
			break;
		case "validatecode":
			if(!check_validatecode()) return false;
			break;
		case "protocol":
			if(!check_protocol()) return false;
			break;
		default :
			return false;
			break;
	}
	return true;
}
function isExist(fm)
{
}
//my javascript check======================
function check_logonid(){
	//alert("进入check_logonid方法来了........");
	var obj = getObject('logonid');
	var name_zh = "登陆名";
	//alert("有没有走到这里来了呐....11...obj.name为:"+obj.name);
	var oErrshow=getObject("chk_"+obj.name);
	//alert("有没有走到这里来了呐....22...oErrshow.id为:"+oErrshow.id);
	if(required(obj,name_zh,oErrshow)&&minlength(obj,4,oErrshow)&&maxlength(obj,16,oErrshow)){
		return true;
	}
	return false;
}
function check_password(){
	var obj = getObject('password');
	var name_zh = "密码";
	var oErrshow = getObject("chk_"+obj.name);
	if(required(obj,name_zh,oErrshow)&&minlength(obj,6,oErrshow)&&maxlength(obj,16,oErrshow)){
		return true;
	}
	return false;
}
function check_repasswd(){
	var obj = getObject('repasswd');
	var name_zh = "重复密码";
	var oErrshow = getObject("chk_"+obj.name);
	if(required(obj,name_zh,oErrshow)&&equals(obj.value,getObject('password').value,oErrshow)){
		return true;
	}
	return false;
}
function check_realname(){
	var obj = getObject('realname');
	var name_zh = "真实姓名";
	var oErrshow = getObject("chk_"+obj.name);
	//var regexp = "";
	//&&dateformat(obj,regexp,oErrshow)
	if(required(obj,name_zh,oErrshow)){
		return true;
	}
	return false;
}
function check_birthday(){
	var obj = getObject('birthday');
	var name_zh = "出生日期";
	var oErrshow = getObject("chk_"+obj.name);
	//var regexp = "";
	//dateformat(obj,regexp,oErrshow)
	if(required(obj,name_zh,oErrshow)){
		return true;
	}
	return false;
}
function check_tel(){
	var obj = getObject('tel');
	var name_zh = "电话号码";
	var oErrshow = getObject("chk_"+obj.name);
	var val = obj.value;
	if(required(obj,name_zh,oErrshow)&&isTel(val,oErrshow)){
		return true;
	}
	return false;
}
function check_mobile(){
	var obj = getObject('mobile');
	var name_zh = "手机号码";
	var oErrshow = getObject("chk_"+obj.name);
	var val = obj.value;
	if(required(obj,name_zh,oErrshow)&&isMobile(val,oErrshow)){
		return true;
	}
	return false;
}
function check_idcard(){
	var obj = getObject('idcard');
	var name_zh = "身份证号码";
	var oErrshow = getObject("chk_"+obj.name);
	var val = obj.value;
	if(required(obj,name_zh,oErrshow)&&IdCardRegCheck(val,oErrshow)){
		return true;
	}
	return false;
}
function check_selfaddress(){
	var obj = getObject('selfaddress');
	var name_zh = "联系地址";
	var oErrshow = getObject("chk_"+obj.name);
	var val = obj.value;
	if(required(obj,name_zh,oErrshow)){
		return true;
	}
	return false;
}
function check_email(){
	var obj = getObject('safemail');
	var name_zh = "邮箱";
	//alert("有没有走到这里来了叫做...obj.name为:"+obj.name);
	var oErrshow = getObject("chk_"+obj.name);
	var val = obj.value;
	if(required(obj,name_zh,oErrshow)&&EmailRegCheck(val,oErrshow)){
		return true;
	}
	return false;
}
function check_zipcode(){
	var obj = getObject('zipcode');
	var val = obj.value;
	var name_zh = "邮政编码";
	var oErrshow = getObject("chk_"+obj.name);
	if(required(obj,name_zh,oErrshow)&&isPostalCode(val,oErrshow)){
		return true;
	}
	return false;
}
function check_protocol(){
	var obj = getObject('protocol');
	var name_zh = "该项协议";
	var oErrshow = getObject("chk_"+obj.name);
	if(checked(obj,name_zh,oErrshow)){
		return true;
	}
	return false;
}
function check_validatecode(){
	var obj = getObject('validatecode');
	var val = obj.value;
	var name_zh = "验证码";
	var oErrshow = getObject("chk_"+obj.name);
	if(required(obj,name_zh,oErrshow)&&valcode(val,oErrshow)){
		return true;
	}
	return false;
}
//my validator-rules
//必选项
function checked(obj,name,oErrshow){
	if(!obj.checked){
		oErrshow.innerHTML="×"+name+"必须选择";
		oErrshow.style.display="";
		return false;
	}
	return true;
}
//检查EMAIL
function EmailRegCheck(val,oErrshow)
{
	var patrn=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	if(!patrn.exec(val)){
		oErrshow.innerHTML="×Email格式不正确";
		oErrshow.style.display="";
		return false;
	}
	return true;
}
//校验普通电话、传真号码：可以“+”开头，除数字外，可含有“-” 
function isTel(val,oErrshow)
{ 
	//var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?(\d){1,12})+$/; 
	var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/; 
	if(!patrn.exec(val)){
		oErrshow.innerHTML="×号码无效";
		oErrshow.style.display="";
		return false;
	}
	return true;
} 

//校验手机号码：必须以数字开头，除数字外，可含有“-” 
function isMobile(val,oErrshow) 
{ 
	var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
	if(!patrn.exec(val)){
		oErrshow.innerHTML="×手机号码无效";
		oErrshow.style.display="";
		return false;
	}
	return true;
} 
//检查身份证号 
function IdCardRegCheck(val,oErrshow)
{
	var patrn=/^([0-9]{15}|[0-9]{18})$/;
	if(!patrn.exec(val)){
		oErrshow.innerHTML="×身份证号码无效";
		oErrshow.style.display="";
		return false;
	}
	return true;
}
//校验邮政编码 
function isPostalCode(val,oErrshow)
{ 
	//var patrn=/^[a-zA-Z0-9]{3,12}$/; 
	var patrn=/^[a-zA-Z0-9 ]{3,12}$/; 
	if(!patrn.exec(val)){
		oErrshow.innerHTML="×邮政编码格式不正确";
		oErrshow.style.display="";
		return false;
	}
	return true;
}
//日期格式
function dateformat(obj,regexp,oErrshow)
{
	if(!obj.value.match(regexp)){
		oErrshow.innerHTML="×格式不正确";
		oErrshow.style.display="";
		return false;
	}
	return false;
}
//检查两次输入的内容是否相同
function equals(dest,orig,oErrshow)
{
	if(!(dest == orig)){
		oErrshow.innerHTML="×两次输入不一致";
		oErrshow.style.display="";
		return false;
	}
	return true;
}
function required(obj,name,oErrshow)
{
	//alert("进入required方法来了......");
	if(obj.value == ""){
		oErrshow.innerHTML="×请输入"+name;
		oErrshow.style.display="";
		return false;
	}
	return true;
}
function minlength(obj,length,oErrshow)
{
	if(strLength(obj.value)<length){
		oErrshow.innerHTML="×长度必须大于"+length;
		oErrshow.style.display="";
		return false;
	}
	return true;
}
function maxlength(obj,length,oErrshow)
{
	if(strLength(obj.value)>length){
		oErrshow.innerHTML="×长度必须小于"+length;
		oErrshow.style.display="";
		return false;
	}
	return true;
}
function valcode(val,oErrshow)
{
	var patrn=/^[a-zA-Z0-9]{4}$/; 
	if (!patrn.exec(val)){
		oErrshow.innerHTML="×验证码包含其它字符";
		oErrshow.style.display="";
		return false;
	} 
	return true;
}
//util methods  **************************
function getObject(objId)
{
	return document.getElementById(objId);
}
function strLength(str)
{
	var lte=escape(str);
	var len;
	len=lte.length - (lte.length-lte.replace(/\%u/g, "u").length)*4;
	lte=lte.replace(/\%u/g, "uu");
	len=len-(lte.length - lte.replace(/\%/g, "").length)*2;
	return len;
}
function ShowStrong(obj,oMsg,status)
{
	var obj = getObject(obj);
	if(status==1){
			obj.innerHTML = oMsg
	}else{
			obj.innerHTML = ""
	}
}

//checkStrong函数 返回密码的强度级别
function checkStrong(sPW){
	Modes=0;
	for (i=0;i<sPW.length;i++){
			//测试每一个字符的类别并统计一共有多少种模式.
			Modes|=CharMode(sPW.charCodeAt(i));
	}
	var btotal = bitTotal(Modes);
	if (sPW.length >= 10) btotal++;
	switch(btotal) {
			case 1:
					return "<table width='130' class='pswstrong'><tr><td bgcolor='#FE707E'><strong>弱</strong></td><td><span style='color:#666;'>中</span></td><td><span style='color:#666;'>强</span></td></tr></table>";
					break;
			case 2:
					return "<table width='130' class='pswstrong'><tr><td bgcolor='#FCFA93'><span style='color:#666;'>弱</span></td><td bgcolor='#FCFA93'><strong>中</strong></td><td><span style='color:#666;'>强</span></td></tr></table>";
					break;
			case 3:
					return "<table width='130' class='pswstrong'><tr><td bgcolor='#BDFEA6'><span style='color:#666;'>弱</span></td><td bgcolor='#BDFEA6'><span style='color:#666;'>中</span></td><td bgcolor='#BDFEA6'><strong>强</strong></td></tr></table>";
					break;
			default:
					return "<font color='#33CC00'>强</font>";
	}
}

function CharMode(iN){
	if (iN>=65 && iN <=90) //大写字母
	return 2;
	if (iN>=97 && iN <=122) //小写
	return 4;
	else
	return 1; //数字
}
//计算出当前密码当中一共有多少种模式
function bitTotal(num){
	modes=0;
	for (i=0;i<3;i++){
			if (num & 1) modes++;
			num>>>=1;
	}
	return modes;
}