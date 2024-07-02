package mil.yaye.yours.model.impls;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericHibernateDAO;
import mil.yaye.yours.model.ormDAO.UsersDAO;
import mil.yaye.yours.pojo.User;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see mil.yaye.yours.pojo.User
 * @author MyEclipse Persistence Tools
 */

public class UsersDAOImpl extends GenericHibernateDAO<User, Integer> implements UsersDAO {
	private static final Log log = LogFactory.getLog(UsersDAOImpl.class);

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IUsersDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public User findByProperty(String constructor, String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "SELECT new User"+ constructor +" FROM User as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return (User) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IUsersDAO#findByLogonid(java.lang.Object)
	 */
	public List findByLogonid(Object logonid) {
		return findByProperty(LOGONID, logonid);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IUsersDAO#findByUsername(java.lang.Object)
	 */
	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}
	
	public User findByUsername(Object constructor,Object username) {
		return findByProperty((String)constructor, USERNAME, username);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IUsersDAO#findByPassword(java.lang.Object)
	 */
	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IUsersDAO#findBySessionid(java.lang.Object)
	 */
	public List findBySessionid(Object sessionid) {
		return findByProperty(SESSIONID, sessionid);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IUsersDAO#findByStatus(java.lang.Object)
	 */
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IUsersDAO#findByRegistration(java.lang.Object)
	 */
	public List findByRegistration(Object registration) {
		return findByProperty(REGISTRATION, registration);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IUsersDAO#findByBonuspoint(java.lang.Object)
	 */
	public List findByBonuspoint(Object bonuspoint) {
		return findByProperty(BONUSPOINT, bonuspoint);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IUsersDAO#findByMemberclass(java.lang.Object)
	 */
	public List findByMemberclass(Object memberclass) {
		return findByProperty(MEMBERCLASS, memberclass);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IUsersDAO#merge(mil.yaye.yours.pojo.User)
	 */
	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IUsersDAO#attachDirty(mil.yaye.yours.pojo.User)
	 */
	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IUsersDAO#attachClean(mil.yaye.yours.pojo.User)
	 */
	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}