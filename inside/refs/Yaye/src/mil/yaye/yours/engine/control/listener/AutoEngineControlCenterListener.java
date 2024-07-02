package mil.yaye.yours.engine.control.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import mil.yaye.yours.engine.control.action.EngineControlCenterTask;



public class AutoEngineControlCenterListener implements ServletContextListener {
	
	private Timer timer = null;

	public void contextDestroyed(ServletContextEvent event) {
		timer.cancel();
		event.getServletContext().log("��ʱ������");
	}

	public void contextInitialized(ServletContextEvent event) {
		timer = new Timer();
		event.getServletContext().log("��ʱ��������");
		timer.schedule(new EngineControlCenterTask(event.getServletContext()), 0, 60*60*24*1000);
		event.getServletContext().log("�Ѿ����������ȱ�");
	}

}
