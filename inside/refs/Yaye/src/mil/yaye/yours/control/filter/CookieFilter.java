package mil.yaye.yours.control.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class CookieFilter implements Filter {

//	private String back_page = GlobalNames.LOGIN_PAGE;
	private String error_page = "";
	protected FilterConfig filterConfig = null;
	private static Logger logger = Logger.getLogger(CookieFilter.class.getName());

	public void destroy() {
		this.filterConfig = null;
	}
	/**
	 * //�һ������ٽ���һ���ж�,Ϊ�˷�ֹ��û��ע�⵽�ĵط�������session,
	 * ��������session��Ϊ����,�����һ�Ӧ���ж����session��Ϊ��,��ô�������Ƿ���һ��isLogon=true������
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		Cookie[] cookies = request.getCookies();
		HttpSession session = request.getSession(false);
		boolean flag = false;
		logger.info("��ʼ����CookieFilter����.......");
		if(cookies != null && session != null){
			for(int i = 0; i < cookies.length; i++){
				if(cookies[i].getName().equals("JSESSIONID")){
					if(cookies[i].getValue().equals(session.getId())){
						flag = true;
					}
				}
			}
		}
		if(flag == true){
			chain.doFilter(arg0, arg1);
			logger.info("�������CookieFilter�����˹���,���ж�Ϊ�Ϸ�����.....���Լ���ִ��....");
		} else {
			response.sendRedirect(error_page);
			logger.info("�������CookieFilter�����˹���,����Ϊ�Ƿ�����");
		}
	}

	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
		error_page = filterConfig.getInitParameter("error_page");
	}

}
