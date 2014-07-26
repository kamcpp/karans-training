import tee.exceptions.TaskEntryNotValidException;
import tee.impl.TaskScheduler;


public class TaskScheduleRunner {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException, TaskEntryNotValidException {
		// TODO Auto-generated method stub
		TaskScheduler taskScheduler=new TaskScheduler();
		taskScheduler.run();
	}

}
