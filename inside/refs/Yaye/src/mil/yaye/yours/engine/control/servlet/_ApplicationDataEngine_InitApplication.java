package mil.yaye.yours.engine.control.servlet;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mil.yaye.yours.common.GlobalNames;
import mil.yaye.yours.engine.service._InitEngine_InitViewDataService;
import mil.yaye.yours.engine.service._InitEngine_InitViewDataServiceImpl;
import mil.yaye.yours.vo.InitVO;

public class _ApplicationDataEngine_InitApplication extends HttpServlet {

	private static final long serialVersionUID = 1L;
	/**
	 * Initialization of the servlet. <br>
	 *init()方法是一个回调方法,所谓回调方法就是一个供系统调用的方法,所以我没有选择在service()方法中去调用这个方法
	 *而是写了一个和这个方法功能类似的方法reInit()供service()方法调用
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		super.init();
		InitServletContext();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response){
		reInit();
	}
	

	private void reInit(){
		InitServletContext();
	}
	
	private void InitServletContext(){
//		_InitEngine_InitViewDataService service = new _InitEngine_InitViewDataServiceImpl();
//		List<InitVO> list_new = service.searchNewProduct().subList(0, 9);
//		List<InitVO> list_hot = service.searchHotProduct().subList(0, 9);
//		List<InitVO> new_hot_list  = service.initIndex_New_Hot_Block();
//		getServletContext().setAttribute(GlobalNames.NEW_HOT_BLOCK, new_hot_list);
	}
}
