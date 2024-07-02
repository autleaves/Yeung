package mil.yaye.yours.engine.service;

import javax.servlet.ServletContext;

import mil.yaye.yours.engine.model._InitEngine_InitJSDataDAO;
import mil.yaye.yours.factory.BeanFactory;

public class _InitEngine_InitJSDataServiceImpl implements _InitEngine_InitJSDataService {

	private BeanFactory beanFactory = null;
	private _InitEngine_InitJSDataDAO dao = null;
	private String id_DAO = null;
	
	public void setDAO(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
		id_DAO = "_InitEngine_InitJSDataDAOImpl";
		dao = (_InitEngine_InitJSDataDAO) beanFactory.getBean(id_DAO);
	}

	public void startup(ServletContext context) {
		
	}
	
}
