package mil.yaye.yours.engine.service;

import mil.yaye.yours.factory.BeanFactory;

public interface _XMLDataEngine_InitDataService {
	
	public void setDAO(BeanFactory beanFactory);
	public void startup();

	/**************************��������һ�£������ﶼ�ǰѲ�ѯ��������xml�ļ�����ʽ*********************************************/

	//�ȴ����ݿ���ѡ��1000����Ʒ��������Ϣ,���Ѳ�ѯ���Ľ�����浽һ��xml�ļ���
	public abstract void searchProducts();

	public abstract void SearchProductsByCategory();

	//�����ݿ��в�ѯ��Category�е���Ϣ,Ҳ����Ŀ¼��Ϣ,����ϢҲ�����һ��xml�ļ���
	public abstract void searchCategoryInfo();

	//�����ݿ��в�ѯ�������ÿһ����Ʒ�ĳɽ���(�����Ȳ������Ƿ��Ѿ���ȫ�ɽ�,ֻҪ���û�������������Ʒ���������)
	//��ʵ�ҿ���ֻ�����ݿ��в�ѯһ�ξͿ��Ե�,��Ϊ�ҿ��Ը����ܲ�ѯ�����������и��ַ���,�ֱ�õ�����Ҫ�Ľ��,
	//�����������������ݿ�ľۺϺ���������һЩ,����͵��һ����
	public abstract void searchOrderitems();

	//��ѯ���ÿ����Ʒ������
	public abstract void searchProductcomment();

}