package mil.yaye.yours.control.listener;


import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import mil.yaye.yours.factory.BeanFactory;
import mil.yaye.yours.service.PersonnelService;
import mil.yaye.yours.vo.UserVO;

public class HttpSessionControlListener implements HttpSessionListener,HttpSessionAttributeListener {
	
	private static Logger logger = Logger.getLogger(HttpSessionControlListener.class.getName());

	public void sessionCreated(HttpSessionEvent arg0) {
		
		logger.info("创建了一个会话session,请注意................");
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		//还需要修改数据库中的登陆标识字段
		BeanFactory serviceFactory = BeanFactory.getInstance(null);
		PersonnelService service = (PersonnelService) serviceFactory.getBean("PersonnelService");
		//这个setDAO方法其实调用一次就可以了,以后就不用再调用了,因为"PersonnelService"是在Tomcat启动时初使化的.
		//这里定义的这个变量service实际上就是一个引用,对引用的操作其实也就可以看作是对"PersonnelService"的操作,
		//所以以后再定义一个引用去引用"PersonnelService",实际上它就已经执行过setDAO()方法了,如果你还要再执行一次,
		//它也只不过是对原来的setDAO()方法中的变量进行又一次赋值,等于又重新赋了一次相同的值,这就没有任何意义了,
		//我想我可以把对那些xxxDAO的setDAO()方法在一个地方进行集中调用,以后就再也不用调用setDAO()方法了.
//		service.setDAO(daoFactory);
		logger.info("开始Destory当前Session了.................");
		if(arg0.getSession().getAttribute("USER_BASE_INFO") == null){
			return;
		}
		UserVO userInfo = (UserVO) arg0.getSession().getAttribute("USER_BASE_INFO");
		logger.info("sessionListener....开始执行exit方法........");
//		service.exit(userInfo.getLogonid()); //通过hibernate
		service.exitByJDBC(userInfo.getLogonid());	//3.修改数据库中的sessionid标识字段为'$OFF$'
		logger.info("sessionListener....执行结束exit方法........");
		
		/*//手动清除存放在session的所有变量, 尽快释放内存资源
		Enumeration<?> attrs = arg0.getSession().getAttributeNames();
		while(attrs.hasMoreElements()){
			arg0.getSession().removeAttribute((String)attrs.nextElement());
		}
		for(String attr : attrs){
		}*/
	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		if(arg0.getName().equals("USER_BASE_INFO")){
			logger.info("抓取到USER_BASE_INFO这个属性了........");
		}else if(arg0.getName().equals("SHOPCART")){
			logger.info("抓取到SHOPCART这个属性了........");
		}
		else{
			logger.info("当前创建的不是SHOPCART或者USER_INFO这个属性........");
		}
		
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		logger.info("开始移除当前会话session中的属性:" +arg0.getName());
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
	}

}
