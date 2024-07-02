package mil.yaye.yours.engine.service;

import javax.servlet.ServletContext;

import mil.yaye.yours.factory.BeanFactory;

public interface _InitEngine_InitJSDataService {
	
	public void setDAO(BeanFactory beanFactory);
	
	public void startup(ServletContext context);
	
}