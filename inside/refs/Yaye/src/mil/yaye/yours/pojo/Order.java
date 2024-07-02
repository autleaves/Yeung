package mil.yaye.yours.pojo;

import java.math.BigDecimal;

/**
 * Order entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer orderId;
	private String status;
	private String createtime;
	private BigDecimal shipcharge;
	private BigDecimal totalprice;
	private BigDecimal pointprice;
	private BigDecimal adjustment;
	private BigDecimal discountprice;
	private Integer version;
	
	private User user;
	private Address address;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(User user) {
		this.user = user;
	}

	/** full constructor */
	public Order(User user, Address address, String status,
			String createtime, BigDecimal shipcharge, BigDecimal totalprice,
			BigDecimal pointprice, BigDecimal adjustment, BigDecimal discountprice, Integer version) {
		this.user = user;
		this.address = address;
		this.status = status;
		this.createtime = createtime;
		this.shipcharge = shipcharge;
		this.totalprice = totalprice;
		this.pointprice = pointprice;
		this.adjustment = adjustment;
		this.discountprice = discountprice;
		this.version = version;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public BigDecimal getShipcharge() {
		return this.shipcharge;
	}

	public void setShipcharge(BigDecimal shipcharge) {
		this.shipcharge = shipcharge;
	}

	public BigDecimal getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}

	public BigDecimal getPointprice() {
		return this.pointprice;
	}

	public void setPointprice(BigDecimal pointprice) {
		this.pointprice = pointprice;
	}

	public BigDecimal getAdjustment() {
		return this.adjustment;
	}

	public void setAdjustment(BigDecimal adjustment) {
		this.adjustment = adjustment;
	}

	public BigDecimal getDiscountprice() {
		return this.discountprice;
	}

	public void setDiscountprice(BigDecimal discountprice) {
		this.discountprice = discountprice;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}