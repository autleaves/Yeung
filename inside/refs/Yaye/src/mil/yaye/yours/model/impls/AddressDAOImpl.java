package mil.yaye.yours.model.impls;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericHibernateDAO;
import mil.yaye.yours.model.ormDAO.AddressDAO;
import mil.yaye.yours.pojo.Address;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Address entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mil.yaye.yours.pojo.Address
 * @author MyEclipse Persistence Tools
 */

public class AddressDAOImpl extends GenericHibernateDAO<Address, Integer> implements AddressDAO {
	private static final Log log = LogFactory.getLog(AddressDAOImpl.class);

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IAddress2#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List<Address> findByProperty(String propertyName, Object value) {
		log.debug("finding Address instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Address as model where model."
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
	 * @see mil.yaye.yours.model.impls.IAddress2#findByAddrname(java.lang.Object)
	 */
	public List<Address> findByAddrname(Object addrname) {
		return findByProperty(ADDRNAME, addrname);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IAddress2#findByRealname(java.lang.Object)
	 */
	public List<Address> findByRealname(Object realname) {
		return findByProperty(REALNAME, realname);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IAddress2#findByIsprimary(java.lang.Object)
	 */
	public List<Address> findByIsprimary(Object isprimary) {
		return findByProperty(ISPRIMARY, isprimary);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IAddress2#findByCountry(java.lang.Object)
	 */
	public List<Address> findByCountry(Object country) {
		return findByProperty(COUNTRY, country);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IAddress2#findByProvince(java.lang.Object)
	 */
	public List<Address> findByProvince(Object province) {
		return findByProperty(PROVINCE, province);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IAddress2#findByZipcode(java.lang.Object)
	 */
	public List<Address> findByZipcode(Object zipcode) {
		return findByProperty(ZIPCODE, zipcode);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IAddress2#findBySelfaddress(java.lang.Object)
	 */
	public List<Address> findBySelfaddress(Object selfaddress) {
		return findByProperty(SELFADDRESS, selfaddress);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IAddress2#findByTel(java.lang.Object)
	 */
	public List<Address> findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IAddress2#findByMobile(java.lang.Object)
	 */
	public List<Address> findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IAddress2#findByIdcard(java.lang.Object)
	 */
	public List<Address> findByIdcard(Object idcard) {
		return findByProperty(IDCARD, idcard);
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IAddress2#findByMarkfordelete(java.lang.Object)
	 */
	public List<Address> findByMarkfordelete(Object markfordelete) {
		return findByProperty(MARKFORDELETE, markfordelete);
	}

	public List<Address> findByForeignkey(Object userId){
		return findByProperty(FOREIGNKEY, userId);
	}
	
	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IAddress2#merge(mil.yaye.yours.pojo.Address)
	 */
	public Address merge(Address detachedInstance) {
		log.debug("merging Address instance");
		try {
			Address result = (Address) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IAddress2#attachDirty(mil.yaye.yours.pojo.Address)
	 */
	public void attachDirty(Address instance) {
		log.debug("attaching dirty Address instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see mil.yaye.yours.model.impls.IAddress2#attachClean(mil.yaye.yours.pojo.Address)
	 */
	public void attachClean(Address instance) {
		log.debug("attaching clean Address instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}