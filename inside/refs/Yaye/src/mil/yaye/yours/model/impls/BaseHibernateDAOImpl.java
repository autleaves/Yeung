package mil.yaye.yours.model.impls;

import mil.yaye.yours.factory.HibernateSessionFactory;
import mil.yaye.yours.model.ormDAO.BaseHibernateDAO;

import org.hibernate.Session;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAOImpl implements BaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
	
}