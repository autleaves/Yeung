package mil.yaye.yours.model.ormDAO;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericDAO;
import mil.yaye.yours.pojo.Bonuspoint;

public interface BonuspointDAO extends GenericDAO<Bonuspoint, Integer> {

	// property constants
	public static final String POINTNUM = "pointnum";
	public static final String CREATETIME = "createtime";
	public static final String BONUSPOINTTYPE = "bonuspointtype";
	public static final String STATUS = "status";
	public static final String VERSION = "version";

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByPointnum(Object pointnum);

	public abstract List findByCreatetime(Object createtime);

	public abstract List findByBonuspointtype(Object bonuspointtype);

	public abstract List findByStatus(Object status);

	public abstract Bonuspoint merge(Bonuspoint detachedInstance);

	public abstract void attachDirty(Bonuspoint instance);

	public abstract void attachClean(Bonuspoint instance);

}