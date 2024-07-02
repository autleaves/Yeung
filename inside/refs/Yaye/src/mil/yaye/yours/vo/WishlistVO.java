package mil.yaye.yours.vo;

import mil.yaye.yours.pojo.Product;
import mil.yaye.yours.pojo.User;

public class WishlistVO {

	private Integer wishlistId;
	private User user;
	private Product product;
	
	public WishlistVO(){}

	public Integer getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(Integer wishlistId) {
		this.wishlistId = wishlistId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
