package mil.yaye.yours.dto;

public class RegistDTO {
	
	private String logonid;
	private String username; //暂时先没有用
	private String password;
	//private String sessionid;
	//private Integer status;
	//private String registration;
	//private Integer bonuspoint;
	//private String memberclass;
	
	private String addrname;
	private String realname;
	private String birthday;
	//private Integer isprimary;
	private String country;
	private String province;
	private String city;
	private String zipcode;
	private String selfaddress;
	private String tel;
	private String mobile;
	private String safemail;
	private String idcard;
	//private Integer markfordelete;
	public String getLogonid() {
		return logonid;
	}
	public void setLogonid(String logonid) {
		this.logonid = logonid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddrname() {
		return addrname;
	}
	public void setAddrname(String addrname) {
		this.addrname = addrname;
	}
	public String getRealname() {
		return realname;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
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
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getSelfaddress() {
		return selfaddress;
	}
	public void setSelfaddress(String selfaddress) {
		this.selfaddress = selfaddress;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMobile() {
		return mobile;
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
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
}
