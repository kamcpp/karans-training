package TEE.Scheduler.implementations;

import java.util.LinkedList;
import java.util.List;

import TEE.Scheduler.Exceptions.BeanNotFoundException;
import TEE.Scheduler.Exceptions.ConfigParseException;
import TEE.Scheduler.Exceptions.InvalidSchedulePatternException;
import TEE.Schesuler.SchedulTime;
import TEE.Schesuler.TaskConfigSource;

public class Initializer {
	private TaskConfigSource taskConf;
	private SchedulTime scheduleTime;
	private List<Taskdescription> tasks;
	
	public Initializer(){
		taskConf = new XmlConfigSources();
		scheduleTime = new SchedulTime();
		tasks = new LinkedList<Taskdescription>();
	}
	
	
	public void readConfig(String filePath){
		try {
			taskConf.read(filePath);
			scheduleTime = taskConf.getScheduleTime();
			tasks= taskConf.getTaskDescriptions();
		} catch (InvalidSchedulePatternException e) {
			e.printStackTrace();
		} catch (BeanNotFoundException e) {
			e.printStackTrace();
		} catch (ConfigParseException e) {
			e.printStackTrace();
		}
		scheduleTime= taskConf.getScheduleTime();
		
	}


	public TaskConfigSource getTaskConf() {
		return taskConf;
	}


	public SchedulTime getScheduleTime() {
		return scheduleTime;
	}


	public List<Taskdescription> getTasks() {
		return tasks;
	}
	
	
	
	

}
