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
				context.log("指定任务执行结束");
			}
		}else{
			context.log("上一次任务执行还未结束");
		}
	}
	//进入中央控制器中去执行各种任务
	private void tasks(){
		EngineControlCenter.startup(context);
	}
	
	
	/*//请求一些GuideAction中的几个action,以及一个Servlet是_ApplicationDataEngine_InitApplication
	//请求GuideAction中的action是为了让那些导航jsp生成html文件.
	//请求那个Servlet是为了重新放入application中的数据,供index页面使用,以来更新index中的内容.同时生成html文件.
	private void task_updateData() {
		
	}
	private void task_updateHtmls(){
		
	}*/
}
