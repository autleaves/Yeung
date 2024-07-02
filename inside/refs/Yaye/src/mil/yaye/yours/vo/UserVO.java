package mil.yaye.yours.vo;

public class UserVO {

	// Fields
	
	private Integer userId;
	private String logonid;
	private String username;
	private String password;
	private String sessionid;
	private Integer status;
	private String registration;
	private Integer bonuspoint;
	private String memberclass;
	private Integer version;
	
	// DefaultConstrutors
	public UserVO(){
	}

	// Accessors
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public Integer getBonuspoint() {
		return bonuspoint;
	}

	public void setBonuspoint(Integer bonuspoint) {
		this.bonuspoint = bonuspoint;
	}

	public String getMemberclass() {
		return memberclass;
	}

	public void setMemberclass(String memberclass) {
		this.memberclass = memberclass;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
}
