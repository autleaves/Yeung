package mil.yaye.yours.service.impls;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import mil.yaye.yours.factory.BeanFactory;
import mil.yaye.yours.factory.HibernateSessionFactory;
import mil.yaye.yours.model.ormDAO.ProductcommentDAO;
import mil.yaye.yours.service.OthersService;

public class OthersServiceImpl implements OthersService {
	
	private static Logger logger = Logger.getLogger(OthersServiceImpl.class.getName());
	// Fields
	private BeanFactory daoFactory = null;
	private ProductcommentDAO comment_dao = null;
//	private xxxDAO
	
	// Constructor
	public OthersServiceImpl() {
	}
	/*public OthersServiceImpl(){
		String id_c = "ProductcommentDAOImpl";
		comment_dao = (ProductcommentDAO) daoFactory.getBean(id_c);
	}*/
	public void setDAO(BeanFactory daoFactory) {
		this.daoFactory = daoFactory;
		String id_c = "ProductcommentDAOImpl";
		comment_dao = (ProductcommentDAO) daoFactory.getBean(id_c);
	}
	
	
}
