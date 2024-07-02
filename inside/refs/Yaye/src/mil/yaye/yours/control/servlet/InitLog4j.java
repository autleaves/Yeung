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
		
		//在这里去判断configFile是否为空是一个错误的想法,
		//因为只要你的web.xml中配置了这个参数,那么这个configFile就恒不为null,而不管你的路径是否正确
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
