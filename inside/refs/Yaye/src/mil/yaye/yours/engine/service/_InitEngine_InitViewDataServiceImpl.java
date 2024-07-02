package mil.yaye.yours.engine.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;

import mil.yaye.yours.common.GlobalNames;
import mil.yaye.yours.factory.BeanFactory;
import mil.yaye.yours.factory.HibernateSessionFactory;
import mil.yaye.yours.vo.InitVO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class _InitEngine_InitViewDataServiceImpl implements _InitEngine_InitViewDataService {
	
	private int totalNum = 30;
	private BeanFactory beanFactory = null;
//	private xxxxxxDAO dao = null;
	private String id_DAO = null;
	
	private ServletContext context = null;
	
	public void setDAO(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
		id_DAO = "";
//		dao = beanFactory.getBean(id_DAO);
	}
	
	public void startup(ServletContext context) {
		this.context = context;
		initIndex_New_Hot_Block();
	}
/********************************************初始化首页数据*****开始***************************************************/
	
  /***开始***随机获取totalNum个new+hot+new_hot个产品的ID及thumbnail*****把这些图片放置到首页的一个表格中*********************/
	/* (non-Javadoc)
	 * @see mil.yaye.yours.engine.service._InitEngine_InitViewDataService#initIndex_New_Hot_Block()
	 */
	public void initIndex_New_Hot_Block(){
		List<InitVO> list = new ArrayList<InitVO>();
		List<InitVO> list_new = searchNewProduct();
		List<InitVO> list_hot = searchHotProduct();
		List<InitVO> list_new_hot = new ArrayList<InitVO>();
		if(list_hot != null){
			boolean noEqual = Collections.disjoint(list_new, list_hot);
			if(noEqual == false){ //当有相同元素时,When has equal!
				list_new_hot = searchNewHotProduct(list_new, list_hot);
				completeEnd(list, list_new_hot,list_new,list_hot);
			}else{
				completeEnd(list, list_new, list_hot);
			}
		}else{
			list = list_new;
		}
		context.setAttribute(GlobalNames.NEW_HOT_BLOCK, list);
	}
	
	/* (non-Javadoc)
	 * @see mil.yaye.yours.engine.service._InitEngine_InitViewDataService#searchNewProduct()
	 */
	public List<InitVO> searchNewProduct(){
		List<InitVO> list = new ArrayList<InitVO>();
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			//先根据加入产品的时间按降序排序,再从中选出1-xx条记录,xx从GlobalNames中获取
			String hql = "SELECT tab.productId, tab.thumbnail FROM Product as tab order by tab.jointime DESC limit(0,30)";
			Query query = session.createQuery(hql);
			//或者这样进行数量限制
			/*query.setFirstResult(0);
			query.setMaxResults(20);*/
			Iterator<?> iteratorTemp = query.list().iterator();
			Object[] obj = null;
			InitVO initVO = null;
			while(iteratorTemp.hasNext()){
				obj = (Object[]) iteratorTemp.next();
				initVO = new InitVO();
				initVO.setKey((String)obj[0]);
				initVO.setValue(obj[1]);
				list.add(initVO);
			}
			transaction.commit();
		} catch (HibernateException e) {
			if(transaction != null){transaction.rollback();}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.engine.service._InitEngine_InitViewDataService#searchHotProduct()
	 */
	public List<InitVO> searchHotProduct(){
		List<InitVO> list = new ArrayList<InitVO>();
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String hql = "SELECT tab.Product.productId, tab.thumbnail FROM Orderitem as tab order by tab.Product.jointime DESC limit(0,30)";
			Query query = session.createQuery(hql);
			Iterator<?> iteratorTemp = query.list().iterator();
			Object[] obj = null;
			InitVO initVO = null;
			while(iteratorTemp.hasNext()){
				obj = (Object[]) iteratorTemp.next();
				initVO = new InitVO();
				initVO.setKey((String)obj[0]);
				initVO.setValue(obj[1]);
				list.add(initVO);
			}
			transaction.commit();
		} catch (HibernateException e) {
			if(transaction != null){transaction.rollback();}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	
	/**
	 * 在这个方法中在从list_new和list_hot中选出既new又hot的选项的同时,把list_new和list_hot原有的选项就都remove了
	 * @param list_new
	 * @param list_hot
	 * @return
	 */
	private List<InitVO> searchNewHotProduct(List<InitVO> list_new, List<InitVO> list_hot){
		List<InitVO> list = new ArrayList<InitVO>();
		
		Iterator<InitVO> iter_new = list_new.iterator();
		Iterator<InitVO> iter_hot = list_hot.iterator();
		for(int i = 0; iter_new.hasNext(); i++){
			InitVO ini = (InitVO)iter_new.next();
			for(int j = 0; iter_hot.hasNext(); j++){
				InitVO ini2 = (InitVO)iter_hot.next();
				if(ini2.equals(ini)){ //或if(list_new.contains(ini2))
					list.add(ini2);
					list_new.remove(ini); //或list_new.remove(i);
					list_hot.remove(ini2); //或list_hot.remove(j);
				}
			}
		}
		return list;
	}
	
	private void completeEnd(List<InitVO> list, List<InitVO> list_new, List<InitVO> list_hot){
		modifyPath(list_new, list_hot);
		int[] resultMode = new int[2];
		resultMode = randResultMode(list_new.size(), list_hot.size());
		getListResult(resultMode, list, list_new, list_hot);
	}
	private void completeEnd(List<InitVO> list, List<InitVO> list_new, List<InitVO> list_hot, List<InitVO> list_new_hot){
		modifyPath(list_new, list_hot, list_new_hot);
		int[] resultMode = new int[3];
		resultMode = randResultMode(list_new.size(), list_hot.size(), list_new_hot.size());
		getListResult(resultMode, list, list_new, list_hot, list_new_hot);
	}
	private void modifyPath(List<InitVO> list_new, List<InitVO> list_hot){
		//改变new图片路径
		for(Iterator<InitVO> iter = list_new.iterator();iter.hasNext();){
			InitVO ini = iter.next();
			int index_ini = list_new.indexOf(ini);
			String thumbnail = (String) ini.getValue();
			String thumbnail_suf = thumbnail.substring(thumbnail.lastIndexOf(".")); //thumbnail_suf里包含有"."
			String appendStr = "_New";
			String thumbnail_New_Hot_path = thumbnail.substring(0, thumbnail.lastIndexOf(".")) + appendStr + thumbnail_suf;
			
			ini.setValue(thumbnail_New_Hot_path);
			list_hot.set(index_ini, ini);
		}
		//改变Hot图片路径
		for(Iterator<InitVO> iter = list_hot.iterator();iter.hasNext();){
			InitVO ini = iter.next();
			int index_ini = list_new.indexOf(ini);
			String thumbnail = (String) ini.getValue();
			String thumbnail_suf = thumbnail.substring(thumbnail.lastIndexOf(".")); //thumbnail_suf里包含有"."
			String appendStr = "_Hot";
			String thumbnail_New_Hot_path = thumbnail.substring(0, thumbnail.lastIndexOf(".")) + appendStr + thumbnail_suf;
			
			ini.setValue(thumbnail_New_Hot_path);
			list_hot.set(index_ini, ini);
		}
	}
	private void modifyPath(List<InitVO> list_new, List<InitVO> list_hot, List<InitVO> list_new_hot){
		modifyPath(list_new, list_hot); //改变new和hot的图片路径
		//改变New_Hot图片路径
		for(Iterator<InitVO> iter_new_hot = list_new_hot.iterator();iter_new_hot.hasNext();){
			InitVO ini = iter_new_hot.next();
			int index_ini = list_new.indexOf(ini);
			String thumbnail = (String) ini.getValue();
			String thumbnail_suf = thumbnail.substring(thumbnail.lastIndexOf(".")); //thumbnail_suf里包含有"."
			String appendStr = "_New_Hot";
			String thumbnail_New_Hot_path = thumbnail.substring(0, thumbnail.lastIndexOf(".")) + appendStr + thumbnail_suf;
			
			ini.setValue(thumbnail_New_Hot_path);
			list_hot.set(index_ini, ini);
		}
	}
	private void getListResult(int[] resultMode, List<InitVO> list, List<InitVO> list_new, List<InitVO> list_hot){
		Iterator<InitVO> iter_new = list_new.iterator();
		Iterator<InitVO> iter_hot = list_hot.iterator();
		for(int i = 0; i < resultMode[0]; i++){
			InitVO initVO = (InitVO) iter_new.next();
			list.add(initVO);
		}
		for(int i = 0; i < resultMode[1]; i++){
			InitVO initVO = (InitVO) iter_hot.next();
			list.add(initVO);
		}
	}
	private void getListResult(int[] resultMode, List<InitVO> list, List<InitVO> list_new, List<InitVO> list_hot, List<InitVO> list_new_hot){
		getListResult(resultMode, list, list_new, list_hot);
		Iterator<InitVO> iter_new_hot = list_new_hot.iterator();
		for(int i = 0; i < resultMode[2]; i++){
			InitVO initVO = (InitVO) iter_new_hot.next();
			list.add(initVO);
		}
	}
	private int[] randResultMode(int num_new, int num_hot){
//		int[][] resultCollect = new int[(nums[1]+1)*2][];
		List<VO1> templist = new ArrayList<VO1>();
		int[] result = new int[2];
		for(int i = 0; i < num_hot; i++){
			for(int j = num_new; j > 0; j--){
				if(i + j == totalNum){
					VO1 vo = new VO1();
					vo.setValue1(i);
					vo.setValue2(j);
					templist.add(vo);
				}
			}
		}
		VO1 tempResult = templist.get(new Random().nextInt(templist.size()));
		result[0] = tempResult.getValue1(); 
		result[1] = tempResult.getValue2(); 
		
		return result;
	}
	private int[] randResultMode(int num_new, int num_hot, int num_new_hot){
		List<VO2> templist = new ArrayList<VO2>();
		int[] result = new int[3];
		for(int i = 0; i < num_hot; i++){
			for(int j = num_new; j > 0; j--){
				if(i + j == totalNum - num_new_hot){
					VO2 vo = new VO2();
					vo.setValue1(i);
					vo.setValue2(j);
					vo.setValue3(num_new_hot);
					templist.add(vo);
				}
			}
		}
		VO2 tempResult = templist.get(new Random().nextInt(templist.size()));
		result[0] = tempResult.getValue1();
		result[1] = tempResult.getValue2();
		result[2] = tempResult.getValue3();
		return result;
		//实际上为了更精确的控制循环次数,就应该考虑下面的情况
		// num_new=30
		// num_hot<=30
		// num_new_hot<=30
		// tempSum = 30 - new_hot;
		// sum=30
		//if(num_hot > tempSum) if(num_hot < tempSum)
	}
  /***结束***随机获取totalNum个new+hot+new_hot个产品的ID及thumbnail**************************/
	
  /* (non-Javadoc)
 * @see mil.yaye.yours.engine.service._InitEngine_InitViewDataService#initNav()
 */
	public List<?> initNav(){
		List<InitCategoryVO> templist = readCategory();
		List<InitVO> list = new ArrayList<InitVO>();
		
		return list;
	}
	private List<InitCategoryVO> readCategory(){
		List<InitCategoryVO> list = new ArrayList<InitCategoryVO>();
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String hql = "SELECT new InitCategoryVO(tab.categoryId,tab.categoryname,tab.istop,tab.categoryIdParent) " +
					" FROM Category AS tab WHERE tab.markfordelete = 0";
			Iterator<?> iter = session.createQuery(hql).list().iterator();
			while(iter.hasNext()){
				InitCategoryVO initVO = (InitCategoryVO) iter.next();
				list.add(initVO);
			}
			transaction.commit();
		} catch (HibernateException e) {
			if(transaction != null) {transaction.rollback();}
			e.printStackTrace();
		} finally{
			session.close();
		}
		return list;
	}
  /**结束*****读取并编排导航********************************************************/
/******************************************初始化首页数据***结束********************************************************/


}
class VO1 {
	private int value1;
	private int value2;
	public int getValue1() {
		return value1;
	}
	public void setValue1(int value1) {
		this.value1 = value1;
	}
	public int getValue2() {
		return value2;
	}
	public void setValue2(int value2) {
		this.value2 = value2;
	}
}
class VO2{
	private int value1;
	private int value2;
	private int value3;
	public int getValue1() {
		return value1;
	}
	public void setValue1(int value1) {
		this.value1 = value1;
	}
	public int getValue2() {
		return value2;
	}
	public void setValue2(int value2) {
		this.value2 = value2;
	}
	public int getValue3() {
		return value3;
	}
	public void setValue3(int value3) {
		this.value3 = value3;
	}
}

class InitCategoryVO{
	private Integer categoryId;
	private String categoryname;
	private Integer istop;
	private Integer categoryIdParent;
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public Integer getIstop() {
		return istop;
	}
	public void setIstop(Integer istop) {
		this.istop = istop;
	}
	public Integer getCategoryIdParent() {
		return categoryIdParent;
	}
	public void setCategoryIdParent(Integer categoryIdParent) {
		this.categoryIdParent = categoryIdParent;
	}
	
}