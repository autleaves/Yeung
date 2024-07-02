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
	//�ȴ����ݿ���ѡ��1000����Ʒ��������Ϣ,���Ѳ�ѯ���Ľ�����浽һ��xml�ļ���
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
				//������������������:����ȥʵ�������Լ����ϵ?
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
		//��Щ����Ӧ��д��һ��ר�ŵ��ļ���,������һ��ר�ŵ���ƷĿ¼�ļ�
		//���������и�����,�������Ժ����Ҫ��ӡ�ɾ�������޸���Ʒ���,��ô������Ҳ����Ҫ��ص��޸���,
		//������һ�����ҵ����WebӦ�÷�������������֮��,��ô���޸����ҵ�java�ļ�,����Ҫ���±���,
		//��Ϊ�����ڱ�д�Ͳ��Խ׶�Tomcat������һ�������Զ������޸ĺ��java�ļ��Ĳ�����Ϊ��true,��������ƽʱ����ȥ�ֶ����±���,
		//��һ����������������֮��,��Ӧ�ð����������Ϊfalse,��Ϊ���Ǻ��ٻ�ȥ���޸�java�ļ���,
		//��ô��������ô����?���±������������Tomcat,�����һ��ǲ����ڷ���֮����Ϊ��������Ƶ����ȥ�ֶ����±���java�ļ�
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
	//�����ݿ��в�ѯ��Category�е���Ϣ,Ҳ����Ŀ¼��Ϣ,����ϢҲ�����һ��xml�ļ���
	/* (non-Javadoc)
	 * @see mil.yaye.yours.engine.service._XMLDataEngine_InitDataService#searchCategoryInfo()
	 */
	public void searchCategoryInfo(){
		
	}
	//�����ݿ��в�ѯ�������ÿһ����Ʒ�ĳɽ���(�����Ȳ������Ƿ��Ѿ���ȫ�ɽ�,ֻҪ���û�������������Ʒ���������)
	//��ʵ�ҿ���ֻ�����ݿ��в�ѯһ�ξͿ��Ե�,��Ϊ�ҿ��Ը����ܲ�ѯ�����������и��ַ���,�ֱ�õ�����Ҫ�Ľ��,
	//�����������������ݿ�ľۺϺ���������һЩ,����͵��һ����
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
	//��ѯ���ÿ����Ʒ������
	/* (non-Javadoc)
	 * @see mil.yaye.yours.engine.service._XMLDataEngine_InitDataService#searchProductcomment()
	 */
	public void searchProductcomment(){
		
	}
	//Ϊ�˱�֤ÿһ���������Ʒ,���ִ����ݿ������ÿ����𶼲�ѯ��100��,Ҳ�ǰ�������Ϣ�����浽һ��xml�ļ���
	//��Ϊ��һ��������Ȼ��ѯ��1000����Ʒ����Ϣ,�����ܱ�֤���Ƕ�������ƽ�������
	private void execSearchProductsByCategory(int category_id_parent){
		
	}

}
