package mil.yaye.yours.pojo.value;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class OrderStatus implements Serializable {

	private final Character status;
	private final transient String description;
	
	public Character getStatus(){
		return status;
	}
	public String getDescription() {
		return description;
	}
	
	private static final Map instances = new HashMap();
	
	private OrderStatus(Character status, String description){
		this.status = status;
		this.description = description;
		instances.put(status, this);
	}
	
	public static final OrderStatus STATUS_A = new OrderStatus('A', "xx");
	public static final OrderStatus STATUS_B = new OrderStatus('B', "xx");
	public static final OrderStatus STATUS_C = new OrderStatus('C', "xx");
	public static final OrderStatus STATUS_D = new OrderStatus('D', "xx");
	
	public static Collection getAllValues(){
		return Collections.unmodifiableCollection(instances.values());
	}
	
	public static OrderStatus getInstance(Character status){
		OrderStatus result = (OrderStatus) instances.get(status);
		if(result == null){
			throw new NoSuchElementException(status.toString());
		}
		return result;
	}
	
	public String toString(){
		return description;
	}
	
	/**
	 * 保证反序列化时直接返回OrderStatus2类包含的静态实例
	 * @return
	 */
	private Object readResolve(){
		return getInstance(status);
	}
	
}
