package contextManager.imp;

import contextManager.BeanCreationException;
import contextManager.BeanDescription;
import contextManager.BeanFactory;

public class DefaultBeanFactory implements BeanFactory {

	@Override
	public Object create(BeanDescription beanDesc) throws BeanCreationException {

		try {
			Class c = Class.forName(beanDesc.getClassName());
		
			return c.newInstance();

		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			throw new BeanCreationException(e);
		}
	}

}
