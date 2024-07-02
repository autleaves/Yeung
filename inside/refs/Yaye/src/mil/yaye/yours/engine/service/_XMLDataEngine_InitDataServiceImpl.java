package mil.yaye.yours.engine.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mil.yaye.yours.factory.BeanFactory;
import mil.yaye.yours.factory.HibernateSessionFactory;
import mil.yaye.yours.model.impls.ProductDAOImpl;
import mil.yaye.yours.model.ormDAO.ProductDAO;
import mil.yaye.yours.pojo.Product;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class _XMLDataEngine_InitDataServiceImpl implements _XMLDataEngine_InitDataService {
	
/* (non-Javadoc)
 * @see mil.yaye.yours.engine.service._XMLDataEngine_InitDataService#searchProducts()
 */
	private BeanFactory beanFactory = null;
//	private xxxxDAO dao = null;
	private String id_DAO = null;
	
	public void setDAO(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
		id_DAO = "";
//		dao = beanFactory.getBean(id_DAO);
	}
	public void startup() {
		
	}
	//先从数据库中选择1000件商品的所有信息,并把查询到的结果保存到一个xml文件中
	public void searchProducts(){
		ProductDAO dao = new ProductDAOImpl();
		Session session = null;
		Transaction transaction = null;
		List<Product> list = new ArrayList<Product>(); 
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String hql = "FORM Product AS tab ORDER BY tab.jointime";
			Query query = session.createQuery(hql);
			query.setFirstResult(0);
			query.setMaxResults(1000);
			list = query.list();
			transaction.commit();
		} catch (HibernateException e) {
			if(transaction != null){transaction.rollback();}
			e.printStackTrace();
		} finally {
			session.close();
		}
		File file = new File("D:\\MyProject\\XMLData\\products.xml");
		if(file.exists()){file.delete();}
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		file.setReadOnly();
		if(file.exists()){
			file.delete();
		}
		FileOutputStream output;
		try {
			output = new FileOutputStream(file);
			String dtd = "<?xml version=1.0 encoding=utf-8>";
			String root_begin = "<products>";
			String root_end = "</products>";
			output.write(dtd.getBytes());
			output.write(root_begin.getBytes());
			for(Iterator<Product> iter = list.iterator(); iter.hasNext();){
				Product pojo = new Product();
				String element_begin = "<product>";
				String element_end = "</product>";
				String[] attr = new String[18];
				attr[0] = "<productId>" + pojo.getProductId() + "</productId>";
				attr[1] = "<productname>" + pojo.getProductname() + "</productname>";
				attr[2] = "<category>" + pojo.getCategory() + "</category>";
				attr[3] = "<partnumber>" + pojo.getPartnumber() + "</partnumber>";
				attr[4] = "<markfordelete>" + pojo.getMarkfordelete() + "</markfordelete>";
				attr[5] = "<thumbnail>" + pojo.getThumbnail() + "</thumbnail>";
				attr[6] = "<fullimage>" + pojo.getFullimage() + "</fullimage>";
				attr[7] = "<quantity>" + pojo.getQuantity() + "</quantity>";
				attr[8] = "<price>" + pojo.getPrice() + "</price>";
				attr[9] = "<jointime>" + pojo.getJointime() + "</jointime>";
				attr[10] = "<isbrand>" + pojo.getIsbrand() + "</isbrand>";
				attr[11] = "<brand>" + pojo.getBrand() + "</brand>";
				attr[12] = "<discount>" + pojo.getDiscount() + "</discount>";
				attr[13] = "<version>" + pojo.getVersion() + "</version>";
				attr[14] = "<description>" + pojo.getDescription() + "</description>";
				//在这里我遇到了问题:怎样去实现主外键约束关系?
				/*attr[15] = "<wishlists>" + pojo.getWishlists() + "</wishlists>";
				attr[16] = "<orderitemses>" + pojo.getOrderitemses() + "</orderitemses>";
				attr[17] = "<productcomments>" + pojo.getProductcomments() + "</productcomments>";*/
				
				
				output.write(element_begin.getBytes());
				for(int i = 0; i < attr.length; i++){
					output.write(attr[i].getBytes());
				}
				output.write(element_end.getBytes());
			}
			
			output.write(root_end.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.engine.service._XMLDataEngine_InitDataService#SearchProductsByCategory()
	 */
	public void SearchProductsByCategory(){
		//这些常量应该写在一个专门的文件中,比如有一个专门的商品目录文件
		//我在这里有个疑问,就是我以后如果要添加、删除或者修改商品类别,那么我这里也就需要相关的修改了,
		//但是我一旦把我的这个Web应用发布到服务器上之后,那么我修改了我的java文件,就需要重新编译,
		//因为我们在编写和测试阶段Tomcat往往把一个关于自动加载修改后的java文件的参数设为了true,所以我们平时不用去手动重新编译,
		//但一旦发布到服务器上之后,就应该把这个参数设为false,因为我们很少会去再修改java文件了,
		//那么我现在怎么办呢?重新编译好象不用重启Tomcat,但是我还是不想在发布之后还因为这个问题而频繁地去手动重新编译java文件
		int category_num = 20;
		int WENXONG = 3;
		int NENKU = 4;
		int SHIWA = 5;
		int JIQINGXILIE = 10;
		int[] category_id_parent = new int[category_num];
		category_id_parent[0] = WENXONG;
		category_id_parent[1] = NENKU;
		category_id_parent[2] = SHIWA;
		category_id_parent[3] = JIQINGXILIE;
		category_id_parent[4] = 7;
		category_id_parent[5] = 7;
		category_id_parent[6] = 7;
		category_id_parent[7] = 7;
		category_id_parent[8] = 7;
		category_id_parent[9] = 7;
		category_id_parent[10] = 7;
		category_id_parent[11] = 7;
		category_id_parent[12] = 7;
		category_id_parent[13] = 7;
		category_id_parent[14] = 7;
		category_id_parent[15] = 7;
		
		for(int i = 0; i < category_num; i++){
			execSearchProductsByCategory(category_id_parent[i]);
		}
	}
	//从数据库中查询出Category中的信息,也就是目录信息,把信息也存放在一个xml文件中
	/* (non-Javadoc)
	 * @see mil.yaye.yours.engine.service._XMLDataEngine_InitDataService#searchCategoryInfo()
	 */
	public void searchCategoryInfo(){
		
	}
	//从数据库中查询并计算出每一种商品的成交量(现在先不考虑是否已经完全成交,只要是用户发出买这种商品的请求就行)
	//其实我可以只对数据库中查询一次就可以的,因为我可以根据总查询结果在这里进行各种分析,分别得到我想要的结果,
	//但这里我想我用数据库的聚合函数更方便一些,所以偷懒一下了
	/* (non-Javadoc)
	 * @see mil.yaye.yours.engine.service._XMLDataEngine_InitDataService#searchOrderitems()
	 */
	public void searchOrderitems(){
		String hql = "FROM Orderitem";
		String hql2 = "SELECT distanct(tab.product_id) FROM Orderitem AS tab";
//		List<Integer> products = session.createQuery().list();
		String hql3 = "SELECT COUNT(*) FROM Orderitem AS tab WHERE tab.product_id=:pa1";
//		while(products.hasNext()){
//			Query query = session.createQuery(hql3);
//			query.setInteger(pa1, products.next());
//		}
	}
	//查询针对每种商品的评论
	/* (non-Javadoc)
	 * @see mil.yaye.yours.engine.service._XMLDataEngine_InitDataService#searchProductcomment()
	 */
	public void searchProductcomment(){
		
	}
	//为了保证每一种类别都有商品,我又从数据库中针对每种类别都查询出100件,也是把所有信息都保存到一个xml文件中
	//因为第一个方法虽然查询了1000个商品的信息,但不能保证它是对类别进行平均分配的
	private void execSearchProductsByCategory(int category_id_parent){
		
	}

}
