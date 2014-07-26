package TEE.Schesuler;

import java.util.Hashtable;
import java.util.List;

import TEE.Scheduler.Exceptions.BeanNotFoundException;
import TEE.Scheduler.Exceptions.ConfigParseException;
import TEE.Scheduler.Exceptions.InvalidSchedulePatternException;
import TEE.Scheduler.implementations.Taskdescription;

public interface TaskConfigSource {


	public void read(String fileName) throws InvalidSchedulePatternException, BeanNotFoundException, ConfigParseException;
	public List<Taskdescription> getTaskDescriptions();
	public SchedulTime getScheduleTime();
	
	
	
	

}
