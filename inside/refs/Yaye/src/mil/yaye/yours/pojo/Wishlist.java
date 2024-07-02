package mil.yaye.yours.pojo;

/**
 * Wishlist entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Wishlist implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer wishlistId;
	private Integer version;
	
	private User user;
	private Product product;

	// Constructors

	/** default constructor */
	public Wishlist() {
	}

	/** minimal constructor */
	public Wishlist(User user, Product product) {
		this.user = user;
		this.product = product;
	}

	/** full constructor */
	public Wishlist(User user, Product product, Integer version) {
		this.user = user;
		this.product = product;
		this.version = version;
	}

	// Property accessors

	public Integer getWishlistId() {
		return this.wishlistId;
	}

	public void setWishlistId(Integer wishlistId) {
		this.wishlistId = wishlistId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}