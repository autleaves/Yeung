package mil.yaye.yours.model.ormDAO;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericDAO;
import mil.yaye.yours.pojo.Productcomment;

public interface ProductcommentDAO extends GenericDAO<Productcomment, Integer> {

	// property constants
	public static final String POINT = "point";
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String CREATETIME = "createtime";
	public static final String VERSION = "version";

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByPoint(Object point);

	public abstract List findByTitle(Object title);

	public abstract List findByContent(Object content);

	public abstract List findByCreatetime(Object createtime);

	public abstract Productcomment merge(Productcomment detachedInstance);

	public abstract void attachDirty(Productcomment instance);

	public abstract void attachClean(Productcomment instance);

}