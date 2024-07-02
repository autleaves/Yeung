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
		
		logger.info("������һ���Ựsession,��ע��................");
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		//����Ҫ�޸����ݿ��еĵ�½��ʶ�ֶ�
		BeanFactory serviceFactory = BeanFactory.getInstance(null);
		PersonnelService service = (PersonnelService) serviceFactory.getBean("PersonnelService");
		//���setDAO������ʵ����һ�ξͿ�����,�Ժ�Ͳ����ٵ�����,��Ϊ"PersonnelService"����Tomcat����ʱ��ʹ����.
		//���ﶨ����������serviceʵ���Ͼ���һ������,�����õĲ�����ʵҲ�Ϳ��Կ����Ƕ�"PersonnelService"�Ĳ���,
		//�����Ժ��ٶ���һ������ȥ����"PersonnelService",ʵ���������Ѿ�ִ�й�setDAO()������,����㻹Ҫ��ִ��һ��,
		//��Ҳֻ�����Ƕ�ԭ����setDAO()�����еı���������һ�θ�ֵ,���������¸���һ����ͬ��ֵ,���û���κ�������,
		//�����ҿ��԰Ѷ���ЩxxxDAO��setDAO()������һ���ط����м��е���,�Ժ����Ҳ���õ���setDAO()������.
//		service.setDAO(daoFactory);
		logger.info("��ʼDestory��ǰSession��.................");
		if(arg0.getSession().getAttribute("USER_BASE_INFO") == null){
			return;
		}
		UserVO userInfo = (UserVO) arg0.getSession().getAttribute("USER_BASE_INFO");
		logger.info("sessionListener....��ʼִ��exit����........");
//		service.exit(userInfo.getLogonid()); //ͨ��hibernate
		service.exitByJDBC(userInfo.getLogonid());	//3.�޸����ݿ��е�sessionid��ʶ�ֶ�Ϊ'$OFF$'
		logger.info("sessionListener....ִ�н���exit����........");
		
		/*//�ֶ���������session�����б���, �����ͷ��ڴ���Դ
		Enumeration<?> attrs = arg0.getSession().getAttributeNames();
		while(attrs.hasMoreElements()){
			arg0.getSession().removeAttribute((String)attrs.nextElement());
		}
		for(String attr : attrs){
		}*/
	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		if(arg0.getName().equals("USER_BASE_INFO")){
			logger.info("ץȡ��USER_BASE_INFO���������........");
		}else if(arg0.getName().equals("SHOPCART")){
			logger.info("ץȡ��SHOPCART���������........");
		}
		else{
			logger.info("��ǰ�����Ĳ���SHOPCART����USER_INFO�������........");
		}
		
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		logger.info("��ʼ�Ƴ���ǰ�Ựsession�е�����:" +arg0.getName());
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
	}

}
