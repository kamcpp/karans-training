package tee.beans;

import java.util.ArrayList;
import java.util.List;

public class TaskSchedulerConfig {
	private ScheduleEntry schedule;
	private List<TaskEntry> taskEntries;
	public TaskSchedulerConfig() {
		taskEntries=new ArrayList<TaskEntry>();
	}
	public ScheduleEntry getSchcedule() {
		return schedule;
	}
	public void setSchcedule(ScheduleEntry schedule) {
		this.schedule = schedule;
	}
	public List<TaskEntry> getTaskEntries() {
		return taskEntries;
	}
	public void setTaskEntries(List<TaskEntry> taskEntries) {
		this.taskEntries = taskEntries;
	}
	
	public void addTaskEntry(TaskEntry task) {
		taskEntries.add(task);
		
	}
	
}
