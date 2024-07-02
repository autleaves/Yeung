package mil.yaye.yours.pojo;

/**
 * Productcomment entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Productcomment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer commentId;
	private Integer point;
	private String title;
	private String content;
	private String createtime;
	private Integer version;

	private User user;
	private Product product;
	
	// Constructors

	/** default constructor */
	public Productcomment() {
	}

	/** minimal constructor */
	public Productcomment(User user, Product product) {
		this.user = user;
		this.product = product;
	}

	/** full constructor */
	public Productcomment(User user, Product product, Integer point,
			String title, String content, String createtime, Integer version) {
		this.user = user;
		this.product = product;
		this.point = point;
		this.title = title;
		this.content = content;
		this.createtime = createtime;
		this.version = version;
	}

	// Property accessors

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public User getUser() {
		return user;
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

}