package com.mycompany.app;

import java.lang.reflect.Method;
import java.util.List;

import TEE.Scheduler.unused.Task;
import TEE.Schesuler.SchedulTime;

public class FirstTaskClass  {

	private List<String> dependencies;
	private String taskId;


	public String getTaskId() {
		return taskId;
	}

	public Object run(Object o) {
		return "runnin task 1";
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

	public List<String> getDependencies() {
		return dependencies;
	}
	


}
