package TEE.Schesuler;

import java.lang.reflect.Method;
import java.util.List;

public interface Task {
	
	public String getTaskId();
	public Object execute(Object o);
	//public Method getExecutionMehod();
	public List<String> getDependencies();
	public Boolean hasDependencies();
	//public Method getBeforeMethod();
	//public Method getAfterMethod();
	//public SchedulTime getRuntime();


	public void setTaskId(String taskId);
	//public void setExecutionMehod(Method execusionMethod);
	public void setDependencies(List<String> dependencies);
	//public void setBeforMethod(Method beforeMethod);
	//public void setAfterMEthod(Method afterMEthod);
	//public void setRuntime(SchedulTime runTime);

	
	
	

}
