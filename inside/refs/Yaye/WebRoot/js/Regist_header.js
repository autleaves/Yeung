<!-- Hide
function header(logo, iflogin)
{
	document.write("<table width=750 border=0 cellpadding=0 cellspacing=0>"
	+"<tr><td width=25></td><td width=205><img src='"+logo+"'></td>"
	+"<td valign=bottom align=right>"
		+"<table height=24 border=0 cellpadding=0 cellspacing=0>"
		+"<tr><td width=2 height=2><img src=/images/banner_c.gif width=2 height=2></td>"
		+"<td background=/images/banner_t.gif></td>"
		+"<td width=2 height=2><img src=/images/banner_c.gif width=2 height=2></td></tr>"
		+"<tr height=22><td width=2 background=/images/banner_l.gif></td>"
		+"<td>&nbsp;&nbsp;<a href=/>登录</a>&nbsp;|"
		+"&nbsp;<a href='/cgi/register/reg_sso.php'>注册</a>&nbsp;|"
		+"&nbsp;<a href='/getpass.html'>找回密码</a>&nbsp;|"
		+"&nbsp;<a href='/help.html'>使用帮助</a>&nbsp;|"
		+"&nbsp;<a href='http://www.sina.com.cn'>新浪首页</a>&nbsp;");
		if(iflogin == "y")
		{	
			document.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='/cgi/login/logout.php'>安全退出</a>&nbsp;&nbsp;");
		}
		document.write("</td><td width=2 background=/images/banner_r.gif></td></tr>"
		+"</table>"
	+"</td><td align=left width=20></td>"
	+"</tr></table>"
	+"<table width=750 height=1 border=0 cellpadding=0 cellspacing=0>"
	+"<tr><td class=bg02></td></tr>"
	+"</table>"
	+"<table width=750 height=9 border=0 cellpadding=0 cellspacing=0>"
	+"<tr><td width=1 class=bg02></td>"
	+"<td width=748 class=bg01></td>"
	+"<td width=1 class=bg02></td></tr>"
	+"</table>");
}
//End -->