package com.mycompany.app;

import java.util.List;

import TEE.Scheduler.unused.Task;

public class SixthTaskClass{

	private List<String> dependencies;
	private String taskId;


	public String getTaskId() {
		return taskId;
	}

	public Object start(Object o) {
		return "running task 6";
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
	
	public String beforeStart() {
		return "task 6 before";
	}
	public String afterStart() {
		return "task 6 after";
	}


}
