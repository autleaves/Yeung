package mil.yaye.yours.model.ormDAO;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericDAO;
import mil.yaye.yours.pojo.User;

public interface UsersDAO extends GenericDAO<User, Integer> {

	// property constants
	public static final String LOGONID = "logonid";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String SESSIONID = "sessionid";
	public static final String STATUS = "status";
	public static final String REGISTRATION = "registration";
	public static final String BONUSPOINT = "bonuspoint";
	public static final String MEMBERCLASS = "memberclass";
	public static final String VERSION = "version";

	public abstract List findByProperty(String propertyName, Object value);
	
	public abstract User findByProperty(String constructor, String propertyName, Object value);

	public abstract List findByLogonid(Object logonid);

	public abstract List findByUsername(Object username);
	
	public abstract User findByUsername(Object constructor,Object username);

	public abstract List findByPassword(Object password);

	public abstract List findBySessionid(Object sessionid);

	public abstract List findByStatus(Object status);

	public abstract List findByRegistration(Object registration);

	public abstract List findByBonuspoint(Object bonuspoint);

	public abstract List findByMemberclass(Object memberclass);

	public abstract User merge(User detachedInstance);

	public abstract void attachDirty(User instance);

	public abstract void attachClean(User instance);
	
}