package com.mycompany.app;

import java.util.List;

import TEE.Scheduler.unused.Task;

public class SecondTaskClass {
	
	private List<String> dependencies;
	private String taskId;

	// TODO the methods should not have the returntype Method

	public String getTaskId() {
		return taskId;
	}

	public Object execute(Object o) {
		return "running task 2";
	}

	public List<String> getDependencies() {
		return dependencies;
	}

	public Boolean hasDependencies() {
		return !dependencies.isEmpty();
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;

	}

	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}


	public String beforeExecute(){
		return "task 2 before method";
	}
	


}

