package mil.yaye.yours.common;

import org.apache.log4j.Logger;
import org.apache.struts.actions.MappingDispatchAction;

public class BaseAction extends MappingDispatchAction {
	// 应该设为(default)更合适,这样严格一些
//	protected static Logger logger = Logger.getLogger(BaseAction.class.getName());
	public static Logger logger = Logger.getLogger(BaseAction.class.getName());
	
}
