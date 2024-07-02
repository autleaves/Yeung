package mil.yaye.yours.control.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import mil.yaye.yours.factory.BeanFactory;
import mil.yaye.yours.service.GuideService;
import mil.yaye.yours.service.InitService;
import mil.yaye.yours.service.OthersService;
import mil.yaye.yours.service.PersonnelService;
import mil.yaye.yours.service.TradeService;

import org.apache.log4j.Logger;


public class SetDAOforServiceListener implements ServletContextListener {
	private static Logger logger = Logger.getLogger(InstanceBeanFactoryListener.class.getName());

	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public void contextInitialized(ServletContextEvent arg0) {
		BeanFactory beanFactory = BeanFactory.getInstance(null);
		((GuideService)beanFactory.getBean("GuideService")).setDAO(beanFactory);
		((InitService)beanFactory.getBean("InitService")).setDAO(beanFactory);
		((OthersService)beanFactory.getBean("OthersService")).setDAO(beanFactory);
		((PersonnelService)beanFactory.getBean("PersonnelService")).setDAO(beanFactory);
		((TradeService)beanFactory.getBean("TradeService")).setDAO(beanFactory);
		
		logger.info("SetDAOforServiceListener.......为每个service设定好自己的DAO...TradeService....Over");
	}

}
