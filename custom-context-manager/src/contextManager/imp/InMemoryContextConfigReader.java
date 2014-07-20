package contextManager.imp;

import java.util.ArrayList;
import java.util.List;

import contextManager.BeanDescription;
import contextManager.ContextConfigurationReader;

public class InMemoryContextConfigReader implements ContextConfigurationReader {

	@Override
	public List<BeanDescription> read(String path) {
		// TODO Auto-generated method stub
		List<BeanDescription> lst=new ArrayList<BeanDescription>();
		BeanDescription myBean=new BeanDescription();
		myBean.setClassName("firstClass");
		myBean.setId("1");
		myBean.setType("type1");
		
		lst.add(myBean);
		myBean=new BeanDescription();
		myBean.setClassName("secondClass");
		myBean.setId("2");
		myBean.setType("type2");
		lst.add(myBean);
		return lst;
	}

}
