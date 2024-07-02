package mil.yaye.yours.engine.control.action;

import javax.servlet.ServletContext;

import mil.yaye.yours.engine.service.EngineService;
import mil.yaye.yours.factory.BeanFactory;

/**
 * ����ֻ��һ����ͨ��Java��,��û�м̳�Action,������HttpServlet.
 * @author Yaye
 *
 */
public final class EngineControlCenter {
	
	private static EngineControlCenter engineControlCenter = null;
	private ServletContext context = null;
	private BeanFactory beanFactory = null;
	
	private EngineControlCenter(ServletContext context){
		this.context = context;
		beanFactory = BeanFactory.getInstance(null);
		init();
	}
	public static void startup(ServletContext context){
		if(engineControlCenter == null){
			engineControlCenter = new EngineControlCenter(context);
		}
	}
	private void init(){
		EngineService service = (EngineService) beanFactory.getBean("EngineService");
		service.startup(context);
	}
	
	private void destroy(){
		
	}
}
