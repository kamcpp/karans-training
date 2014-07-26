package com.mycompany.app;

import java.util.List;

import TEE.Scheduler.unused.Task;

public class FifthTaskClass{
	private List<String> dependencies;
	private String taskId;

	public String getTaskId() {
		return taskId;
	}

	public Object run(Object o) {
		return "Irunning task 5";
	}


	public Boolean hasDependencies() {
		return !dependencies.isEmpty();
	}

	public String beforeRun() {
		return  "beorerun in taks 5";
	}

	public String afterRun() {
		return "afterrun in taks 5";
	}


	public void setTaskId(String taskId) {
		this.taskId = taskId;

	}


	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}

	public List<String> getDependencies() {
		return dependencies;
	}


}

