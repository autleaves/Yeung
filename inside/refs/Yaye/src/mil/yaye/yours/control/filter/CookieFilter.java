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
	 * //我还可以再进行一次判断,为了防止在没有注意到的地方建立了session,
	 * 这样这里session不为空了,所以我还应该判断如果session不为空,那么它里面是否有一个isLogon=true的属性
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		Cookie[] cookies = request.getCookies();
		HttpSession session = request.getSession(false);
		boolean flag = false;
		logger.info("开始进行CookieFilter过滤.......");
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
			logger.info("这个请求被CookieFilter进行了过滤,经判断为合法请求.....予以继续执行....");
		} else {
			response.sendRedirect(error_page);
			logger.info("这个请求被CookieFilter进行了过滤,并且为非法请求");
		}
	}

	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
		error_page = filterConfig.getInitParameter("error_page");
	}

}
