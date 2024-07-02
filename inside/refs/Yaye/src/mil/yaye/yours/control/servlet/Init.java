package mil.yaye.yours.control.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import mil.yaye.yours.common.GlobalNames;
import mil.yaye.yours.factory.BeanFactory;
import mil.yaye.yours.service.InitService;

public class Init extends HttpServlet {

	private BeanFactory beanFactory = BeanFactory.getInstance(null);
	private Logger logger = Logger.getLogger(getClass().getName());
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); 
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		InitService service = (InitService) beanFactory.getBean("InitService");
//		service.setDAO(beanFactory);
		int flag = service.initDataSource();
		PrintWriter out = response.getWriter();
		if(flag == -1){
			out.println("<div style='height: 170px;'></div><center><h2>Hibernate初使化失败..失败原因可能是数据库服务器的IP地址配置不正确...</h2></center><br /><br />");
		}else if(flag == 7) {
			out.println("<div style='height: 170px;'></div><center><h2>Hibernate初使化完毕.....</h2></center><br /><br />");
			out.println("<center><h2>到达首页&gt;&gt;&nbsp;...&gt;&gt;&nbsp;<a href='"+ GlobalNames.SERVER +"'>index.html</a></h2></center>");
			logger.info(" 初使化Hibernate,建立sessionFactory,从而构建数据库连接池,建立10个数据库连接.......完毕.......");
		}
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
	}

}
