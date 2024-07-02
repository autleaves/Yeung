package mil.yaye.yours.pojo;

import java.math.BigDecimal;

/**
 * Orderitem entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Orderitem implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer orderitemId;
	private String createtime;
	private Integer quantity;
	private BigDecimal price;
	private BigDecimal discountprice;
	private Integer version;

	private Product product;
	private Order order;
	
	// Constructors

	/** default constructor */
	public Orderitem() {
	}

	/** minimal constructor */
	public Orderitem(Order order, Product product) {
		this.order = order;
		this.product = product;
	}

	/** full constructor */
	public Orderitem(Order order, Product product, String createtime,
			Integer quantity, BigDecimal price, BigDecimal discountprice, Integer version) {
		this.order = order;
		this.product = product;
		this.createtime = createtime;
		this.quantity = quantity;
		this.price = price;
		this.discountprice = discountprice;
		this.version = version;
	}

	// Property accessors

	public Integer getOrderitemId() {
		return this.orderitemId;
	}

	public void setOrderitemId(Integer orderitemId) {
		this.orderitemId = orderitemId;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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