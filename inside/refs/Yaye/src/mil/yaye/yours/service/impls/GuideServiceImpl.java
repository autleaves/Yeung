package mil.yaye.yours.service.impls;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mil.yaye.yours.factory.BeanFactory;
import mil.yaye.yours.factory.HibernateSessionFactory;
import mil.yaye.yours.model.ormDAO.CategoryDAO;
import mil.yaye.yours.model.ormDAO.ProductDAO;
import mil.yaye.yours.pojo.Product;
import mil.yaye.yours.service.GuideService;
import mil.yaye.yours.util.PaginateDTO;
import mil.yaye.yours.vo.InitVO;
import mil.yaye.yours.vo.ProductVO;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

public class GuideServiceImpl implements GuideService {
	
	private static Logger logger = Logger.getLogger(GuideServiceImpl.class.getName());
	// Fields
	
//	private BeanFactory daoFactory = BeanFactory.getInstance(null);
	private BeanFactory daoFactory = null;
	private CategoryDAO category_dao = null;
	private ProductDAO product_dao = null;
	
	// Constructor
	
	public GuideServiceImpl() {
	}
	/*public GuideServiceImpl(){
		String id_c = "CategoryDAOImpl";
		String id_p = "ProductDAOImpl";
		category_dao = (CategoryDAO) daoFactory.getBean(id_c);
		product_dao = (ProductDAO) daoFactory.getBean(id_p);
	}*/
	
	public void setDAO(BeanFactory daoFactory){
		this.daoFactory = daoFactory;
		String id_c = "CategoryDAO";
		String id_p = "ProductDAO";
		category_dao = (CategoryDAO) this.daoFactory.getBean(id_c);
		product_dao = (ProductDAO) this.daoFactory.getBean(id_p);
	}
	
	//Methods
	
	/*public Integer count(){
		Integer total;
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			product_dao.setSession(session);
			
//			product_dao.findByCriteria(criterion);
			
			tran.commit();
			session.close();
		} catch (HibernateException e) {
			if(tran != null){tran.rollback();}
			e.printStackTrace();
		} finally{
			if(session != null){session.close();}
		}
		return total;
	}*/
	/* (non-Javadoc)
	 * 查看某一条件下的符合该条件的商品
	 * @see mil.yaye.yours.service.impls.GuideService#categoryGuide()
	 */
	public List<ProductVO> categoryGuide(DetachedCriteria criteria, PaginateDTO paginateDTO){
		List<ProductVO> products = new ArrayList<ProductVO>();
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			product_dao.setSession(session);
			
			List<Product> productsTemp = product_dao.findByCriteria(criteria);
			
			BeanUtils.copyProperties(products, productsTemp);
			
			tran.commit();
			session.close();
		} catch (HibernateException e) {
			if(tran != null){tran.rollback();}
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally{
			if(session != null){session.close();}
		}
		return products;
	}
	public int getTotalRecordByForeignKey(ProductDAO product_dao,Integer categoryId){
		return (Integer) product_dao.getTotalRecordByForeignKey(categoryId);
	}
	public Map<String, Object> categoryGuide(Integer categoryId, PaginateDTO paginateDTO){
		Map<String, Object> result = new HashMap<String, Object>(); 
		List<ProductVO> products = new ArrayList<ProductVO>();
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			product_dao.setSession(session);
//			paginateDTO.setSize(paginateDTO.getSize() != 0 ? paginateDTO.getSize() : Constants.PAGINATE_DEFAULT_SIZE);
			int totalRecord = (Integer) product_dao.getTotalRecordByForeignKey(categoryId);	//获取总纪录数和总页数
			List<Product> productsTemp = product_dao.findByForeignkey(categoryId, paginateDTO);	//获取信息
			Product product = null;
			Iterator<Product> iter = productsTemp.iterator();
			while(iter.hasNext()){
				product = iter.next();
				ProductVO productVO = new ProductVO();
				BeanUtils.copyProperties(productVO, product);
				products.add(productVO);
			}
			result.put("totalRecord", totalRecord); 
			result.put("productlist", products);
			
			tran.commit();
			session.close();
		} catch (HibernateException e) {
			if(tran != null){tran.rollback();}
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally{
			if(session != null){session.close();}
		}
		return result;
	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.service.impls.GuideService#categoryBrandsGuide()
	 */
	public void categoryBrandsGuide(){
		
	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.service.impls.GuideService#brandsGuide()
	 */
	public void brandsGuide(){
		
	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.service.impls.GuideService#searchProduct(java.lang.Integer)
	 */
	public void searchProduct(Integer id){
		
	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.service.impls.GuideService#productGuide(java.lang.Integer)
	 */
	public ProductVO productGuide(Integer id){
		ProductVO productVO = new ProductVO();
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			String hqlstr = "SELECT new Product(tb.productId,tb.productname,tb.partnumber,tb.quantity,tb.thumbnail,tb.fullimage,tb.price,tb.discount,tb.description,tb.category) FROM Product AS tb WHERE tb.productId=?";
			Query query = session.createQuery(hqlstr);
			query.setInteger(0, id);
			Product product = null;
//			product = product_dao.findById(id);
			if(query.uniqueResult() != null){
				product = (Product) query.uniqueResult();
			}
			if(!Hibernate.isInitialized(product)){
				Hibernate.initialize(product);
			}
			//如果我在orm映射文件中配置其关联类的加载为lazy=true(也既是hibernate的默认配置),就需要在这里进行手动初使化,
			//防止session关闭后还没有加载
			/*if(!Hibernate.isInitialized(product.getCategory())){
				Hibernate.initialize(product.getCategory());
			}*/
			tran.commit();
			session.close();
			if(product != null){
				BeanUtils.copyProperties(productVO, product);
			} else {
				logger.info("product 为空.................");
				return null;
			}
		} catch (HibernateException e) {
			if(tran != null){tran.rollback();}
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally{
			if(session != null){session.close();}
		}
		logger.info("productGuide......Service........Over!!........");
		return productVO;
	}
	public ProductVO productDetailGuide(Integer id){
		ProductVO productVO = new ProductVO();
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			product_dao.setSession(session);
			
			Product product = product_dao.read(id);
			if(!Hibernate.isInitialized(product)){
				Hibernate.initialize(product);
			}
			//如果我在orm映射文件中配置其关联类的加载为lazy=true(也既是hibernate的默认配置),就需要在这里进行手动初使化,
			//防止session关闭后还没有加载
			/*if(!Hibernate.isInitialized(product.getCategory())){
				Hibernate.initialize(product.getCategory());
			}*/
			tran.commit();
			session.close();
			if(product != null){
				BeanUtils.copyProperties(productVO, product);
			} else {
				logger.info("product 为空.................");
				return null;
			}
		} catch (HibernateException e) {
			if(tran != null){tran.rollback();}
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally{
			if(session != null){session.close();}
		}
		logger.info("productDetailGuide......Service........Over!!........");
		return productVO;
	}
	public Map<Integer, InitVO> getLocations(Integer category_id_parent) {
		Map<Integer, InitVO> locations = new HashMap<Integer, InitVO>();
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			String hqlstr = "SELECT tb.categoryId, tb.categoryname, tb.categoryIdParent, tb.istop FROM Category AS tb WHERE tb.markfordelete=0 AND tb.categoryId=?";
			Query query = session.createQuery(hqlstr);
			Object[] temp = null;
			int flag = 0; // for 
			Integer id = category_id_parent; // for
			int i = 0; // for Map
			while(flag == 0){
				query.setInteger(0, id);
				Iterator<?> iter = query.list().iterator();
				while(iter.hasNext()){
					temp = (Object[]) iter.next();
					InitVO initVO = new InitVO();
					initVO.setKey(temp[0].toString());
					initVO.setValue(temp[1].toString());
					locations.put(i, initVO);
				}
				i++;
				if(temp[2] == null && Integer.parseInt(temp[3].toString()) == 1)
				{ flag = 1; break;}
				//if(flag == 0){id = Integer.parseInt(temp[2].toString());}
				id = Integer.parseInt(temp[2].toString());
			}
			tran.commit();
			session.close();
		} catch (HibernateException e) {
			if(tran != null){tran.rollback();}
			e.printStackTrace();
		} finally {
			if(session != null){session.close();}
		}
		logger.info("getLocations......Service........Over!!........");
		return locations;
	}
	/**
	 * 为了证明我配置的proxool数据源是绝对没有出错,我在这里绕过hibernate进行一次数据库查询.
	 */
	public void proxoolcheck(){
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection connect = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("datasource_oracle9i");
			connect = ds.getConnection();
			String sqlstr = "SELECT * FROM emp";
			ps = connect.prepareStatement(sqlstr);
			rs = ps.executeQuery();
			while(rs.next()){
				logger.info("YYY....Emp.....Ename:...." + rs.getString("ename"));
			}
			rs.close();
			ps.close();
			connect.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){//在这里再进行一次判断,以达到完全关闭链接
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if(ps != null){
						try {
							ps.close();
						} catch (SQLException e) {
							e.printStackTrace();
						} finally {
							if(connect != null){
								try {
									connect.close();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		}
		
	}

	public List<ProductVO> categoryGuide(DetachedCriteria criteria) {
		
		return null;
	}

}
