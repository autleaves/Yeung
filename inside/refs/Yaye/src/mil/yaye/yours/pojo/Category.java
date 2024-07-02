package mil.yaye.yours.pojo;


/**
 * Category entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer categoryId;
	private String categoryname;
	private Integer markfordelete;
	private String lastupdate;
	private String description;
	private String thumbnail;
	private String fullimage;
	private Integer istop;
	private Integer categoryIdParent;
	private Integer version;
	
//	private Set product = new HashSet(0);

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(String categoryname) {
		this.categoryname = categoryname;
	}
	
	/** minimal constructor */
	public Category(Integer categoryId, String categoryname, Integer categoryIdParent, Integer istop) {
		this.categoryId = categoryId;
		this.categoryname = categoryname;
		this.categoryIdParent = categoryIdParent;
		this.istop = istop;
	}
	
	/** full constructor */
	public Category(String categoryname, Integer markfordelete, String lastupdate,
			String description, String thumbnail, String fullimage, Integer istop,
			Integer categoryIdParent, Integer version) {
		this.categoryname = categoryname;
		this.markfordelete = markfordelete;
		this.lastupdate = lastupdate;
		this.description = description;
		this.thumbnail = thumbnail;
		this.fullimage = fullimage;
		this.istop = istop;
		this.categoryIdParent = categoryIdParent;
		this.version = version;
//		this.products = products;
	}

	// Property accessors

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryname() {
		return this.categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Integer getMarkfordelete() {
		return this.markfordelete;
	}

	public void setMarkfordelete(Integer markfordelete) {
		this.markfordelete = markfordelete;
	}

	public String getLastupdate() {
		return this.lastupdate;
	}

	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Integer getIstop() {
		return this.istop;
	}

	public void setIstop(Integer istop) {
		this.istop = istop;
	}

	public Integer getCategoryIdParent() {
		return this.categoryIdParent;
	}

	public void setCategoryIdParent(Integer categoryIdParent) {
		this.categoryIdParent = categoryIdParent;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	/*public Set getProduct() {
		return this.product;
	}

	public void setProduct(Set product) {
		this.product = product;
	}*/

}