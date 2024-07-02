package mil.yaye.yours.pojo;


/**
 * Address entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Address implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer addressId;
	private String addrname;
	private String realname;
	private String birthday;
	private Integer isprimary;
	private String country;
	private String province;
	private String city;
	private String zipcode;
	private String selfaddress;
	private String tel;
	private String mobile;
	private String safemail;
	private String idcard;
	private Integer markfordelete;
	private Integer version;
	
	private User user;
	
	//private Set orderses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(User user, String addrname) {
		this.user = user;
		this.addrname = addrname;
	}

	/** full constructor */
	public Address(User user, String addrname, String realname,
			String birthday, Integer isprimary, String country, String province, String city,
			String zipcode, String selfaddress, String tel, String mobile, String safemail,
			String idcard, Integer markfordelete, Integer version) {
		this.user = user;
		this.addrname = addrname;
		this.realname = realname;
		this.birthday = birthday;
		this.isprimary = isprimary;
		this.country = country;
		this.province = province;
		this.city = city;
		this.zipcode = zipcode;
		this.selfaddress = selfaddress;
		this.tel = tel;
		this.mobile = mobile;
		this.safemail = safemail;
		this.idcard = idcard;
		this.markfordelete = markfordelete;
		this.version = version;
//		this.orderses = orderses;
	}

	// Property accessors

	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddrname() {
		return this.addrname;
	}

	public void setAddrname(String addrname) {
		this.addrname = addrname;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getIsprimary() {
		return this.isprimary;
	}

	public void setIsprimary(Integer isprimary) {
		this.isprimary = isprimary;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getSelfaddress() {
		return this.selfaddress;
	}

	public void setSelfaddress(String selfaddress) {
		this.selfaddress = selfaddress;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getSafemail() {
		return safemail;
	}
	
	public void setSafemail(String safemail) {
		this.safemail = safemail;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Integer getMarkfordelete() {
		return this.markfordelete;
	}

	public void setMarkfordelete(Integer markfordelete) {
		this.markfordelete = markfordelete;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	/*public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}*/

}