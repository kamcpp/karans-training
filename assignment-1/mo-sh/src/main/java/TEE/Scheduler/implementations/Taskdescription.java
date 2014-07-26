package TEE.Scheduler.implementations;

import java.util.List;

public class Taskdescription{
	private String basePackageName;
	private String classPackageName;
	private String className;
	private String methodName;
	private String beforeMethod;
	private String afterMethod;
	private List<String> dependencies;
	String taskId;
	
	
	public String getBasePackageName() {
		return basePackageName;
	}
	public void setBasePackageName(String basePackageName) {
		this.basePackageName = basePackageName;
	}
	
	public String getClassPackageName() {
		return classPackageName;
	}
	public void setClassPackageName(String classPackageName) {
		this.classPackageName = classPackageName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getBeforeMethod() {
		return beforeMethod;
	}
	public void setBeforeMethod(String beforeMethod) {
		this.beforeMethod = beforeMethod;
	}
	public String getAfterMethod() {
		return afterMethod;
	}
	public void setAfterMethod(String afterMethod) {
		this.afterMethod = afterMethod;
	}
	public List<String> getDependencies() {
		return dependencies;
	}
	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}
	
	public String getTaskId() {
		return taskId;
	}
	
	public boolean hasDependencies() {
		return !dependencies.isEmpty();
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
	

	 
	
	
	 
}
