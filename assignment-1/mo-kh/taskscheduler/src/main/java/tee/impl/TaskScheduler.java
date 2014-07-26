package tee.impl;

import java.util.List;

import tee.beans.TaskEntry;
import tee.beans.TaskSchedulerConfig;
import tee.exceptions.TaskEntryNotValidException;
import tee.interfaces.ConfigReader;
import tee.interfaces.Executer;
import tee.interfaces.TaskEngine;

public class TaskScheduler {
	ConfigReader configReader;
	TaskEngine taskEngine;
	Executer executer;
	TaskSchedulerConfig config;
	public TaskScheduler() {
		configReader=new InMemoryConfigReader();
		taskEngine=new DefaultTaskEngine();
		executer=new DefaultExecuter(); 
	}
	public ConfigReader getConfigReader() {
		return configReader;
	}
	public void setConfigReader(ConfigReader configReader) {
		this.configReader = configReader;
	}
	public TaskEngine getTaskEngine() {
		return taskEngine;
	}
	public void setTaskEngine(TaskEngine taskEngine) {
		this.taskEngine = taskEngine;
	}
	public Executer getExecuter() {
		return executer;
	}
	public void setExecuter(Executer executer) {
		this.executer = executer;
	}
	public TaskSchedulerConfig getConfig() {
		return config;
	}
	public void setConfig(TaskSchedulerConfig config) {
		this.config = config;
	}
	public void run() throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException, TaskEntryNotValidException {
		config=configReader.read();
		List<TaskEntry> taskEntries= config.getTaskEntries();
		Task temp;
		for(TaskEntry t:taskEntries)
		{
			temp=Task.getInstance(t);
			taskEngine.addTask(temp);
		}
		DefaultSchedule schedule=DefaultSchedule.newInstance(config.getSchcedule());
		executer.execute(taskEngine, schedule);
		
		
		
		
	}

}
