package mil.yaye.yours.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import mil.yaye.yours.factory.HibernateSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public final class TransactionWrapper {
	
	/**
	 * װ��ԭʼ��ҵ�������󣬷���һ����ҵ������������ͬ�ӿڵĴ������ 
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
	 * ��̬������
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
		 * ���������װҵ�����������е�ҵ�񷽷� 
		 */
		public Object invoke(Object proxy, Method method, Object[] args) {
			Object result = null;
			try {
				session = HibernateSessionFactory.getSession();
				transaction = session.beginTransaction();	//��ʼһ������
				if(method.getName() == "setSession"){
					
				}
				result = method.invoke(delegate, args);	//����ԭʼҵ������ҵ�񷽷� 
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
