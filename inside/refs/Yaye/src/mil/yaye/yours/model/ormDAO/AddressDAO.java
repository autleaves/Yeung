package mil.yaye.yours.model.ormDAO;

import java.util.List;

import mil.yaye.yours.model.GenericDAO.GenericDAO;
import mil.yaye.yours.pojo.Address;

public interface AddressDAO extends GenericDAO<Address, Integer> {

	// property constants
	public static final String ADDRNAME = "addrname";
	public static final String REALNAME = "realname";
	public static final String ISPRIMARY = "isprimary";
	public static final String COUNTRY = "country";
	public static final String PROVINCE = "province";
	public static final String ZIPCODE = "zipcode";
	public static final String SELFADDRESS = "selfaddress";
	public static final String TEL = "tel";
	public static final String MOBILE = "mobile";
	public static final String IDCARD = "idcard";
	public static final String MARKFORDELETE = "markfordelete";
	public static final String FOREIGNKEY = "user.userId";
	public static final String VERSION = "version";

	public static final String METHOD_FindByProperty = "AddressDAO.findByProperty";

	public abstract List<Address> findByProperty(String propertyName, Object value);

	public abstract List<Address> findByAddrname(Object addrname);

	public abstract List<Address> findByRealname(Object realname);

	public abstract List<Address> findByIsprimary(Object isprimary);

	public abstract List<Address> findByCountry(Object country);

	public abstract List<Address> findByProvince(Object province);

	public abstract List<Address> findByZipcode(Object zipcode);

	public abstract List<Address> findBySelfaddress(Object selfaddress);

	public abstract List<Address> findByTel(Object tel);

	public abstract List<Address> findByMobile(Object mobile);

	public abstract List<Address> findByIdcard(Object idcard);

	public abstract List<Address> findByMarkfordelete(Object markfordelete);
	
	public abstract List<Address> findByForeignkey(Object userId);

	public abstract Address merge(Address detachedInstance);

	public abstract void attachDirty(Address instance);

	public abstract void attachClean(Address instance);

}