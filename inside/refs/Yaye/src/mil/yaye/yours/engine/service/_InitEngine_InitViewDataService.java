package mil.yaye.yours.engine.service;

import java.util.List;

import javax.servlet.ServletContext;

import mil.yaye.yours.factory.BeanFactory;
import mil.yaye.yours.vo.InitVO;

public interface _InitEngine_InitViewDataService {
	
	public void setDAO(BeanFactory beanFactory);
	public void startup(ServletContext context);
	
	/***开始***随机获取totalNum个new+hot+new_hot个产品的ID及thumbnail*****把这些图片放置到首页的一个表格中*********************/
	/**
	 * 此方法用来为新品区提供信息,信息包括：productId(产品的ID)和thumbnail(小图路径)
	 * 在视图层的时候,
	 * @return
	 */
	public abstract void initIndex_New_Hot_Block();

	public abstract List<InitVO> searchNewProduct();

	public abstract List<InitVO> searchHotProduct();

	/**开始*****读取并编排导航********************************************************/
	public abstract List<?> initNav();

}