package mil.yaye.yours.service;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import mil.yaye.yours.factory.BeanFactory;
import mil.yaye.yours.model.ormDAO.ProductDAO;
import mil.yaye.yours.util.PaginateDTO;
import mil.yaye.yours.vo.InitVO;
import mil.yaye.yours.vo.ProductVO;

/**
 * 
 * @author Yaye
 *	向导中心
 */

public interface GuideService {

	public abstract void setDAO(BeanFactory daoFactory);
	
	public abstract List<ProductVO> categoryGuide(DetachedCriteria criteria);
	
	public abstract Map<String, Object> categoryGuide(Integer categoryId, PaginateDTO paginateDTO);

	public abstract void categoryBrandsGuide();

	public abstract void brandsGuide();

	public abstract void searchProduct(Integer id);

	public abstract int getTotalRecordByForeignKey(ProductDAO product_dao,Integer categoryId);
	
	public abstract ProductVO productDetailGuide(Integer id);
	
	public abstract ProductVO productGuide(Integer id);
	
	public abstract Map<Integer, InitVO> getLocations(Integer category_id_parent);

	public abstract void proxoolcheck();
}