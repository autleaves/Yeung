package mil.yaye.yours.engine.service;


import javax.servlet.ServletContext;

import mil.yaye.yours.factory.BeanFactory;


public class EngineServiceImpl implements EngineService {
	
	private BeanFactory beanFactory = null;
	
	private _InitEngine_InitJSDataService service1 = null;
	private _InitEngine_InitViewDataService service2 = null;
	private _XMLDataEngine_InitDataService service3 = null;
	
	public EngineServiceImpl(){
		this.beanFactory = BeanFactory.getInstance(null);
	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.engine.service.IEngineService#init()
	 */
	public void startup(ServletContext context){
		service1 = (_InitEngine_InitJSDataService) beanFactory.getBean("");
		service2 = (_InitEngine_InitViewDataService) beanFactory.getBean("");
		service3 = (_XMLDataEngine_InitDataService) beanFactory.getBean("");
		service1.startup(context);
		service2.startup(context);
		service3.startup();
	}
	public void destroy(){
		
	}
	public void manual(ServletContext context) {
		startup(context);
	}
}
