package mil.yaye.yours.vo;

import mil.yaye.yours.pojo.Order;
import mil.yaye.yours.pojo.User;

public class BonuspointVO {
	
	private Integer historyId;
	private Integer pointnum;
	private String createtime;
	private String bonuspointtype;
	private String status;
	
	private Order order;
	private User user;

	public BonuspointVO(){}

	public Integer getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}

	public Integer getPointnum() {
		return pointnum;
	}

	public void setPointnum(Integer pointnum) {
		this.pointnum = pointnum;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getBonuspointtype() {
		return bonuspointtype;
	}

	public void setBonuspointtype(String bonuspointtype) {
		this.bonuspointtype = bonuspointtype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
