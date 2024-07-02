package mil.yaye.yours.ajax;

import mil.yaye.yours.factory.BeanFactory;

public interface AjaxService {
	
	public abstract void setDAO(BeanFactory beanFactory);
	
	public abstract NavigationVO getChildren();
		
}
