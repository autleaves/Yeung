package mil.yaye.yours.model.impls;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericHibernateDAO;
import mil.yaye.yours.model.ormDAO.BonuspointDAO;
import mil.yaye.yours.pojo.Bonuspoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Bonuspoint entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mil.yaye.yours.pojo.Bonuspoint
 * @author MyEclipse Persistence Tools
 */

public class BonuspointDAOImpl extends GenericHibernateDAO<Bonuspoint, Integer> implements BonuspointDAO {
	private static final Log log = LogFactory.getLog(BonuspointDAOImpl.class);

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IBonuspointDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List<Bonuspoint> findByProperty(String propertyName, Object value) {
		log.debug("finding Bonuspoint instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Bonuspoint as model where model."
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
	 * @see mil.yaye.yours.model.impls.IBonuspointDAO#findByPointnum(java.lang.Object)
	 */
	public List<Bonuspoint> findByPointnum(Object pointnum) {
		return findByProperty(POINTNUM, pointnum);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IBonuspointDAO#findByCreatetime(java.lang.Object)
	 */
	public List<Bonuspoint> findByCreatetime(Object createtime) {
		return findByProperty(CREATETIME, createtime);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IBonuspointDAO#findByBonuspointtype(java.lang.Object)
	 */
	public List<Bonuspoint> findByBonuspointtype(Object bonuspointtype) {
		return findByProperty(BONUSPOINTTYPE, bonuspointtype);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IBonuspointDAO#findByStatus(java.lang.Object)
	 */
	public List<Bonuspoint> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IBonuspointDAO#merge(mil.yaye.yours.pojo.Bonuspoint)
	 */
	public Bonuspoint merge(Bonuspoint detachedInstance) {
		log.debug("merging Bonuspoint instance");
		try {
			Bonuspoint result = (Bonuspoint) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IBonuspointDAO#attachDirty(mil.yaye.yours.pojo.Bonuspoint)
	 */
	public void attachDirty(Bonuspoint instance) {
		log.debug("attaching dirty Bonuspoint instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IBonuspointDAO#attachClean(mil.yaye.yours.pojo.Bonuspoint)
	 */
	public void attachClean(Bonuspoint instance) {
		log.debug("attaching clean Bonuspoint instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}