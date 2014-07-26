package TEE.Schesuler;

import java.lang.reflect.InvocationTargetException;
import java.security.AllPermission;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TaskManagerImpl implements TaskManager {

	private TaskConfigSource taskConf;
	private TaskFactoryImpl taskFactory;

	// private List<Task> tasks;

	public TaskManagerImpl() {
		taskConf = new XmlConfigSources();
		taskFactory = new TaskFactoryImpl();
	}

	public TaskManagerImpl(TaskConfigSource config) {
		this.taskConf = config;

	}

	/*
	 * public List<Task> getTasks() { return tasks; }
	 * 
	 * public void setTasks(List<Task> tasks) { this.tasks = tasks; }
	 */

	public void testRunTasks(String fileName) {

		taskConf.read(fileName);
		taskFactory.setTaskConfig(taskConf);
		List<Task> tasks = taskFactory.getAllTasks();

		for (Task t : tasks) {
			System.out.println(t.getTaskId() + t.execute(null));
			
		}

	}
	

	private void runTaskDependencies(Task t, List<Task> tasks) {

		for (String taskid : t.getDependencies()) {
			for (Task task : tasks) {
				if (task.getTaskId().equalsIgnoreCase(taskid)) {
					// TODO Call run method;
				}
			}
		}

	}

	public void runtasks() {
		// TODO fix date pattern
	/*	for (Task task : tasks) {

			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			calendar.set(Calendar.HOUR_OF_DAY, 15);
			calendar.set(Calendar.MINUTE, 40);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			Timer time = new Timer(); // Instantiate Timer Object
			ScheduledTask sc = new ScheduledTask();
			sc.t = task;
			// Start running the task on Monday at 15:40:00, period is set to 8
			// hours
			// if you want to run the task immediately, set the 2nd parameter to
			// 0
			time.schedule(sc, calendar.getTime(), 1000 * 60 * 60 * 8);

		}*/
	}

}

class ScheduledTask extends TimerTask {

	Date now; // to display current time
	Task t;

	// Add your task here
	public void run() {
/*		now = new Date(); // initialize date
		System.out.println("Time is :" + now); // Display current time

		try {
			t.getExecutionMehod().invoke(t, null);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}
