package tee.impl;

import java.util.ArrayList;
import java.util.List;

import tee.beans.ScheduleEntry;
import tee.beans.TaskEntry;
import tee.beans.TaskSchedulerConfig;
import tee.interfaces.ConfigReader;

public class InMemoryConfigReader implements ConfigReader {

	public TaskSchedulerConfig read() {
		// TODO Auto-generated method stub
		TaskSchedulerConfig config=new TaskSchedulerConfig();
		ScheduleEntry schedule=new ScheduleEntry();
		schedule.setTime("20:34:15");
		schedule.setDays("Sunday,Tuesday,Friday");
		schedule.setScheduleType("daily");
		config.setSchcedule(schedule);
		//java.lang.Math.random()
		//System.out.println();
		List<TaskEntry> taksEntires=new ArrayList<TaskEntry>();
		String basePackageName="";
		TaskEntry task=new TaskEntry();
		
		task.setId("task1");
		task.setClassName("taskclass.DateReader");
		task.setRunMethod("getCurrentDate");
		taksEntires.add(task);
		task=new TaskEntry();
		task.setId("task2");
		task.setBasePackage("taskclass");
		task.setClassName("Printer");
		task.setRunMethod("print");
		taksEntires.add(task);
		config.setTaskEntries(taksEntires);
		//TODO: fill task entry list
		
		return config;
	}

}
