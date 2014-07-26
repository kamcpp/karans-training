package com.mycompany.app;

import java.util.List;

import TEE.Schesuler.Task;

public class SixthTaskClass implements Task{

	private List<String> dependencies;
	private String taskId;

	// TODO the methods should not have the returntype Method

	public String getTaskId() {
		return taskId;
	}

	public Object start(Object o) {
		return "I am the sixth exceution(start) method";
	}

	public List<String> getDependencies() {
		return dependencies;
	}

	public Boolean hasDependencies() {
		return !dependencies.isEmpty();
	}

	public String beforeMethod() {
		return "I am the sixth before method";
	}

	public String afterMethod() {
		return "I am the sixth after method";
	}


	public void setTaskId(String taskId) {
		this.taskId = taskId;

	}


	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}

	public Object execute(Object o) {
		return start(o);
	}


}
