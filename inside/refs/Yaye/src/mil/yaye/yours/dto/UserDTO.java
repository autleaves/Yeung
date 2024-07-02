package mil.yaye.yours.dto;


public class UserDTO implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	/*private Address address;
	private Set productcomments = new HashSet(0);
	private Set wishlists = new HashSet(0);
	private Set bonuspoints = new HashSet(0);
	private Set orderses = new HashSet(0);*/

	// Constructors

	/** default constructor */
	public UserDTO() {
	}

	/** minimal constructor */
	public UserDTO(String logonid, String username, String password) {
		this.logonid = logonid;
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public UserDTO(String logonid, String username, String password,
			String sessionid, Integer status, String registration,
			Integer bonuspoint, String memberclass, Integer version) {
		this.logonid = logonid;
		this.username = username;
		this.password = password;
		this.sessionid = sessionid;
		this.status = status;
		this.registration = registration;
		this.bonuspoint = bonuspoint;
		this.memberclass = memberclass;
		this.version = version;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLogonid() {
		return this.logonid;
	}

	public void setLogonid(String logonid) {
		this.logonid = logonid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSessionid() {
		return this.sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRegistration() {
		return this.registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public Integer getBonuspoint() {
		return this.bonuspoint;
	}

	public void setBonuspoint(Integer bonuspoint) {
		this.bonuspoint = bonuspoint;
	}

	public String getMemberclass() {
		return this.memberclass;
	}

	public void setMemberclass(String memberclass) {
		this.memberclass = memberclass;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
