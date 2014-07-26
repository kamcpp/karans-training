package com.mycompany.app.oldtasks.natives;

import java.util.List;

import TEE.Scheduler.unused.Task;

public class FourthTaskClass{

	private List<String> dependencies;
	private String taskId;


	public String getTaskId() {
		return taskId;
	}

	public Object run(Object o) {
		return "running task 4";
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


}
