package mil.yaye.yours.engine.control.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class _JspToHtmlEngine_InitJspToHtmlFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		WrapperResponse wrapperResponse = new WrapperResponse(response);
		chain.doFilter(request, wrapperResponse);
		String html = wrapperResponse.getContent();
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	public static String getJspOutput(String jsppath, HttpServletRequest request, HttpServletResponse response){
		WrapperResponse wrapperResponse = new WrapperResponse(response);
		try {
			request.getRequestDispatcher(jsppath).include(request, wrapperResponse);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wrapperResponse.getContent();
	}
	
}
