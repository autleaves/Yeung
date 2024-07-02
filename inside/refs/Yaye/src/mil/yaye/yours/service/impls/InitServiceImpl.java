package mil.yaye.yours.service.impls;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import mil.yaye.yours.factory.BeanFactory;
import mil.yaye.yours.factory.HibernateSessionFactory;
import mil.yaye.yours.service.InitService;

public class InitServiceImpl implements InitService {
	
	private static Logger logger = Logger.getLogger(InitServiceImpl.class.getName());
	
	// Fields
//	private BeanFactory daoFactory = null;
//	private InitDAO init_dao = null;
	
	// Constructor
	public InitServiceImpl() {
	}
	
	/* (non-Javadoc)
	 * @see mil.yaye.yours.service.impls.InitService#setDAO(mil.yaye.yours.factory.BeanFactory)
	 */
	public void setDAO(BeanFactory daoFactory) {
		/*this.daoFactory = daoFactory;
		String id_c = "InitDAO";
		init_dao = (InitDAO) daoFactory.getBean(id_c);*/
	}
	
	/* (non-Javadoc)
	 * @see mil.yaye.yours.service.impls.InitService#initDataSource()
	 */
	public int initDataSource() {
		int flag = 0;
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			String hqlstr = "SELECT sysdate FROM dual";
			SQLQuery sqlquery = session.createSQLQuery(hqlstr); //本地SQL查询
			sqlquery.addScalar("sysdate", Hibernate.DATE); //指定返回的字段和类型
			sqlquery.uniqueResult();
			tran.commit();
			session.close();
			flag = 7;
		} catch (HibernateException e) {
			if(tran != null){tran.rollback(); flag = -1;}
			e.printStackTrace();
		} finally {
			if(session != null){ session.close(); }
		}
		return flag;
	}
}
