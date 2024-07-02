package mil.yaye.yours.model.ormDAO;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericDAO;
import mil.yaye.yours.pojo.Orderitem;

public interface OrderitemsDAO extends GenericDAO<Orderitem, Integer>{

	// property constants
	public static final String CREATETIME = "createtime";
	public static final String QUANTITY = "quantity";
	public static final String PRICE = "price";
	public static final String DISCOUNTPRICE = "discountprice";
	public static final String VERSION = "version";

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCreatetime(Object createtime);

	public abstract List findByQuantity(Object quantity);

	public abstract List findByPrice(Object price);

	public abstract List findByDiscountprice(Object discountprice);

	public abstract Orderitem merge(Orderitem detachedInstance);

	public abstract void attachDirty(Orderitem instance);

	public abstract void attachClean(Orderitem instance);

}