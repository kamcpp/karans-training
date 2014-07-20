package contextManager.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Hashtable;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

import contextManager.BeanCreationException;
import contextManager.BeanDescription;
import contextManager.BeanFactory;
import contextManager.BeanNotFoundException;
import contextManager.ContextConfigurationException;
import contextManager.ContextConfigurationReader;
import contextManager.ContextManager;

public class DefaultContextManager implements ContextManager {
	private ContextConfigurationReader configReader;
	private BeanFactory beanFactory;

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	private Hashtable<String, BeanDescription> beans;
	private Map<String, Object> objectMap;

	public DefaultContextManager() {
		beans = new Hashtable<String, BeanDescription>();
		configReader = new InMemoryContextConfigReader();
		beanFactory = new DefaultBeanFactory();
	}

	@Override
	public void loadConfig(String path) throws ContextConfigurationException {
		for(BeanDescription bd:configReader.read(path) ){
			beans.put(bd.getId(), bd);
		}
		
	}

	public void setConfigReader(ContextConfigurationReader configReader) {
		this.configReader = configReader;
	}

	@Override
	public Object get(String id) throws BeanNotFoundException, BeanCreationException {
		// TODO Auto-generated method stub
		try {
			BeanDescription bean = beans.get(id);

			if ("singelton".equalsIgnoreCase(bean.getType())) {
				if (objectMap.get(id) != null)
					return objectMap.get(id);
				else {
					Object myobj = beanFactory.create(bean);
					objectMap.put(id, myobj);
					return myobj;
				}
			}
			else 
				return beanFactory.create(bean);
		} catch (NullPointerException e) {
			throw new BeanNotFoundException();
		}

	
	}
}
