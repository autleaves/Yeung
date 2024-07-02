//这个方法不能进行正确显示出效果,确切来说,是显示不出来一点内容,因为j不能
function initHeader(){
	FillLogon();
	FillNavwords();
	FillSearchwords();
	FillKeywords();
}
function FillLogon(){
	var cookies = document.cookie.split("; ");
	for(var i=0; i<cookies.length; i++){
	   if(cookies[i].search('LOGONID')>-1){
		var cookie = cookies[i].split("=");
		if(cookie[0] == "LOGONID" || cookie[0].equals("LOGONID")){
			document.getElementById("logon").innerHTML="<span>"+ cookie[1] +"</span>&nbsp;|&nbsp;<a href='http://localhost:8077/Yaye/exitByListener.do'>注销</a>";
		}
	    }
	}
}
function FillNavwords()
{
	var class1Tabs=new Array();
	var class2Tabs=new Array();
	
	for(i=0;i<Navwords.data.length;i++)
	{
		if(Navwords.data[i].cssclass=='1')
		{
			class1Tabs.push(Navwords.data[i]);
		}else{
			class2Tabs.push(Navwords.data[i]);
		}
	}
	var htmls = "";
	for(var i = 0; i < class1Tabs.length; i++)
	{
		htmls = htmls + "<li class='current'><a href='" + class1Tabs[i].href + "'><span>" +
					class1Tabs[i].text + "</span></a></li>";
	}
	for(var i = 0; i < class2Tabs.length; i++)
	{
		htmls = htmls + "<li><a href='" + class2Tabs[i].href + "'><span>" + 
					class2Tabs[i].text + "</span></a></li>";
	}
	document.getElementById('nav_listxxx').innerHTML=htmls;
	
}
function FillSearchwords()
{	
	var searchObj = document.getElementById('classification');
	for(var i = 0; i < searchwords.data.length; i++)
	{
		var oItem = document.createElement("OPTION");
		oItem.text = searchwords.data[i].text;
		oItem.value = searchwords.data[i].cfid;
		searchObj.options.add(oItem);
	}
}
function FillKeywords()
{
	var htmls = "&nbsp;";
	for(var i = 0; i < keywords.data.length; i++)
	{
		htmls = htmls + "<a href='" + keywords.data[i].href + "' target=_blank class='ti'>" + 
					keywords.data[i].text + "</a>&nbsp;"
	}
	document.getElementById('keywords').innerHTML=htmls;
	
}




function showpopup(popup){
	document.getElementById(popup).style.display="block";
}
function hidepopup(popup){
	document.getElementById(popup).style.display="none";
}
function golink(ind){
	var ind_int = parseInt(ind);
	switch (ind_int)
	{
		case 0 :
			window.open('http://www.google.com');
			break;
		case 1 :
			window.open('');
			break;
		case 2 :
			window.open('');
			break;
		case 3 :
			window.open('');
			break;
		case 4 :
			window.open('');
			break;
		case 5 :
			window.open('');
			break;
		case 6 :
			window.open('');
			break;
		default :
			window.open('index.html');
	}
}

/*function login(){
	alert("popup!");
	var loginPopup = window.createPopup();
	var loginPopupBody = loginPopup.document.body;
	loginPopupBody.innerHTML = "在这里显示 <B>HTML</B>";
	loginPopup.show(100, 100, 200, 50, document.body);
}*/
