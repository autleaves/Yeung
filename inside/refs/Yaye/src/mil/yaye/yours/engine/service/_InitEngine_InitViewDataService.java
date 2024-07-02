package mil.yaye.yours.engine.service;

import java.util.List;

import javax.servlet.ServletContext;

import mil.yaye.yours.factory.BeanFactory;
import mil.yaye.yours.vo.InitVO;

public interface _InitEngine_InitViewDataService {
	
	public void setDAO(BeanFactory beanFactory);
	public void startup(ServletContext context);
	
	/***��ʼ***�����ȡtotalNum��new+hot+new_hot����Ʒ��ID��thumbnail*****����ЩͼƬ���õ���ҳ��һ�������*********************/
	/**
	 * �˷�������Ϊ��Ʒ���ṩ��Ϣ,��Ϣ������productId(��Ʒ��ID)��thumbnail(Сͼ·��)
	 * ����ͼ���ʱ��,
	 * @return
	 */
	public abstract void initIndex_New_Hot_Block();

	public abstract List<InitVO> searchNewProduct();

	public abstract List<InitVO> searchHotProduct();

	/**��ʼ*****��ȡ�����ŵ���********************************************************/
	public abstract List<?> initNav();

}