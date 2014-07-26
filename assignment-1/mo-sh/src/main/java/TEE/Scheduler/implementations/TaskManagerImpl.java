package TEE.Scheduler.implementations;


import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import TEE.Schesuler.SchedulTime;
import TEE.Schesuler.TaskManager;

public class TaskManagerImpl implements TaskManager {
	public static final String FILE_PATH = "/Users/mohammad.shadab/Documents/java-class-config2.xml";

	public TaskManagerImpl() {

	}

	public void runtasks() {
		Initializer initializer = new Initializer();
		initializer.readConfig(FILE_PATH);

		TaskExecuter te = new TaskExecuter(initializer.getTasks());
		SchedulTime runTime = initializer.getScheduleTime();
		String hour = runTime.getTimeAsString().split(":")[0];
		String minutes = runTime.getTimeAsString().split(":")[1];
		String second = runTime.getTimeAsString().split(":")[2];
		List<String> days = runTime.getDaysWeek();
		Timer timer = new Timer();
		Calendar date = Calendar.getInstance();
		for (String day : days) {

			switch (day) {
			case "Monday":
				date.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			case "Tuesday":
				date.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			case "Wednesday":
				date.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
			case "Thursday":
				date.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
			case "Friday":
				date.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			case "Saturday":
				date.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
			case "Sunday":
				date.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			
			}
		}
		if(!runTime.getTimeAsString().equalsIgnoreCase("hourly")){
		date.set(Calendar.HOUR, Integer.parseInt(hour));
		date.set(Calendar.MINUTE, Integer.parseInt(minutes));
		date.set(Calendar.SECOND, Integer.parseInt(second));
		date.set(Calendar.MILLISECOND, 0);
		}
		else{
			//TODO FIX Hourly 
		}
		timer.schedule(te, date.getTime());

	}

}
