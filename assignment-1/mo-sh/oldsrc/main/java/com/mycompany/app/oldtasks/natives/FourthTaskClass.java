package com.mycompany.app.oldtasks.natives;

import java.util.List;

import TEE.Schesuler.Task;

public class FourthTaskClass implements Task{

	private List<String> dependencies;
	private String taskId;


	public String getTaskId() {
		return taskId;
	}

	public Object run(Object o) {
		return "I am the forthclass exceution(run) method";
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

	public Object execute(Object o) {
		return run(o);
	}


}
