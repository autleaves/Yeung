package mil.yaye.yours.control.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import mil.yaye.yours.common.GlobalNames;

public class EncodingFilter implements Filter {
	private static final long serialVersionUID = 1L;

	protected FilterConfig filterConfig;
	private String targetEncoding = GlobalNames.ENCODING; //Target Encoding
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(targetEncoding);
		chain.doFilter(request, response);
	}
	// Initial
	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
		this.targetEncoding = filterConfig.getInitParameter("encoding");
	}
	public void setFilterConfig(final FilterConfig filterConfig){
		this.filterConfig = filterConfig;
	}
	// Destory Filter
	public void destroy() {
		this.filterConfig  = null;
	}

}
