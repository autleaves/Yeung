package mil.yaye.yours.pojo;

/**
 * Bonuspoint entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Bonuspoint implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer historyId;
	private Integer pointnum;
	private String createtime;
	private String bonuspointtype;
	private String status;
	private Integer version;

	private Order order;
	private User user;
	
	// Constructors

	/** default constructor */
	public Bonuspoint() {
	}

	/** minimal constructor */
	public Bonuspoint(User user) {
		this.user = user;
	}

	/** full constructor */
	public Bonuspoint(Order order, User user, Integer pointnum,
			String createtime, String bonuspointtype, String status,
			Integer version) {
		this.order = order;
		this.user = user;
		this.pointnum = pointnum;
		this.createtime = createtime;
		this.bonuspointtype = bonuspointtype;
		this.status = status;
		this.version = version;
	}

	// Property accessors

	public Integer getHistoryId() {
		return this.historyId;
	}

	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}


	public Integer getPointnum() {
		return this.pointnum;
	}

	public void setPointnum(Integer pointnum) {
		this.pointnum = pointnum;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getBonuspointtype() {
		return this.bonuspointtype;
	}

	public void setBonuspointtype(String bonuspointtype) {
		this.bonuspointtype = bonuspointtype;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}