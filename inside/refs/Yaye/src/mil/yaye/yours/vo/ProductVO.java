package mil.yaye.yours.vo;

import java.math.BigDecimal;

import mil.yaye.yours.pojo.Category;

public class ProductVO {
	private Integer productId;
	private String productname;
	private String partnumber;
	private Integer markfordelete;
	private String minimage;
	private String thumbnail;
	private String fullimage;
	private Integer quantity;
	private BigDecimal price;
	private String jointime;
	private Integer isbrand;
	private String brand;
	private String description;
	private Integer discount;
	private Integer version;
	
	private Category category;

	// Constructors

	/** default constructor */
	public ProductVO() {
	}

	/** minimal constructor */
	public ProductVO(Category category, String productname) {
		this.category = category;
		this.productname = productname;
	}

	/** full constructor */
	public ProductVO(Category category, String productname, String partnumber,
			Integer markfordelete, String minimage, String thumbnail, String fullimage,
			Integer quantity, BigDecimal price, String jointime, Integer isbrand, String brand,
			String description, Integer discount, Integer version) {
		this.category = category;
		this.productname = productname;
		this.partnumber = partnumber;
		this.markfordelete = markfordelete;
		this.thumbnail = thumbnail;
		this.minimage = minimage;
		this.fullimage = fullimage;
		this.quantity = quantity;
		this.price = price;
		this.jointime = jointime;
		this.isbrand = isbrand;
		this.brand = brand;
		this.description = description;
		this.discount = discount;
		this.version = version;
	}

	// Property accessors

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getPartnumber() {
		return this.partnumber;
	}

	public void setPartnumber(String partnumber) {
		this.partnumber = partnumber;
	}

	public Integer getMarkfordelete() {
		return this.markfordelete;
	}

	public void setMarkfordelete(Integer markfordelete) {
		this.markfordelete = markfordelete;
	}
	
	public String getMinimage() {
		return minimage;
	}

	public void setMinimage(String minimage) {
		this.minimage = minimage;
	}

	public String getThumbnail() {
		return this.thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getFullimage() {
		return this.fullimage;
	}

	public void setFullimage(String fullimage) {
		this.fullimage = fullimage;
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

	public String getJointime() {
		return jointime;
	}

	public void setJointime(String jointime) {
		this.jointime = jointime;
	}

	public Integer getIsbrand() {
		return this.isbrand;
	}

	public void setIsbrand(Integer isbrand) {
		this.isbrand = isbrand;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
