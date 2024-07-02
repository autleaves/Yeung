package mil.yaye.yours.model.impls;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericHibernateDAO;
import mil.yaye.yours.model.ormDAO.OrdersDAO;
import mil.yaye.yours.pojo.Order;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * Order entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mil.yaye.yours.pojo.Order
 * @author MyEclipse Persistence Tools
 */

public class OrdersDAOImpl extends GenericHibernateDAO<Order, Integer> implements OrdersDAO {
	private static final Log log = LogFactory.getLog(OrdersDAOImpl.class);

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrdersDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Order instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Order as model where model."
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
	 * @see mil.yaye.yours.model.impls.IOrdersDAO#findByStatus(java.lang.Object)
	 */
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrdersDAO#findByCreatetime(java.lang.Object)
	 */
	public List findByCreatetime(Object createtime) {
		return findByProperty(CREATETIME, createtime);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrdersDAO#findByShipcharge(java.lang.Object)
	 */
	public List findByShipcharge(Object shipcharge) {
		return findByProperty(SHIPCHARGE, shipcharge);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrdersDAO#findByTotalprice(java.lang.Object)
	 */
	public List findByTotalprice(Object totalprice) {
		return findByProperty(TOTALPRICE, totalprice);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrdersDAO#findByPointprice(java.lang.Object)
	 */
	public List findByPointprice(Object pointprice) {
		return findByProperty(POINTPRICE, pointprice);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrdersDAO#findByAdjustment(java.lang.Object)
	 */
	public List findByAdjustment(Object adjustment) {
		return findByProperty(ADJUSTMENT, adjustment);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrdersDAO#findByDiscountprice(java.lang.Object)
	 */
	public List findByDiscountprice(Object discountprice) {
		return findByProperty(DISCOUNTPRICE, discountprice);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrdersDAO#merge(mil.yaye.yours.pojo.Order)
	 */
	public Order merge(Order detachedInstance) {
		log.debug("merging Order instance");
		try {
			Order result = (Order) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrdersDAO#attachDirty(mil.yaye.yours.pojo.Order)
	 */
	public void attachDirty(Order instance) {
		log.debug("attaching dirty Order instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IOrdersDAO#attachClean(mil.yaye.yours.pojo.Order)
	 */
	public void attachClean(Order instance) {
		log.debug("attaching clean Order instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}