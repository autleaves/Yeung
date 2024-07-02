package mil.yaye.yours.vo;

import java.util.ArrayList;
import java.util.List;

public class AccountVO {
	
	//个人基本信息<这个可由当前会话session中获取,因为查看'我的账户'只能是登陆后才能查看,
	//而登陆后就会从数据库中查询user表的个人信息,并放置在了session中>
	//在页面上的显示个人信息的选项卡上,还应提供修改信息的链接,
	private UserVO userVO;
	//我的收藏 默认只显示7条记录,多于7条,进行分页显示<如果用Ajax来实现不是很复杂,就用Ajax来实现,不过这里数据就需要转换为xml格式或json格式>
	private List<WishlistVO> wishlist = new ArrayList<WishlistVO>();
	//查看我的订单情况 交易纪录 默认只先显示离现在时间最近的5项交易记录,如果总记录少于5项,则不分时间,全部显示出来
	private List<OrderVO> orderlist = new ArrayList<OrderVO>();
	//查看我的积分 默认只提供给用户一个计算的结果,一个为:总获得积分,一个为:总消费积分
	private List<BonuspointVO> bonuspointlist = new ArrayList<BonuspointVO>();
	//根据用户的喜好订制,返回一些用户可能喜欢的商品信息
	private List<ProductVO> productlist = new ArrayList<ProductVO>();
	
	public AccountVO(){}


	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public List<WishlistVO> getWishlist() {
		return wishlist;
	}

	public void setWishlist(List<WishlistVO> wishlist) {
		this.wishlist = wishlist;
	}

	public List<OrderVO> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<OrderVO> orderlist) {
		this.orderlist = orderlist;
	}

	public List<BonuspointVO> getBonuspointlist() {
		return bonuspointlist;
	}

	public void setBonuspointlist(List<BonuspointVO> bonuspointlist) {
		this.bonuspointlist = bonuspointlist;
	}

	public List<ProductVO> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<ProductVO> productlist) {
		this.productlist = productlist;
	}

}
