package mil.yaye.yours.vo;

import java.math.BigDecimal;

public class OrderVO {

	private Integer orderId;
	private String status;
	private String createtime;
	private BigDecimal shipcharge;
	private BigDecimal totalprice;
	private BigDecimal pointprice;
	private BigDecimal adjustment;
	private BigDecimal discountprice;
	
	public OrderVO(){}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public BigDecimal getShipcharge() {
		return shipcharge;
	}

	public void setShipcharge(BigDecimal shipcharge) {
		this.shipcharge = shipcharge;
	}

	public BigDecimal getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}

	public BigDecimal getPointprice() {
		return pointprice;
	}

	public void setPointprice(BigDecimal pointprice) {
		this.pointprice = pointprice;
	}

	public BigDecimal getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(BigDecimal adjustment) {
		this.adjustment = adjustment;
	}

	public BigDecimal getDiscountprice() {
		return discountprice;
	}

	public void setDiscountprice(BigDecimal discountprice) {
		this.discountprice = discountprice;
	}
	
	
	
}
