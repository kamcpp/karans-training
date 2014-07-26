package com.mycompany.app;

import java.util.List;

import TEE.Schesuler.Task;

public class ThirdTaskClass implements Task{

	private List<String> dependencies;
	private String taskId;

	// TODO the methods should not have the returntype Method

	public String getTaskId() {
		return taskId;
	}

	public Object perform(Object o) {
		return "I am the thirdclass exceution(perform) method";
	}

	public List<String> getDependencies() {
		return dependencies;
	}

	public Boolean hasDependencies() {
		return !dependencies.isEmpty();
	}

	public String afterMethod() {
		return "I am the thirdclass after method";
	}


	public void setTaskId(String taskId) {
		this.taskId = taskId;

	}


	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}

	public Object execute(Object o) {
		return perform(o);
	}


}
