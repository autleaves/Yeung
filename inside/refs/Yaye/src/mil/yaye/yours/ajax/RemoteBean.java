package mil.yaye.yours.ajax;

import java.sql.Connection;

import mil.yaye.yours.factory.BeanFactory;

public class RemoteBean {
	
	private BeanFactory beanFactory = BeanFactory.getInstance(null);
	String id = "AjaxService";
	private AjaxService service = (AjaxService) beanFactory.getBean(id);
	
	//����Ҫ�жϵ�ǰ�ڵ��Ƿ����ӽڵ�
	public boolean hasChildren(String parentId){
		boolean flag = false;
		
		return flag;
	}
	public String[][] showChildren(String parentId){
		service.setDAO(beanFactory);
		NavigationVO childrenVO = service.getChildren();
		return null;
	}
	public boolean validateLogonid(String logonid){
		boolean flag = false;
		
		Connection connection = ProxoolDataSource.getConnection();
		
		
		return flag;
	}
}
