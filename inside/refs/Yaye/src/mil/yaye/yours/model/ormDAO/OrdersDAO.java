package mil.yaye.yours.model.ormDAO;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericDAO;
import mil.yaye.yours.pojo.Order;

public interface OrdersDAO extends GenericDAO<Order, Integer> {

	// property constants
	public static final String STATUS = "status";
	public static final String CREATETIME = "createtime";
	public static final String SHIPCHARGE = "shipcharge";
	public static final String TOTALPRICE = "totalprice";
	public static final String POINTPRICE = "pointprice";
	public static final String ADJUSTMENT = "adjustment";
	public static final String DISCOUNTPRICE = "discountprice";
	public static final String VERSION = "version";

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByStatus(Object status);

	public abstract List findByCreatetime(Object createtime);

	public abstract List findByShipcharge(Object shipcharge);

	public abstract List findByTotalprice(Object totalprice);

	public abstract List findByPointprice(Object pointprice);

	public abstract List findByAdjustment(Object adjustment);

	public abstract List findByDiscountprice(Object discountprice);

	public abstract Order merge(Order detachedInstance);

	public abstract void attachDirty(Order instance);

	public abstract void attachClean(Order instance);

}