package mil.yaye.yours.engine.control.action;

import java.util.Calendar;
import java.util.TimerTask;

import javax.servlet.ServletContext;

public class EngineControlCenterTask extends TimerTask{

	private static final int C_SCHEDULE_HOUR = 0;
	private ServletContext context = null;
	private static boolean isRunning = false;
	
	public EngineControlCenterTask(ServletContext context){
		this.context = context;
	}
	@Override
	public void run() {
		Calendar cal = Calendar.getInstance();
		if(!isRunning){
			if(C_SCHEDULE_HOUR == cal.get(Calendar.HOUR_OF_DAY)){
				isRunning = true;
				
				tasks();
				
				isRunning = false;
				context.log("ָ������ִ�н���");
			}
		}else{
			context.log("��һ������ִ�л�δ����");
		}
	}
	//���������������ȥִ�и�������
	private void tasks(){
		EngineControlCenter.startup(context);
	}
	
	
	/*//����һЩGuideAction�еļ���action,�Լ�һ��Servlet��_ApplicationDataEngine_InitApplication
	//����GuideAction�е�action��Ϊ������Щ����jsp����html�ļ�.
	//�����Ǹ�Servlet��Ϊ�����·���application�е�����,��indexҳ��ʹ��,��������index�е�����.ͬʱ����html�ļ�.
	private void task_updateData() {
		
	}
	private void task_updateHtmls(){
		
	}*/
}
