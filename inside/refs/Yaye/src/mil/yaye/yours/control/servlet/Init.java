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
			out.println("<div style='height: 170px;'></div><center><h2>Hibernate��ʹ��ʧ��..ʧ��ԭ����������ݿ��������IP��ַ���ò���ȷ...</h2></center><br /><br />");
		}else if(flag == 7) {
			out.println("<div style='height: 170px;'></div><center><h2>Hibernate��ʹ�����.....</h2></center><br /><br />");
			out.println("<center><h2>������ҳ&gt;&gt;&nbsp;...&gt;&gt;&nbsp;<a href='"+ GlobalNames.SERVER +"'>index.html</a></h2></center>");
			logger.info(" ��ʹ��Hibernate,����sessionFactory,�Ӷ��������ݿ����ӳ�,����10�����ݿ�����.......���.......");
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
