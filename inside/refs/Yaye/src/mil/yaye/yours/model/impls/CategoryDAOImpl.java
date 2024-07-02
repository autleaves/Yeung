package mil.yaye.yours.model.impls;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericHibernateDAO;
import mil.yaye.yours.model.ormDAO.CategoryDAO;
import mil.yaye.yours.pojo.Category;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Category entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mil.yaye.yours.pojo.Category
 * @author MyEclipse Persistence Tools
 */

public class CategoryDAOImpl extends GenericHibernateDAO<Category, Integer> implements CategoryDAO {
	private static final Log log = LogFactory.getLog(CategoryDAOImpl.class);

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.ICategoryDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Category instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Category as model where model."
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
	 * @see mil.yaye.yours.model.impls.ICategoryDAO#findByCategoryname(java.lang.Object)
	 */
	public List findByCategoryname(Object categoryname) {
		return findByProperty(CATEGORYNAME, categoryname);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.ICategoryDAO#findByMarkfordelete(java.lang.Object)
	 */
	public List findByMarkfordelete(Object markfordelete) {
		return findByProperty(MARKFORDELETE, markfordelete);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.ICategoryDAO#findByLastupdate(java.lang.Object)
	 */
	public List findByLastupdate(Object lastupdate) {
		return findByProperty(LASTUPDATE, lastupdate);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.ICategoryDAO#findByDescription(java.lang.Object)
	 */
	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.ICategoryDAO#findByThumbnail(java.lang.Object)
	 */
	public List findByThumbnail(Object thumbnail) {
		return findByProperty(THUMBNAIL, thumbnail);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.ICategoryDAO#findByFullimage(java.lang.Object)
	 */
	public List findByFullimage(Object fullimage) {
		return findByProperty(FULLIMAGE, fullimage);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.ICategoryDAO#findByIstop(java.lang.Object)
	 */
	public List findByIstop(Object istop) {
		return findByProperty(ISTOP, istop);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.ICategoryDAO#findByCategoryIdParent(java.lang.Object)
	 */
	public List findByCategoryIdParent(Object categoryIdParent) {
		return findByProperty(CATEGORY_ID_PARENT, categoryIdParent);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.ICategoryDAO#merge(mil.yaye.yours.pojo.Category)
	 */
	public Category merge(Category detachedInstance) {
		log.debug("merging Category instance");
		try {
			Category result = (Category) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.ICategoryDAO#attachDirty(mil.yaye.yours.pojo.Category)
	 */
	public void attachDirty(Category instance) {
		log.debug("attaching dirty Category instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.ICategoryDAO#attachClean(mil.yaye.yours.pojo.Category)
	 */
	public void attachClean(Category instance) {
		log.debug("attaching clean Category instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}