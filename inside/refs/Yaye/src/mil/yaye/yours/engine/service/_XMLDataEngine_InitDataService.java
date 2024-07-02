package mil.yaye.yours.engine.service;

import mil.yaye.yours.factory.BeanFactory;

public interface _XMLDataEngine_InitDataService {
	
	public void setDAO(BeanFactory beanFactory);
	public void startup();

	/**************************首先声明一下：在这里都是把查询结果保存成xml文件的形式*********************************************/

	//先从数据库中选择1000件商品的所有信息,并把查询到的结果保存到一个xml文件中
	public abstract void searchProducts();

	public abstract void SearchProductsByCategory();

	//从数据库中查询出Category中的信息,也就是目录信息,把信息也存放在一个xml文件中
	public abstract void searchCategoryInfo();

	//从数据库中查询并计算出每一种商品的成交量(现在先不考虑是否已经完全成交,只要是用户发出买这种商品的请求就行)
	//其实我可以只对数据库中查询一次就可以的,因为我可以根据总查询结果在这里进行各种分析,分别得到我想要的结果,
	//但这里我想我用数据库的聚合函数更方便一些,所以偷懒一下了
	public abstract void searchOrderitems();

	//查询针对每种商品的评论
	public abstract void searchProductcomment();

}