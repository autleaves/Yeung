package mil.yaye.yours.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mil.yaye.yours.vo.AddressVO;
import mil.yaye.yours.vo.ProductVO;

public class BuyDTO {
	
//	private Integer userId;
//	private Integer addressId;
//	private Map<String, AddressVO> addrMap = new HashMap<String, AddressVO>();
	
	private Map<Integer, Integer> items = new HashMap<Integer, Integer>(); //一个为商品id,一个为购买数量
	private Map<String, String> chargeList = new HashMap<String, String>();
	private List<ProductVO> productList = new ArrayList<ProductVO>();
	private Map<String, Object> configuration = new HashMap<String, Object>();
	private Map<String, AddressVO> addrs = new HashMap<String, AddressVO>();
	
	public BuyDTO(){}
	
	
	
	public Map<String, AddressVO> getAddrs() {
		return addrs;
	}
	public void setAddrs(Map<String, AddressVO> addrs) {
		this.addrs = addrs;
	}
	public Map<String, Object> getConfiguration() {
		return configuration;
	}
	public void setConfiguration(Map<String, Object> configuration) {
		this.configuration = configuration;
	}
	public List<ProductVO> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductVO> productList) {
		this.productList = productList;
	}
	public Map<Integer, Integer> getItems() {
		return items;
	}
	public void setItems(Map<Integer, Integer> items) {
		this.items = items;
	}
	public Map<String, String> getChargeList() {
		return chargeList;
	}
	public void setChargeList(Map<String, String> chargeList) {
		this.chargeList = chargeList;
	}
	
	
	
}
