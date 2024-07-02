package mil.yaye.yours.model.impls;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericHibernateDAO;
import mil.yaye.yours.model.ormDAO.ProductcommentDAO;
import mil.yaye.yours.pojo.Productcomment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Productcomment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mil.yaye.yours.pojo.Productcomment
 * @author MyEclipse Persistence Tools
 */

public class ProductcommentDAOImpl extends GenericHibernateDAO<Productcomment, Integer> implements ProductcommentDAO {
	private static final Log log = LogFactory.getLog(ProductcommentDAOImpl.class);

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductcommentDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Productcomment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Productcomment as model where model."
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
	 * @see mil.yaye.yours.model.impls.IProductcommentDAO#findByPoint(java.lang.Object)
	 */
	public List findByPoint(Object point) {
		return findByProperty(POINT, point);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductcommentDAO#findByTitle(java.lang.Object)
	 */
	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductcommentDAO#findByContent(java.lang.Object)
	 */
	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductcommentDAO#findByCreatetime(java.lang.Object)
	 */
	public List findByCreatetime(Object createtime) {
		return findByProperty(CREATETIME, createtime);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductcommentDAO#merge(mil.yaye.yours.pojo.Productcomment)
	 */
	public Productcomment merge(Productcomment detachedInstance) {
		log.debug("merging Productcomment instance");
		try {
			Productcomment result = (Productcomment) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductcommentDAO#attachDirty(mil.yaye.yours.pojo.Productcomment)
	 */
	public void attachDirty(Productcomment instance) {
		log.debug("attaching dirty Productcomment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IProductcommentDAO#attachClean(mil.yaye.yours.pojo.Productcomment)
	 */
	public void attachClean(Productcomment instance) {
		log.debug("attaching clean Productcomment instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}