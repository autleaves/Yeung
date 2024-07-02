package mil.yaye.yours.service;

import java.util.List;
import java.util.Map;

import mil.yaye.yours.dto.BuyDTO;
import mil.yaye.yours.factory.BeanFactory;
import mil.yaye.yours.vo.ProductVO;

/**
 * 
 * @author Yaye
 *	����ҵ���������
 */

public interface TradeService {
	
	enum STATUS {A,B,C,D}; //(�ͻ����µ�\���ͨ��\��ȡ�������ʹ�):A\B\C\D
	
	public abstract void setDAO(BeanFactory daoFactory);

	public abstract boolean buy(BuyDTO buyDTO);
	
	public abstract boolean buy(BuyDTO orderDTO, boolean isUseBonuspoint);
	
	public abstract Map<String, String> calcOrder(List<ProductVO> productlist, Map<Integer, Integer> simpleinfo);
	
	public abstract Map<String, String> calcOrder(List<ProductVO> productlist, Map<Integer, Integer> simpleinfo, Integer bonouspoint);

	public abstract boolean collect(Integer productid);
}