package mil.yaye.yours.model.ormDAO;

import org.hibernate.Session;


/**
 * Data access interface for domain model
 * @author MyEclipse Persistence Tools
 */
public interface BaseHibernateDAO {
	public Session getSession();
}