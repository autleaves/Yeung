package mil.yaye.yours.ajax;

import mil.yaye.yours.factory.BeanFactory;

public class AjaxServiceImpl implements AjaxService {
	
	private BeanFactory beanFactory = null;
	private AjaxDAO dao = null;
	private String id = null;

	public void setDAO(BeanFactory beanFactory) {
		id = "ajaxDAO";
		this.beanFactory = beanFactory;
		this.dao = (AjaxDAO) this.beanFactory.getBean(id);
	}

	public NavigationVO getChildren() {
		return null;
	}

}
