package mil.yaye.yours.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import mil.yaye.yours.factory.HibernateSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public final class TransactionWrapper {
	
	/**
	 * 装饰原始的业务代表对象，返回一个与业务代表对象有相同接口的代理对象 
	 * @param delegate
	 * @return
	 */
	public static Object bind(Object delegate){
		
		return Proxy.newProxyInstance(
				delegate.getClass().getClassLoader(),
				delegate.getClass().getInterfaces(), 
				new XAWrapperHandler(delegate)
				);
	}
	/**
	 * 动态代理技术
	 * @author Yaye
	 */
	static final class XAWrapperHandler implements InvocationHandler {
		private final Object delegate;
		private Session session = null; 
		private Transaction transaction = null;
		
		XAWrapperHandler(Object delegate) {
			this.delegate = delegate;
		}
		/**
		 * 简单起见，包装业务代表对象所有的业务方法 
		 */
		public Object invoke(Object proxy, Method method, Object[] args) {
			Object result = null;
			try {
				session = HibernateSessionFactory.getSession();
				transaction = session.beginTransaction();	//开始一个事务
				if(method.getName() == "setSession"){
					
				}
				result = method.invoke(delegate, args);	//调用原始业务对象的业务方法 
				session.flush();
				transaction.commit();
			} catch (Throwable e) {
				if(transaction != null) {transaction.rollback();}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return result;
		}
	}
}
