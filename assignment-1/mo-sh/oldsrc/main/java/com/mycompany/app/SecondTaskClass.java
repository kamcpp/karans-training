package com.mycompany.app;

import java.util.List;

import TEE.Schesuler.Task;

public class SecondTaskClass implements Task {
	
	private List<String> dependencies;
	private String taskId;

	// TODO the methods should not have the returntype Method

	public String getTaskId() {
		return taskId;
	}

	public Object execute(Object o) {
		return "I am the secondclass exceution(execute) method";
	}

	public List<String> getDependencies() {
		return dependencies;
	}

	public Boolean hasDependencies() {
		return !dependencies.isEmpty();
	}

	public String beforeMethod() {
		return "I am the secondclass before method";
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;

	}


	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}

	


}

