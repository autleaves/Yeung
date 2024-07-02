package mil.yaye.yours.model.impls;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericHibernateDAO;
import mil.yaye.yours.model.ormDAO.OrderitemsDAO;
import mil.yaye.yours.pojo.Orderitem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orderitem entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mil.yaye.yours.pojo.Orderitem
 * @author MyEclipse Persistence Tools
 */

public class OrderitemsDAOImpl extends GenericHibernateDAO<Orderitem, Integer> implements OrderitemsDAO {
	private static final Log log = LogFactory.getLog(OrderitemsDAOImpl.class);

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrderitemsDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Orderitem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Orderitem as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrderitemsDAO#findByCreatetime(java.lang.Object)
	 */
	public List findByCreatetime(Object createtime) {
		return findByProperty(CREATETIME, createtime);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrderitemsDAO#findByQuantity(java.lang.Object)
	 */
	public List findByQuantity(Object quantity) {
		return findByProperty(QUANTITY, quantity);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrderitemsDAO#findByPrice(java.lang.Object)
	 */
	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrderitemsDAO#findByDiscountprice(java.lang.Object)
	 */
	public List findByDiscountprice(Object discountprice) {
		return findByProperty(DISCOUNTPRICE, discountprice);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrderitemsDAO#merge(mil.yaye.yours.pojo.Orderitem)
	 */
	public Orderitem merge(Orderitem detachedInstance) {
		log.debug("merging Orderitem instance");
		try {
			Orderitem result = (Orderitem) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrderitemsDAO#attachDirty(mil.yaye.yours.pojo.Orderitem)
	 */
	public void attachDirty(Orderitem instance) {
		log.debug("attaching dirty Orderitem instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrderitemsDAO#attachClean(mil.yaye.yours.pojo.Orderitem)
	 */
	public void attachClean(Orderitem instance) {
		log.debug("attaching clean Orderitem instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}