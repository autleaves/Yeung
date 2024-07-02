package mil.yaye.yours.model.impls;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericHibernateDAO;
import mil.yaye.yours.model.ormDAO.ProductDAO;
import mil.yaye.yours.pojo.Product;
import mil.yaye.yours.util.PaginateDTO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Product entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mil.yaye.yours.pojo.Product
 * @author MyEclipse Persistence Tools
 */

public class ProductDAOImpl extends GenericHibernateDAO<Product, Integer> implements ProductDAO {
	private static final Log log = LogFactory.getLog(ProductDAOImpl.class);

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Product instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Product as model where model."
					+ propertyName + "= ? AND model.markfordelete=0 ORDER BY model.productId ASC";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List findByProperty(String propertyName, Object value, PaginateDTO paginateDTO) {
		log.debug("finding Product instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Product as model where model."
				+ propertyName + "= ? AND model.markfordelete=0 ORDER BY model.productId ASC";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			queryObject.setFirstResult(paginateDTO.getIndex());
			queryObject.setMaxResults(paginateDTO.getSize());
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public Object getTotalRecordByProperty(String propertyName, Object value) {
		log.debug("finding Product instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "SELECT COUNT(model.productId) FROM Product AS model WHERE model."
				+ propertyName + "= ? AND model.markfordelete=0 ORDER BY model.productId ASC";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
//	public Integer countByProperty(String propertyName, Object value){
//		Integer total;
//		String queryString = "SELECT COUNT(*) FROM Product AS model WHERE model.";
//	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductDAO#findByProductname(java.lang.Object)
	 */
	public List findByProductname(Object productname) {
		return findByProperty(PRODUCTNAME, productname);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductDAO#findByPartnumber(java.lang.Object)
	 */
	public List findByPartnumber(Object partnumber) {
		return findByProperty(PARTNUMBER, partnumber);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductDAO#findByMarkfordelete(java.lang.Object)
	 */
	public List findByMarkfordelete(Object markfordelete) {
		return findByProperty(MARKFORDELETE, markfordelete);
	}

	public List findByMinimage(Object minimage) {
		return findByProperty(MINIMAGE, minimage);
	}
	
	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductDAO#findByThumbnail(java.lang.Object)
	 */
	public List findByThumbnail(Object thumbnail) {
		return findByProperty(THUMBNAIL, thumbnail);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductDAO#findByFullimage(java.lang.Object)
	 */
	public List findByFullimage(Object fullimage) {
		return findByProperty(FULLIMAGE, fullimage);
	}
//	public List findBy
	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductDAO#findByQuantity(java.lang.Object)
	 */
	public List findByQuantity(Object quantity) {
		return findByProperty(QUANTITY, quantity);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductDAO#findByPrice(java.lang.Object)
	 */
	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductDAO#findByIsbrand(java.lang.Object)
	 */
	public List findByIsbrand(Object isbrand) {
		return findByProperty(ISBRAND, isbrand);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductDAO#findByBrand(java.lang.Object)
	 */
	public List findByBrand(Object brand) {
		return findByProperty(BRAND, brand);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductDAO#findByDescription(java.lang.Object)
	 */
	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductDAO#findByDiscount(java.lang.Object)
	 */
	public List findByDiscount(Object discount) {
		return findByProperty(DISCOUNT, discount);
	}
	/**
	 *
	 * @param categoryId
	 * @return
	 */
	public List findByForeignkey(Object categoryId) {
		return findByProperty(FOREIGNKEY, categoryId);
	}
	public List findByForeignkey(Object categoryId, PaginateDTO paginateDTO) {
		return findByProperty(FOREIGNKEY, categoryId, paginateDTO);
	}
	public Object getTotalRecordByForeignKey(Object categoryId){
		return getTotalRecordByProperty(FOREIGNKEY, categoryId);
	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductDAO#merge(mil.yaye.yours.pojo.Product)
	 */
	public Product merge(Product detachedInstance) {
		log.debug("merging Product instance");
		try {
			Product result = (Product) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductDAO#attachDirty(mil.yaye.yours.pojo.Product)
	 */
	public void attachDirty(Product instance) {
		log.debug("attaching dirty Product instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductDAO#attachClean(mil.yaye.yours.pojo.Product)
	 */
	public void attachClean(Product instance) {
		log.debug("attaching clean Product instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}