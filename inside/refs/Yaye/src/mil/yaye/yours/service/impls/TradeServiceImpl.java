package mil.yaye.yours.service.impls;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mil.yaye.yours.dto.BuyDTO;
import mil.yaye.yours.factory.BeanFactory;
import mil.yaye.yours.factory.HibernateSessionFactory;
import mil.yaye.yours.model.ormDAO.AddressDAO;
import mil.yaye.yours.model.ormDAO.BonuspointDAO;
import mil.yaye.yours.model.ormDAO.OrderitemsDAO;
import mil.yaye.yours.model.ormDAO.OrdersDAO;
import mil.yaye.yours.model.ormDAO.ProductDAO;
import mil.yaye.yours.model.ormDAO.UsersDAO;
import mil.yaye.yours.pojo.Address;
import mil.yaye.yours.pojo.Bonuspoint;
import mil.yaye.yours.pojo.Order;
import mil.yaye.yours.pojo.Orderitem;
import mil.yaye.yours.pojo.Product;
import mil.yaye.yours.pojo.User;
import mil.yaye.yours.service.TradeService;
import mil.yaye.yours.vo.AddressVO;
import mil.yaye.yours.vo.ProductVO;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TradeServiceImpl implements TradeService {
	
	private static Logger logger = Logger.getLogger(TradeServiceImpl.class.getName());
	
	private BeanFactory daoFactory = null;
	
//	private AddressDAO address_DAO;
	private ProductDAO product_DAO = null;
	private BonuspointDAO bonuspoint_DAO = null;
	private OrdersDAO orders_DAO = null;
	private OrderitemsDAO orderitems_DAO = null;
	private UsersDAO users_DAO = null;
	private AddressDAO address_DAO = null;
	
	// Constructors
	public void setDAO(BeanFactory beanFactory){
		this.daoFactory = beanFactory;
		String id_pr = "ProductDAO";
		String id_bo = "BonuspointDAO";
		String id_or = "OrdersDAO";
		String id_oi = "OrderitemsDAO";
		String id_ur = "UsersDAO";
		String id_ar = "AddressDAO";
		product_DAO = (ProductDAO) daoFactory.getBean(id_pr);
		bonuspoint_DAO = (BonuspointDAO) daoFactory.getBean(id_bo);
		orders_DAO = (OrdersDAO) daoFactory.getBean(id_or);
		orderitems_DAO = (OrderitemsDAO) daoFactory.getBean(id_oi);
		users_DAO = (UsersDAO) daoFactory.getBean(id_ur);
		address_DAO = (AddressDAO) daoFactory.getBean(id_ar);
	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.service.impls.TradeService#buy(java.lang.Integer[])
	 */
	public boolean buy(Integer[] product_id){
		boolean flag = false;
		
		return flag;
	}
	//��Ʒ����������1
	//����һ�Ŷ���,���������many��������-Ҳ��many����Ʒ
	//�˴ι���,������Ӧ�Ļ���,���������û�����Լ���ǰ�Ļ��������Ǯ,��Ҫ
	public boolean buy(BuyDTO buyDTO) {
		boolean flag = false;
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			SimpleDateFormat dateformat_Ymd = new SimpleDateFormat("yyyy-MM-dd");
			String createtime = dateformat_Ymd.format(new Date(System.currentTimeMillis()));
			
			product_DAO.setSession(session);
			bonuspoint_DAO.setSession(session);
			orders_DAO.setSession(session);
			orderitems_DAO.setSession(session);
			users_DAO.setSession(session);
			address_DAO.setSession(session);
			
			Map<String, String> chargeList = buyDTO.getChargeList();
			Iterator<ProductVO> iter_products = buyDTO.getProductList().iterator();
			Map<Integer, Integer> items = buyDTO.getItems();
			Map<String, Object> configuration = buyDTO.getConfiguration();
			Map<String, AddressVO> addrs = buyDTO.getAddrs();
			
			Integer userId = (Integer) configuration.get("USER_ID");
			logger.info("USER_ID="+ userId);
			Integer addrId = ((AddressVO) addrs.get(configuration.get("ADDR_KEY"))).getAddressId();
			
			//************************1***************************
			Order order = new Order();
			BigDecimal totalprice = new BigDecimal(chargeList.get("totalprice"));
			BigDecimal shipcharge = new BigDecimal(chargeList.get("shipcharge"));
			BigDecimal pointprice = new BigDecimal(chargeList.get("pointprice"));
			BigDecimal adjustment = new BigDecimal(chargeList.get("adjustment"));
			BigDecimal discountprice = new BigDecimal(chargeList.get("discountprice"));
			
			/*Address address = new Address();
			address.setAddressId(addrId);
			User user = new User();
			user.setUserId(userId);*/
			Address address = address_DAO.read(addrId);
			User user = users_DAO.read(userId);
			
			order.setStatus(STATUS.A.toString()); //enum����toString��
			order.setCreatetime(createtime);
			order.setShipcharge(shipcharge);	//�˷�
			order.setTotalprice(totalprice);	//�ܼ�
			order.setPointprice(pointprice);	//���ֳ��
			order.setAdjustment(adjustment);	//�۸����
			order.setDiscountprice(discountprice);	//�ۺ��
			order.setUser(user);
			order.setAddress(address);
			Integer orderId = orders_DAO.create(order); //1�������ݿ�orders���в���һ���־û�����
//			order.setOrderId(orderId);
			//*************************1**************************
			//*************************2**************************
			Orderitem orderitem = null;
			Product product = null;
			ProductVO productVO = null;
			while(iter_products.hasNext()){
				productVO = iter_products.next();
				product = new Product();
				BeanUtils.copyProperties(product, productVO);
				orderitem = new Orderitem();
				orderitem.setCreatetime(createtime);
				orderitem.setQuantity(items.get(productVO.getProductId()));
				orderitem.setPrice(product.getPrice().multiply(new BigDecimal(orderitem.getQuantity())));
				orderitem.setDiscountprice(orderitem.getPrice().multiply(new BigDecimal(productVO.getDiscount())).divide(new BigDecimal(100)));
				orderitem.setOrder(order);
				orderitem.setProduct(product);
				orderitems_DAO.create(orderitem);	//2������һ��orderitem�־û�����
				logger.info("productVO.getProductId()=" + productVO.getProductId());
				logger.info("orderitem.getQuantity()=" + orderitem.getQuantity());
				logger.info("product.getQuantity()=" + product.getQuantity());
				
				product.setQuantity(product.getQuantity() - items.get(productVO.getProductId()));
				product_DAO.update(product); //3���޸�product���и�����¼������
			}
			//*************************************************
			Bonuspoint bonus = new Bonuspoint();
			bonus.setCreatetime(createtime);
			bonus.setPointnum(Integer.parseInt(chargeList.get("getpoint")));
			bonus.setBonuspointtype("GET"); //��ȡ����
			bonus.setStatus("P");
			bonus.setUser(user);
			bonus.setOrder(order);
			bonuspoint_DAO.create(bonus);	//4������һ��Bonuspoint�־û�����
			//***************************************************
			
			tran.commit();
			flag = true;
			session.close();
		} catch (HibernateException e) {
			if(tran != null){tran.rollback();}
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			if(tran != null){tran.rollback();}
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			if(tran != null){tran.rollback();}
			e.printStackTrace();
		} finally{
			if(session != null){session.close();}
		}
		return flag;
	}

	public Map<String, String> calcOrder(List<ProductVO> productlist, Map<Integer, Integer> simpleinfo){
		Map<String, String> result = new HashMap<String, String>(); //һ��Ϊ��������,һ���Ƿ���
		
		BigDecimal totalprice = new BigDecimal(0d);	//�ܼ�
		BigDecimal discountprice = new BigDecimal(0d);	//�ۺ��ܼ�
		BigDecimal shipcharge = new BigDecimal(30d); //�˷�
		BigDecimal pointprice = null;	//���ֳ�ּ�
		BigDecimal adjustment = new BigDecimal(0d);	//�۸����=���ۼ�+���ֳ�ּ�
		int totalnum = 0;
		
		BigDecimal discount = new BigDecimal(0d); //���ۼ�
		Integer getpoint = 0;	//��ȡ�ܻ���
		Integer outpoint = 0;
		
		Iterator<ProductVO> iter = productlist.iterator();
		ProductVO productVO = null;
		int i = 0;
		while(iter.hasNext()){
			logger.info("����һ��ѭ����" + (++i) + "��");
			productVO = iter.next();
			logger.info("product��price=" + productVO.getPrice());
			int num = simpleinfo.get(productVO.getProductId());
			logger.info("num=" + 1);
			totalprice = totalprice.add(productVO.getPrice().multiply(new BigDecimal(num)));
			logger.info("totalprice=" + totalprice);
			logger.info("productVO.getDiscount()=" + productVO.getDiscount());
			BigDecimal y = productVO.getPrice().multiply(new BigDecimal(productVO.getDiscount()).divide(new BigDecimal(100)));
			logger.info("y=" + y);
			discount = discount.add((productVO.getPrice().subtract(y)).multiply(new BigDecimal(num)));
//			discount = discount.add(productVO.getPrice().subtract(productVO.getPrice().multiply(new BigDecimal(productVO.getDiscount()).divide(new BigDecimal(100)))).multiply(new BigDecimal(num)));
			logger.info("discount=" + discount);
		}
		pointprice  = new BigDecimal(outpoint * 0.5);
		adjustment = discount.add(pointprice);
		getpoint = totalprice.subtract(discount).intValue() / 2;
		discountprice = totalprice.subtract(adjustment).add(shipcharge);
		
		logger.info("totalprice=" + totalprice);
		logger.info("discount=" + discount);
		logger.info("pointprice=" + pointprice);
		logger.info("adjustment=" + adjustment);
		logger.info("getpoint=" + getpoint);
		logger.info("discountprice=" + discountprice);
		
		Set<Integer> idset = simpleinfo.keySet();
		for(Integer ii : idset){//������������Ʒ������
			totalnum += simpleinfo.get(ii);
		}
		
		result.put("totalprice", totalprice.toString());
		result.put("totalnum", new Integer(totalnum).toString());
		result.put("pointprice", pointprice.toString());
		result.put("discount", discount.toString()); //�ܴ��ۼ�
		result.put("adjustment", adjustment.toString());
		result.put("getpoint", getpoint.toString());
		result.put("shipcharge", shipcharge.toString());
		result.put("discountprice", discountprice.toString());
		return result;
	}
	public Map<String, String> calcOrder(List<ProductVO> productlist, Map<Integer, Integer> simpleinfo, Integer bonouspoint){
		Map<String, String> result = calcOrder(productlist, simpleinfo);
		
		BigDecimal discountprice_new = new BigDecimal(result.get("discountprice")).multiply(new BigDecimal(bonouspoint * 1.0));
		result.put("discountprice", discountprice_new.toString());
		
		return result;
	}
	
	public boolean buy(BuyDTO buyDTO, boolean isUseBonuspoint) {
		boolean flag = false;
		if(isUseBonuspoint == false){
			flag = buy(buyDTO);
			return flag;
		}
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			
			
			tran.commit();
			session.close();
		} catch (HibernateException e) {
			if(tran.isActive()){tran.rollback();}
			e.printStackTrace();
		} finally {
			if(session != null){session.close();}
		}
		return flag;
	}
	
	public boolean collect(Integer productid) {
		boolean flag = false;
		
		return flag;
	}
	
}
