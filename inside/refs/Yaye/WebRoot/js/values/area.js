function FillCountrys(){
	var country = document.getElementById('country');
	for(var i=0; i<countrys.data.length; i++){
		var oItem = document.createElement("option");
		oItem.value = countrys.data[i].value;
		oItem.text = countrys.data[i].text;
		country.options.add(oItem);
	}
}
function loadProvinces(country){
	var refPros = document.getElementById('province');
	refPros.options.length = 0;
	switch(country)
	{
		case "0" :
			var oItemPro = document.createElement("OPTION");
			oItemPro.value = "0";
			oItemPro.text = "-选择省份-";
			refPros.options.add(oItemPro);
			var refCitys = document.getElementById('city');
			var oItemCity = document.createElement("OPTION");
			oItemCity.value = "0";
			oItemCity.text = "-选择城市-";
			refCitys.options.length = 0;
			refCitys.options.add(oItemCity);
			break;
		case "zh" :
			loadProvinces_helper(refPros,provinces_zh);
			//loadProvinces_helper(refPros,countrys.data[0].refPro);
			break;
		case "en" :
			loadProvinces_helper(refPros,provinces_en);
			break;
		case "jp" :
			loadProvinces_helper(refPros,provinces_jp);
			break;
		case "ko" :
			loadProvinces_helper(refPros,provinces_ko);
			break;
		default:
			loadProvinces_helper(refPros,provinces_zh);
			break;
	}
}
//我的加载相关城市的方法有问题
function loadProvinces_helper(refPros, provinces){
	for(var i=0; i<provinces.data.length; i++){
		var oItem = document.createElement("OPTION");
		oItem.value = provinces.data[i].value;
		oItem.text = provinces.data[i].text;
		refPros.options.add(oItem);
	}
}
/*function loadCitys(province){
	var country = province.substring(0,province.indexOf('_',0));
	var pro = province.substring(province.indexOf('_',0)+1);
	var citys = "citys_"+pro+"_"+country;
	var cityAccount;
	for(var i=0; i<countrys.data.length; i++){
		if(country == countrys.data[i].value){
			for(var j=0; j<){
				if(citys == ){
				
				}
			}
			cityAccount = 
		}
	}
	alert("citys为:"+"citys_"+pro+"_"+country);
	loadCitys_helper("citys_"+pro+"_"+country);
}
function loadCitys_helper(refCitys, citys){
	refCitys.options.length = 0;
	alert("helper的citys为:"+citys);
	for(var i=0; i<citys.data.length; i++){
		var oItem = document.createElement("option");
		oItem.value = citys.data[i].value;
		oItem.text = citys.data[i].text;
		refCitys.options.add(oItem);
	}
}*/
