package com.mycompany.app;

import java.lang.reflect.Method;
import java.util.List;

import TEE.Schesuler.SchedulTime;
import TEE.Schesuler.Task;

public class FirstTaskClass implements Task {

	private List<String> dependencies;
	private String taskId;


	public String getTaskId() {
		return taskId;
	}

	public Object run(Object o) {
		return "I am the firstclass exceution(run) method";
	}

	public Boolean hasDependencies() {
		return !dependencies.isEmpty();
	}

	public String beforeMethod() {
		return "I am the firstclass before method";
	}

	public String afterMethod() {
		return "I am the firstclass after method";
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

	public Object execute(Object o) {
		return run(o);
	}


}
