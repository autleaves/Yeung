package mil.yaye.yours.model.impls;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericHibernateDAO;
import mil.yaye.yours.model.ormDAO.WishlistDAO;
import mil.yaye.yours.pojo.Wishlist;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * Wishlist entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mil.yaye.yours.pojo.Wishlist
 * @author MyEclipse Persistence Tools
 */

public class WishlistDAOImpl extends GenericHibernateDAO<Wishlist, Integer> implements WishlistDAO {
	private static final Log log = LogFactory.getLog(WishlistDAOImpl.class);

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IWishlistDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Wishlist instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Wishlist as model where model."
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
	 * @see mil.yaye.yours.model.impls.IWishlistDAO#merge(mil.yaye.yours.pojo.Wishlist)
	 */
	public Wishlist merge(Wishlist detachedInstance) {
		log.debug("merging Wishlist instance");
		try {
			Wishlist result = (Wishlist) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IWishlistDAO#attachDirty(mil.yaye.yours.pojo.Wishlist)
	 */
	public void attachDirty(Wishlist instance) {
		log.debug("attaching dirty Wishlist instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IWishlistDAO#attachClean(mil.yaye.yours.pojo.Wishlist)
	 */
	public void attachClean(Wishlist instance) {
		log.debug("attaching clean Wishlist instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}