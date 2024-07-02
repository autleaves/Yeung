package mil.yaye.yours.engine.service;

import javax.servlet.ServletContext;

public interface EngineService {

	public abstract void startup(ServletContext context);

	public abstract void destroy();
	
	/**手动启动引擎**/
	public abstract void manual(ServletContext context);
	
	/**以上方式启动引擎时都是进行全部的更新,但我想如果我的网站运行了多年,那么似乎就不在必要对一些陈旧的页面进行
	 * 进行更新,还比如,如果我的网站比较大,那么我就应该考虑可以进行针对某一段时间的页面进行更新.
	 * 还可以进行针对某一个类别的页面进行更新,这样才更好
	 * **/
}