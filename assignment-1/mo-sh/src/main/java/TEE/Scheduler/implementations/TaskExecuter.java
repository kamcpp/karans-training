package TEE.Scheduler.implementations;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;

public class TaskExecuter extends TimerTask {

	List<Taskdescription> tasks;
	
	public List<Taskdescription> getTasks() {
		return tasks;
	}
	public void setTasks(List<Taskdescription> tasks) {
		this.tasks = tasks;
	}
	public TaskExecuter() {
		tasks = new LinkedList<Taskdescription>();
		
	}
	public TaskExecuter(List<Taskdescription> tasks) {
		this.tasks=tasks;
		
		
	}

	public void run() {
		try {

			String fullClassPath = "";

			for (Taskdescription td : tasks) {
				if (td.hasDependencies()) {

					runTaskDependencies(td, tasks);

				} else {
					if (td.getClassPackageName() == null
							|| td.getClassPackageName().isEmpty()) {
						fullClassPath = td.getBasePackageName() + '.'
								+ td.getClassName();
					} else {
						fullClassPath = td.getBasePackageName() + '.'
								+ td.getClassPackageName() + '.'
								+ td.getClassName();

					}

					System.out.println(td.getTaskId() + " has no dependencies");
					if (td.getBeforeMethod() != null
							&& !td.getBeforeMethod().isEmpty()) {
						System.out.println(invokeMethod(fullClassPath,
								td.getBeforeMethod(), null).toString());

					}

					System.out.println(invokeMethod(fullClassPath,
							td.getMethodName(), new Object()).toString());

					if (td.getAfterMethod() != null
							&& !td.getAfterMethod().isEmpty()) {
						System.out.println(invokeMethod(fullClassPath,
								td.getAfterMethod(), null).toString());

					}
				}

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}
	private void runTaskDependencies(Taskdescription td,
			List<Taskdescription> allTasks) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {

		for (String taskid : td.getDependencies()) {
			for (Taskdescription task : allTasks) {
				if (task.getTaskId().equalsIgnoreCase(taskid)) {
					System.out.println("calling "+  td.getTaskId() + "  ");
					System.out.println(td.getTaskId() + " is dependent on "
							+ taskid);
					System.out.println("I am calling " + task.getTaskId());

					if (task.hasDependencies()) {
						runTaskDependencies(task, allTasks);

					} else {

						String path= fullPath(task);
						// calling beforemethod
						if (task.getBeforeMethod() != null
								&& !task.getBeforeMethod().isEmpty()) {
							System.out.println(invokeMethod(path,
									task.getBeforeMethod(), null).toString());

						}
						// calling run method
				
						System.out.println(invokeMethod(path,
								task.getMethodName(), new Object()));
						
						// calling after method
						if (task.getAfterMethod() != null
								&& !task.getAfterMethod().isEmpty()) {
							System.out.println(invokeMethod(path,
									task.getAfterMethod(), null).toString());
						}
					}
				}
			}
		}
		String path = fullPath(td);
		if (td.getBeforeMethod() != null && !td.getBeforeMethod().isEmpty()) {
			System.out.println(invokeMethod(path,
					td.getBeforeMethod(), null).toString());
		}
		System.out.println(invokeMethod(path, td.getMethodName(),
				new Object()).toString());
		if (td.getAfterMethod() != null && !td.getAfterMethod().isEmpty()) {
			System.out.println(invokeMethod(path, td.getAfterMethod(),
					null).toString());

		}
	}
	
	private String fullPath( Taskdescription task){
		String fullClassPath ="";
		if (task.getClassPackageName() == null
				|| task.getClassPackageName().isEmpty()) {
			fullClassPath = task.getBasePackageName() + '.'
					+ task.getClassName();
			return fullClassPath;
		} else {
			fullClassPath = task.getBasePackageName() + '.'
					+ task.getClassPackageName() + '.'
					+ task.getClassName();
			return fullClassPath;

		}
	}
	public Object invokeMethod(String fullClassPath, String methodName,
			Object methodParameter) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {
		Class c = Class.forName(fullClassPath);
		Object actualTask = c.newInstance();
		if (methodParameter != null) {
			Class<?> params[] = new Class[1];
			params[0] = methodParameter.getClass();

			Method m = c.getMethod(methodName, new Class[] { Object.class });
			return m.invoke(actualTask, params);
		} else {
			Method m = c.getMethod(methodName, null);
			return m.invoke(actualTask, null);
		}
		
	}
	

	
	

}