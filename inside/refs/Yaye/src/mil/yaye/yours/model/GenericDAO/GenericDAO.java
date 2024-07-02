package mil.yaye.yours.model.GenericDAO;

import java.io.Serializable;
import java.util.List;

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
public interface GenericDAO<T, ID extends Serializable> {
	
	public abstract void setSession(Session session);
	
	public abstract ID create(T newInstance);
	public abstract T read(ID id);
	public abstract void update(T transientObject);
	public abstract void delete(T persistentObject);

//	public abstract T dynamicReadById(String constructor, String limits);
	public abstract T dynamicReadByProperty(Object constructor, Object limit, Object property);
	
	public abstract T findById(ID id);
	public abstract T findById(ID id, boolean lock);
	public abstract List<T> findAll();
	public abstract List<T> findByExample(T exampleInstance);
	
	public abstract List<T> findByCriteria(DetachedCriteria criteria);
	public abstract List<T> findByCriteria(Order order,Criterion... criterion);
	public abstract List<T> findByCriteria(Criterion... criterion);
	
}
