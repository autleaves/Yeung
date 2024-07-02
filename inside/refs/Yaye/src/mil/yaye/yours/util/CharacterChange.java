package mil.yaye.yours.util;

import java.io.IOException;

public class CharacterChange {

	public CharacterChange() {
		super();
	}
	
	/*
	 * 将字符串中的换行符\n 转换为html换行符<br>
	 * 以及空格符" "转换为html空格符"&nbsp;"
	 */
	public static String toBR(String s)
	{
		String str = "";
		
		for(int j=0; j<s.length(); j++)
		{
			if(s.substring(j,j+1).equals("\n"))
			{
				str=str+"</br>";
			}
			else if(s.substring(j,j+1).equals(" "))
			{
				str=str+"&nbsp;";
			}
			else
			{
				str=str+s.substring(j,j+1);
			}
		}
		return str;
	}

	/*
	 * 将字符串中的换行符\n 转换为html换行符<br>
	 * 并设定每行显示的字符数（digit）
	 */
	public static String toBR(String s, int digit)
	{
		String str = "";
		int i = 0;
		for(int j=0; j<s.length(); j++)
		{
			i++;
			if(s.substring(j,j+1).equals("\n"))
			{
				str=str+"</br>";
				i=0;
			}
			else if(s.substring(j,j+1).equals(" "))
			{
				str=str+"&nbsp;";
			}
			else
			{
				str=str+s.substring(j,j+1);
			}
			if(i==digit)
			{
				str=str+"</br>";
				i=0;
			}
		}
		return str;
	}
	

	/*
	 * 将字符串中的换行符\n 转换为html换行符<p>
	 */
	public static String toP(String s)
	{
		String str = "";
		
		for(int j=0; j<s.length(); j++)
		{
			if(s.substring(j,j+1).equals("\n"))
			{
				str=str+"</p>";
			}
			else
			{
				str=str+s.substring(j,j+1);
			}
		}
		return str;
	}
	
	/*
	 * 将html中的字符串转换为GB2312格式
	 */
	public static String toGB2312(String str) throws IOException
	{
		if(str != null)
		{
			str=new String(str.getBytes("ISO-8859-1"),"GB2312");
		}
		
		return str;
	}

}
