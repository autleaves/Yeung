package mil.yaye.yours.util;

public class PaginateDTO {
	//Fields
	private int index = 0;
	private int size = 0;
	
	public PaginateDTO(){}
	//��������캯��ȥnew һ�������ʱ��,�һ��Զ�����Constants���е�һ��������������һ��Ĭ�ϵ�sizeֵ
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
