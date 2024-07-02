package mil.yaye.yours.factory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {
	
	private Logger logger = Logger.getLogger(BeanFactory.class.getName());
	
	private static BeanFactory beanFactory = null;
	private Map<String, Object> beanMap = new HashMap<String, Object>();
	
	// Constructors
	@SuppressWarnings("unchecked")
	private BeanFactory(String path){
		try {
			Document document = new SAXReader().read(path+"/BeanContext.xml");
			Element root = document.getRootElement();
			List<Object> list = root.elements();
			Iterator<Object> iterator = list.iterator();
			while(iterator.hasNext()) {
				Element axe = (Element) iterator.next();
				String id = axe.attributeValue("id");
				String classpath = axe.attributeValue("class");
				Object object = Class.forName(classpath).newInstance();
				beanMap.put(id, object);
				logger.info(id + ":" + classpath + "已经成功加载！");
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static BeanFactory getInstance(String path){
		if(beanFactory == null) {beanFactory = new BeanFactory(path);}
		return beanFactory;
	}
	/*public static BeanFactory getInstance(){
		return beanFactory;
	}
	public static BeanFactory instance(){
		beanFactory = new BeanFactory();
		return beanFactory;
	}*/
	public Object getBean(String id){
		return beanMap.get(id);
	}
}
