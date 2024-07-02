package mil.yaye.yours.model.ormDAO;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericDAO;
import mil.yaye.yours.pojo.Wishlist;

public interface WishlistDAO extends GenericDAO<Wishlist, Integer> {

	// property constants
	public static final String VERSION = "version";

	public abstract List findByProperty(String propertyName, Object value);

	public abstract Wishlist merge(Wishlist detachedInstance);

	public abstract void attachDirty(Wishlist instance);

	public abstract void attachClean(Wishlist instance);

}