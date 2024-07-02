package mil.yaye.yours.util;

import java.io.IOException;

public class CharacterChange {

	public CharacterChange() {
		super();
	}
	
	/*
	 * ���ַ����еĻ��з�\n ת��Ϊhtml���з�<br>
	 * �Լ��ո��" "ת��Ϊhtml�ո��"&nbsp;"
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
	 * ���ַ����еĻ��з�\n ת��Ϊhtml���з�<br>
	 * ���趨ÿ����ʾ���ַ�����digit��
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
	 * ���ַ����еĻ��з�\n ת��Ϊhtml���з�<p>
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
	 * ��html�е��ַ���ת��ΪGB2312��ʽ
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
