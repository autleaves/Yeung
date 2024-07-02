package mil.yaye.yours.model.ormDAO;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericDAO;
import mil.yaye.yours.pojo.Product;
import mil.yaye.yours.util.PaginateDTO;

public interface ProductDAO extends GenericDAO<Product, Integer> {

	// property constants
	public static final String PRODUCTNAME = "productname";
	public static final String PARTNUMBER = "partnumber";
	public static final String MARKFORDELETE = "markfordelete";
	public static final String MINIMAGE = "minimage";
	public static final String THUMBNAIL = "thumbnail";
	public static final String FULLIMAGE = "fullimage";
	public static final String QUANTITY = "quantity";
	public static final String PRICE = "price";
	public static final String ISBRAND = "isbrand";
	public static final String BRAND = "brand";
	public static final String DESCRIPTION = "description";
	public static final String DISCOUNT = "discount";
	public static final String FOREIGNKEY = "category.categoryId";
	public static final String VERSION = "version";

	public abstract List findByProperty(String propertyName, Object value);
	public abstract List findByProperty(String propertyName, Object value, PaginateDTO paginateDTO);
	public abstract Object getTotalRecordByProperty(String propertyName, Object value);

	public abstract List findByProductname(Object productname);

	public abstract List findByPartnumber(Object partnumber);

	public abstract List findByMarkfordelete(Object markfordelete);

	public abstract List findByMinimage(Object minimage);
	
	public abstract List findByThumbnail(Object thumbnail);

	public abstract List findByFullimage(Object fullimage);

	public abstract List findByQuantity(Object quantity);

	public abstract List findByPrice(Object price);

	public abstract List findByIsbrand(Object isbrand);

	public abstract List findByBrand(Object brand);

	public abstract List findByDescription(Object description);

	public abstract List findByDiscount(Object discount);
	
	public abstract Object getTotalRecordByForeignKey(Object categoryId);
	public abstract List findByForeignkey(Object categoryId);
	public abstract List findByForeignkey(Object categoryId, PaginateDTO paginateDTO);

	public abstract Product merge(Product detachedInstance);

	public abstract void attachDirty(Product instance);

	public abstract void attachClean(Product instance);

}