function FillNavkeywords_underwear()
{
	var htmls="<h3><a href='http://localhost:8077/Yaye/underwear.html'>女性内衣</a></h3>";
	for(i=0;i<navkeywords_underwear.data.length;i++)
	{
		var temp=navkeywords_underwear.data[i];
		if(temp.control=='0')
		{
			htmls=htmls+"<a href='"+temp.shref+"'>"+temp.text+"</a>&nbsp;|&nbsp;"
		}else if(temp.control=='1'){
			htmls=htmls+"<a href='"+temp.dhref+"'>"+temp.text+"</a>&nbsp;|&nbsp;"
		}
	}
	document.getElementById('navkeywords_underwear').innerHTML=htmls;
	
}
function FillNavkeywords_dress()
{
	var htmls="<h3><a href='http://localhost:8077/Yaye/dress.html'>服饰</a></h3>";
	for(i=0;i<navkeywords_dress.data.length;i++)
	{
		var temp=navkeywords_dress.data[i];
		if(temp.control=='0')
		{
			htmls=htmls+"<a href='"+temp.shref+"'>"+temp.text+"</a>&nbsp;|&nbsp;"
		}else if(temp.control=='1'){
			htmls=htmls+"<a href='"+temp.dhref+"'>"+temp.text+"</a>&nbsp;|&nbsp;"
		}
	}
	document.getElementById('navkeywords_dress').innerHTML=htmls;
	
}
function FillNavkeywords_cosmetic()
{
	var htmls="<h3><a href='http://localhost:8077/Yaye/cosmetic.html'>化妆品</a></h3>";
	for(i=0;i<navkeywords_cosmetic.data.length;i++)
	{
		var temp=navkeywords_cosmetic.data[i];
		if(temp.control=='0')
		{
			htmls=htmls+"<a href='"+temp.shref+"'>"+temp.text+"</a>&nbsp;|&nbsp;"
		}else if(temp.control=='1'){
			htmls=htmls+"<a href='"+temp.dhref+"'>"+temp.text+"</a>&nbsp;|&nbsp;"
		}
	}
	document.getElementById('navkeywords_cosmetic').innerHTML=htmls;
	
}
function FillNavkeywords_digital()
{
	var htmls="<h3><a href='http://localhost:8077/Yaye/digital.html'>数码</a></h3>";
	for(i=0;i<navkeywords_digital.data.length;i++)
	{
		var temp=navkeywords_digital.data[i];
		if(temp.control=='0')
		{
			htmls=htmls+"<a href='"+temp.shref+"'>"+temp.text+"</a>&nbsp;|&nbsp;"
		}else if(temp.control=='1'){
			htmls=htmls+"<a href='"+temp.dhref+"'>"+temp.text+"</a>&nbsp;|&nbsp;"
		}
	}
	document.getElementById('navkeywords_digital').innerHTML=htmls;
	
}
function FillNavkeywords_flower()
{
	var htmls="<h3><a href='http://localhost:8077/Yaye/flower.html'>鲜花</a></h3>";
	for(i=0;i<navkeywords_flower.data.length;i++)
	{
		var temp=navkeywords_flower.data[i];
		if(temp.control=='0')
		{
			htmls=htmls+"<a href='"+temp.shref+"'>"+temp.text+"</a>&nbsp;|&nbsp;"
		}else if(temp.control=='1'){
			htmls=htmls+"<a href='"+temp.dhref+"'>"+temp.text+"</a>&nbsp;|&nbsp;"
		}
	}
	document.getElementById('navkeywords_flower').innerHTML=htmls;
	
}
function FillNavkeywords_magazine()
{
	var htmls="<h3><a href='http://localhost:8077/Yaye/magazine.html'>时尚杂志</a></h3>";
	for(i=0;i<navkeywords_magazine.data.length;i++)
	{
		var temp=navkeywords_magazine.data[i];
		if(temp.control=='0')
		{
			htmls=htmls+"<a href='"+temp.shref+"'>"+temp.text+"</a>&nbsp;|&nbsp;"
		}else if(temp.control=='1'){
			htmls=htmls+"<a href='"+temp.dhref+"'>"+temp.text+"</a>&nbsp;|&nbsp;"
		}
	}
	document.getElementById('navkeywords_magazine').innerHTML=htmls;
	
}

function FillNew_cont()
{
	var htmls="";
	for(i=0;i<index_new_cont.data.length;i++){
		var temp=index_new_cont.data[i];
		htmls=htmls+"<li><a href='"+temp.href+"'>"+temp.text+"</a></li>";
	}
	document.getElementById('new_cont').innerHTML=htmls;
}
