package contextManager.imp;

import java.util.ArrayList;
import java.util.List;

import contextManager.BeanDescription;
import contextManager.ContextConfigurationReader;

public class InMemoryContextConfigReader implements ContextConfigurationReader {

	@Override
	public List<BeanDescription> read(String path) {
		List<BeanDescription> lst=new ArrayList<BeanDescription>();
		BeanDescription myBean=new BeanDescription();
		myBean.setClassName("java.lang.Integer");
		myBean.setId("myNumber");
		myBean.setType("singelton");
		
		lst.add(myBean);
		myBean=new BeanDescription();
		myBean.setClassName("java.lang.String");
		myBean.setId("myString");
		myBean.setType("new");
		lst.add(myBean);
		return lst;
	}

}
