package mil.yaye.yours.factory;

//import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * Configures and provides access to Hibernate sessions, tied to the
 * current thread of execution.  Follows the Thread Local Session
 * pattern, see {@link http://hibernate.org/42.html }.
 */
public class HibernateSessionFactory {

	private static Logger logger = Logger.getLogger(HibernateSessionFactory.class.getName());
    /** 
     * Location of hibernate.cfg.xml file.
     * Location should be on the classpath as Hibernate uses  
     * #resourceAsStream style lookup for its configuration file. 
     * The default classpath location of the hibernate config file is 
     * in the default package. Use #setConfigFile() to update 
     * the location of the configuration file for the current session.
     */
    private static String CONFIG_FILE_LOCATION = "/mil/yaye/yours/conf/hibernate.cfg.xml";
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static Configuration configuration = new Configuration();
    private static org.hibernate.SessionFactory sessionFactory;
    private static String configFile = CONFIG_FILE_LOCATION;
    /*private static String CONFIG_FILE_LOCATION_LOG4J = "";
    private static String configFile_log4j = CONFIG_FILE_LOCATION_LOG4J;*/

	static {
    	try {
    		/*������������ʹ��log4j,�����������ļ�,�����ǲ��е�..��Ϊ
    		HibernateSessionFactory�ĳ�ʹ���ǵ�һ��ͨ��hibernate�������ݿ�ʱ���е�
    		������Tomcat������ʱ����
    		PropertyConfigurator.configure(configFile_log4j);*/
    		logger.info("HibernateSessionFactory.....configuration.configure(configFile)....��ʼ......");
			configuration.configure(configFile);
			logger.info("HibernateSessionFactory.....configuration.configure(configFile)....���......buildSessionFactory....��ʼ......");
			sessionFactory = configuration.buildSessionFactory();
			logger.info("HibernateSessionFactory.....buildSessionFactory....���......");
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			logger.info("%%%%%%%%%% Output creating sessionFactory..., please!! %%%%%%%%%%");
			e.printStackTrace();
			logger.info("%%%%%%%%%% Output creating sessionFactory..., please!! Over!!! %%%%%%%%%%");
		}
    }
    private HibernateSessionFactory() {
    }
	
	/**
     * Returns the ThreadLocal Session instance.  Lazy initialize
     * the <code>SessionFactory</code> if needed.
     *
     *  @return Session
     *  @throws HibernateException
     */
    public static Session getSession() throws HibernateException {
        logger.info("��ʼ׼����ȡsession��...........");
    	Session session = (Session) threadLocal.get();
    	if(session == null){logger.info("��һ�δ�ThreadLocal��û�л�ȡ��...��ʼ���´�sessionFactory�л�ȡ.....");}
		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
				logger.info("��û��������buildSessionFactory.......");
			}
			session = (sessionFactory != null) ? sessionFactory.openSession()
					: null;
			logger.info("session��ȡ����.....��sessionFactory.openSession()�л�ȡ����....");
			threadLocal.set(session);
			logger.info("threadLocal�����session����.......");
		}
		logger.info("ok....have..get...session......");
        return session;
    }

	/**
     *  Rebuild hibernate session factory
     *
     */
	public static void rebuildSessionFactory() {
		try {
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("%%%% Error ReCreating SessionFactory %%%%");
			System.out.println("%%%%%%%%%% Kiss me, please!! %%%%%%%%%%");
			e.printStackTrace();
			System.out.println("%%%%%%%%%% Kiss me, once more, please!! %%%%%%%%%%");
		}
	}

	/**
     *  Close the single hibernate session instance.
     *
     *  @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

	/**
     *  return session factory
     *
     */
	public static org.hibernate.SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
     *  return session factory
     *
     *	session factory will be rebuilded in the next call
     */
	public static void setConfigFile(String configFile) {
		HibernateSessionFactory.configFile = configFile;
		sessionFactory = null;
	}

	/**
     *  return hibernate configuration
     *
     */
	public static Configuration getConfiguration() {
		return configuration;
	}

}