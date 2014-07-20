package contextManager;

import java.util.Hashtable;
import java.util.Map;

import contextManager.imp.DefaultBeanFactory;
import contextManager.imp.InMemoryContextConfigReader;

public interface ContextManager {
	public void loadConfig(String path) throws ContextConfigurationException;

	public Object get(String id) throws BeanNotFoundException,
			BeanCreationException;

	public void setBeanFactory(BeanFactory beanFactory);

	public void setConfigReader(ContextConfigurationReader configReader);
}
