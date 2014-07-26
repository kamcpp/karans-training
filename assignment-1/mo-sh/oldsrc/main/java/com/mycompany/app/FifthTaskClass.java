package com.mycompany.app;

import java.util.List;

import TEE.Schesuler.Task;

public class FifthTaskClass implements Task {
	private List<String> dependencies;
	private String taskId;



	public String getTaskId() {
		return taskId;
	}

	public Object run(Object o) {
		return "I am the fifth exceution(run) method";
	}


	public Boolean hasDependencies() {
		return !dependencies.isEmpty();
	}

	public String beforeMethod() {
		return "I am the fifth before method";
	}

	public String afterMethod() {
		return "I am the fifth after method";
	}


	public void setTaskId(String taskId) {
		this.taskId = taskId;

	}


	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}

	public Object execute(Object o) {
		return run(o);
	}

	public List<String> getDependencies() {
		return dependencies;
	}


}

