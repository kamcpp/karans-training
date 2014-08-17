package rpc.serverside;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {

private static Map<String,Object> beanMap; 

static{
	beanMap = new HashMap<String, Object>();
	beanMap.put("MyBean", new MyBeanImpl() );
}
	
	public Object createBean(String interfaceName){
		return beanMap.get(interfaceName);
	
	}
}
