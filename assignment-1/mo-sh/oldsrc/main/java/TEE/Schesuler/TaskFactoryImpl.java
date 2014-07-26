package TEE.Schesuler;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TaskFactoryImpl implements TaskFactory {

	TaskConfigSource taskConfig;
	private List<Task> AllTasks;

	public TaskFactoryImpl() {
		AllTasks = new LinkedList<Task>();
	}

	public TaskFactoryImpl(XmlConfigSources taskConfig) {
		this.taskConfig = taskConfig;
		AllTasks = new LinkedList<Task>();
	}



	public TaskConfigSource getTaskConfig() {
		return taskConfig;
	}

	public void setTaskConfig(TaskConfigSource taskConfig) {
		this.taskConfig = taskConfig;
	}
	
	private Task createTask(Taskdescription tdes) {

		String clasName = tdes.getClassName();
		String basePackageName = tdes.getBasePackageName();
		String classPackageName = tdes.getClassPackageName();
		/*String execusionMethodName = tdes.getMethodName();
		String beforeMethodName = tdes.getBeforeMethod();
		String afterMethodName = tdes.getAfterMethod();
		
		SchedulTime taskrunTime = tdes.getTimeTorun();*/
	
		Task t = null;
		
		try {
			String taskId = tdes.getTaskId();
			Class c = Class.forName(basePackageName + "." +classPackageName + "." + clasName);
			
			/*Method executionMethod = c.getMethod(execusionMethodName, null);
			Method beforeMethod = c.getMethod(beforeMethodName, null);
			Method afterMethod = c.getMethod(afterMethodName, null);
			
			t.setExecutionMehod(executionMethod);
			t.setAfterMEthod(afterMethod);
			t.setBeforMethod(beforeMethod);
			t.setTaskId(taskId);
			t.setRuntime(taskrunTime);*/
			t = (Task) c.newInstance();
			t.setTaskId(taskId);
			t.setDependencies(tdes.getDependencies());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			e.printStackTrace();
		}  catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return t;

	}
	
	private void MakeAllTasks() {
		for (Taskdescription tdes : taskConfig.getTaskDescriptions()) {
			AllTasks.add(createTask(tdes));
		}
	}	

		/*for (Taskdescription tdes : taskConfig.getTaskDescriptions()) {
			if (tdes.hasDependencies()) {
				for (String dependentTaskId : tdes.getDependencies()) {
					lookupAndAddDependency(tdes.getTaskId(), dependentTaskId);
				}
			}
		}

	}

	private void lookupAndAddDependency(String taskid, String depeString) {
		List<Task> dependentTasks = new LinkedList<Task>();
		Task originTask = null;
		for (Task t : AllTasks) {
			if (t.getTaskId().equalsIgnoreCase(taskid)) {
				originTask = t;
			}

		}
		for (Task t : AllTasks) {
			if (t.getTaskId().equalsIgnoreCase(depeString)) {
				dependentTasks.add(t);
			}
			originTask.setDependencies(dependentTasks);

		}
	}*/

	public List<Task> getAllTasks() {
		MakeAllTasks();
		return AllTasks;
	}


}
