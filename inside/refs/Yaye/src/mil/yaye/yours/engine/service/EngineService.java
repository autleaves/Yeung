package mil.yaye.yours.engine.service;

import javax.servlet.ServletContext;

public interface EngineService {

	public abstract void startup(ServletContext context);

	public abstract void destroy();
	
	/**�ֶ���������**/
	public abstract void manual(ServletContext context);
	
	/**���Ϸ�ʽ��������ʱ���ǽ���ȫ���ĸ���,����������ҵ���վ�����˶���,��ô�ƺ��Ͳ��ڱ�Ҫ��һЩ�¾ɵ�ҳ�����
	 * ���и���,������,����ҵ���վ�Ƚϴ�,��ô�Ҿ�Ӧ�ÿ��ǿ��Խ������ĳһ��ʱ���ҳ����и���.
	 * �����Խ������ĳһ������ҳ����и���,�����Ÿ���
	 * **/
}