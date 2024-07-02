package mil.yaye.yours.util;

public class PaginateDTO {
	//Fields
	private int index = 0;
	private int size = 0;
	
	public PaginateDTO(){}
	//用这个构造函数去new 一个对象的时候,我会自动根据Constants类中的一个公共常量给它一个默认的size值
	public PaginateDTO(int index){
		this.index = index;
	}
	public PaginateDTO(int index, int size) {
		this.index = index;
		this.size = size;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
