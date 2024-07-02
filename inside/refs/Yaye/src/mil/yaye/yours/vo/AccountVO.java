package mil.yaye.yours.vo;

import java.util.ArrayList;
import java.util.List;

public class AccountVO {
	
	//���˻�����Ϣ<������ɵ�ǰ�Ựsession�л�ȡ,��Ϊ�鿴'�ҵ��˻�'ֻ���ǵ�½����ܲ鿴,
	//����½��ͻ�����ݿ��в�ѯuser��ĸ�����Ϣ,����������session��>
	//��ҳ���ϵ���ʾ������Ϣ��ѡ���,��Ӧ�ṩ�޸���Ϣ������,
	private UserVO userVO;
	//�ҵ��ղ� Ĭ��ֻ��ʾ7����¼,����7��,���з�ҳ��ʾ<�����Ajax��ʵ�ֲ��Ǻܸ���,����Ajax��ʵ��,�����������ݾ���Ҫת��Ϊxml��ʽ��json��ʽ>
	private List<WishlistVO> wishlist = new ArrayList<WishlistVO>();
	//�鿴�ҵĶ������ ���׼�¼ Ĭ��ֻ����ʾ������ʱ�������5��׼�¼,����ܼ�¼����5��,�򲻷�ʱ��,ȫ����ʾ����
	private List<OrderVO> orderlist = new ArrayList<OrderVO>();
	//�鿴�ҵĻ��� Ĭ��ֻ�ṩ���û�һ������Ľ��,һ��Ϊ:�ܻ�û���,һ��Ϊ:�����ѻ���
	private List<BonuspointVO> bonuspointlist = new ArrayList<BonuspointVO>();
	//�����û���ϲ�ö���,����һЩ�û�����ϲ������Ʒ��Ϣ
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
