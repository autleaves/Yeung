package mil.yaye.yours.model.ormDAO;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericDAO;
import mil.yaye.yours.pojo.Category;

public interface CategoryDAO extends GenericDAO<Category, Integer>{

	// property constants
	public static final String CATEGORYNAME = "categoryname";
	public static final String MARKFORDELETE = "markfordelete";
	public static final String LASTUPDATE = "lastupdate";
	public static final String DESCRIPTION = "description";
	public static final String THUMBNAIL = "thumbnail";
	public static final String FULLIMAGE = "fullimage";
	public static final String ISTOP = "istop";
	public static final String CATEGORY_ID_PARENT = "categoryIdParent";
	public static final String VERSION = "version";

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCategoryname(Object categoryname);

	public abstract List findByMarkfordelete(Object markfordelete);

	public abstract List findByLastupdate(Object lastupdate);

	public abstract List findByDescription(Object description);

	public abstract List findByThumbnail(Object thumbnail);

	public abstract List findByFullimage(Object fullimage);

	public abstract List findByIstop(Object istop);

	public abstract List findByCategoryIdParent(Object categoryIdParent);

	public abstract Category merge(Category detachedInstance);

	public abstract void attachDirty(Category instance);

	public abstract void attachClean(Category instance);

}