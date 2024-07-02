package mil.yaye.yours.control.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class SignonFilter implements Filter {
	
//	private String back_page = GlobalNames.LOGIN_PAGE;
	private String error_page_1 = "/logon.html";
	private String error_page_2 = "/logon.jsp";
	protected FilterConfig filterConfig = null;
	private static Logger logger = Logger.getLogger(SignonFilter.class.getName());

	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		boolean isLogin = false;
		if(request.getSession(false) != null && request.getSession(false).getAttribute("IS_LOGON") != null){
			isLogin = (Boolean) request.getSession(false).getAttribute("IS_LOGON");
		}
		/*if(request.getSession(false) != null){
			if(request.getSession(false).getAttribute("IS_LOGON") != null && (((Boolean)request.getSession(false).getAttribute("IS_LOGON")) == true)){
				request.setAttribute("MY_RESPONSE_ERROR", "×对不起,已存在一个这样的帐户登陆!");
				response.sendRedirect(error_page_2);
			}else {
				request.getSession(false).invalidate();
			}
		}*/
		if(isLogin == true){
			logger.info("########这个请求是合法的了.......");
			chain.doFilter(arg0, arg1);
		}else{
			logger.info("###########这个请求被截获了....");
			response.sendRedirect(error_page_1);
		}
	}
	public void setFilterConfig(final FilterConfig filterConfig){
		this.filterConfig = filterConfig;
	}
	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
		error_page_1 = filterConfig.getInitParameter("error_page_1");
		error_page_2 = filterConfig.getInitParameter("error_page_2");
	}

}
