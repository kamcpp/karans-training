package tee.beans;

import java.util.ArrayList;
import java.util.List;

import tee.exceptions.TaskEntryNotValidException;
import tee.exceptions.taskClassNameNotDefinedException;
import tee.exceptions.taskIdNotDefinedException;
import tee.exceptions.taskRunMethodNotDefinedException;

public class TaskEntry {
	private String id;
	private String className;
	private String basePackage;
	private String runMethod;
	private String beforeMethod;
	private String afterMethod;
	private List<String> dependsOn;

	public TaskEntry() {
		dependsOn = new ArrayList<String>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getRunMethod() {
		return runMethod;
	}

	public void setRunMethod(String runMethod) {
		this.runMethod = runMethod;
	}

	public String getBeforeMethod() {
		return beforeMethod;
	}

	public void setBeforeMethod(String beforeMethod) {
		this.beforeMethod = beforeMethod;
	}

	public String getAfterMethod() {
		return afterMethod;
	}

	public void setAfterMethod(String afterMethod) {
		this.afterMethod = afterMethod;
	}

	public List<String> getDependsOn() {
		return dependsOn;
	}

	public void setDependsOn(List<String> dependsOn) {
		this.dependsOn = dependsOn;
	}

	public void addDependsOn(String name) {
		this.dependsOn.add(name);
	}

	public String getFullClassName() {
		if (this.getBasePackage() != null)
			return this.getBasePackage() + "." + this.getClassName();
		else
			return this.getClassName();
	}

	public boolean validate() throws TaskEntryNotValidException {
		// TODO: implement validation
		try {
			if (this.getId() == null)
				throw new taskIdNotDefinedException();
			if (this.getClassName() == null)
				throw new taskClassNameNotDefinedException();
			if (this.getRunMethod() == null)
				throw new taskRunMethodNotDefinedException();
		} catch (Exception e) {
			throw new TaskEntryNotValidException(e);
		}
		return true;
	}
}
