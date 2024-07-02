package mil.yaye.yours.control.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import mil.yaye.yours.factory.BeanFactory;

public class InstanceBeanFactoryListener implements ServletContextListener {
	private static Logger logger = Logger.getLogger(InstanceBeanFactoryListener.class.getName());

	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public void contextInitialized(ServletContextEvent arg0) {
		String path = arg0.getServletContext().getRealPath("/WEB-INF/classes/mil/yaye/yours/conf");
		BeanFactory.getInstance(path);
		logger.info("InstanceBeanFactoryListener.......?BeanFactory........Over!!!.......");
	}

}
