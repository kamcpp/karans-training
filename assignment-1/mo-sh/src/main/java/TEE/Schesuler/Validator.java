package TEE.Schesuler;

import TEE.Scheduler.Exceptions.BeanNotFoundException;
import TEE.Scheduler.implementations.Taskdescription;

public interface Validator {
	
	public boolean validateSchedule(SchedulTime t);
	public boolean validateTasks (Taskdescription ts) throws BeanNotFoundException;
	

}
