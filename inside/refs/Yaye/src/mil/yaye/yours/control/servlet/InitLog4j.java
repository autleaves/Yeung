package mil.yaye.yours.control.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class InitLog4j extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		String configFile =this.getServletContext().getRealPath("/") + this.getServletConfig().getInitParameter("configFile");
		BasicConfigurator.configure();
		PropertyConfigurator.configure(configFile);
		System.out.println("%%%%%%%%%%Log4j start working!%%%%%%%%%%%");
		
		//������ȥ�ж�configFile�Ƿ�Ϊ����һ��������뷨,
		//��ΪֻҪ���web.xml���������������,��ô���configFile�ͺ㲻Ϊnull,���������·���Ƿ���ȷ
		/*if(configFile != null){
			BasicConfigurator.configure();
			PropertyConfigurator.configure(configFile);
			System.out.println(configFile);
			System.out.println("%%%%%%%%%%Log4j start working!%%%%%%%%%%%");
		}else{
			System.out.println("%%%%%%%%%%The ConfigFile of Log4j is not exist!%%%%%%%%%%%");
		}*/
	}

}
