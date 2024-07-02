package mil.yaye.yours.model.GenericDAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

/**
 * 
 * @author Yaye
 *
 * @param <T>
 * @param <ID>
 */
public abstract class GenericHibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {
	private static final Log log = LogFactory.getLog(GenericHibernateDAO.class);

	private Class<T> persistentClass;
	private Session session;
	
	@SuppressWarnings("unchecked")
	public GenericHibernateDAO(){
		log.info("开始赋值当前persistentClass......");
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                								.getGenericSuperclass()).getActualTypeArguments()[0];
		log.info("当前persistentClass的完整名称为:..." + this.persistentClass);
		log.info("当前persistentClass的类名称为:..." + this.persistentClass.getName());
	}

	public void setSession(Session session){
		log.info("开始set一个session..........");
		this.session = session;
		log.info("已经set完毕session了........");
	}
	protected Session getSession(){
		if(session == null){
			throw new IllegalStateException("Session has not been set on DAO before usage.");
		}
		return session;
	}
	public Class<T> getPersistentClass(){
		return persistentClass;
	}
	
	@SuppressWarnings("unchecked")
	public ID create(T newInstance) {
		log.debug("saving new instance");
		ID id;
		try {
			id = (ID)getSession().save(newInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save fail", re);
			throw re;
		}
		return id;
	}


	public void delete(T persistentObject) {
		log.debug("deleting new instance");
		try {
			getSession().delete(persistentObject);
			log.debug("deleting successful");
		} catch (RuntimeException re) {
			log.error("delete fail", re);
			throw re;
		}
	}
	

	public void update(T transientObject) {
		log.debug("updating new instance");
		try {
			getSession().update(transientObject);
			log.debug("updating successful");
		} catch (RuntimeException re) {
			log.error("update fail", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public T read(ID id) {
		log.debug("reading new instance");
		T entry;
		try {
			entry = (T) getSession().get(persistentClass, id);
			log.debug("reading successful");
		} catch (RuntimeException re) {
			log.error("read fail", re);
			throw re;
		}
		return entry;
	}
	/*@SuppressWarnings("unchecked")
	public T dynamicReadById(String constructor, String limits) {
		T entry;
		String hqlstr = "SELECT new " + getPersistentClass().getName() + constructor + " FROM " + getPersistentClass().getName()
					+ " AS model WHERE " + limits;
		entry = (T) getSession().createQuery(hqlstr).uniqueResult();
		return entry;
	}*/
	@SuppressWarnings("unchecked")
	public T dynamicReadByProperty(Object constructor, Object limit, Object property) {
		T entry;
		String hqlstr = "SELECT new " + getPersistentClass().getName() + constructor + " FROM " + getPersistentClass().getName()
					+ " AS model WHERE " + limit + "=?";
		log.info("GenericHibernateDAO.....hqlStr的完整语句为..:" + hqlstr);
		entry = (T) getSession().createQuery(hqlstr).setParameter(0, property).uniqueResult();
		return entry;
	}
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		log.debug("updating new instance");
		List<T> list;
		try {
			list = getSession().createQuery("From " + getPersistentClass().getName()).list();
			log.debug("updating successful");
		} catch (RuntimeException re) {
			log.error("update fail", re);
			throw re;
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		T entry;
		entry = (T) getSession().load(getPersistentClass().getName(), id);
		return entry;
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id, boolean lock) {
		T entry;
		if(lock){
			entry = (T) getSession().load(getPersistentClass().getName(), id, LockMode.UPGRADE);
		}else{
			entry = (T) getSession().load(getPersistentClass().getName(), id);
		}
		return entry;
	}

	public List<T> findByExample(T exampleInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> findByCriteria(DetachedCriteria criteria) {
		Criteria crit = criteria.getExecutableCriteria(getSession());
		return crit.list();
	}
	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(Order order,Criterion... criterion){
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for(Criterion c : criterion){
			crit.add(c);
		}
		if(order != null){
			crit.addOrder(order);
		}
		return crit.list();
	}
	public List<T> findByCriteria(Criterion... criterion) {
		// TODO Auto-generated method stub
		return null;
	}
}
