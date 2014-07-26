package tee.impl;

import tee.beans.ScheduleEntry;
import tee.interfaces.Schedule;

public class DefaultSchedule implements Schedule {
	private DefaultSchedule() {
		// TODO Auto-generated constructor stub
	}
	
	public static DefaultSchedule newInstance(ScheduleEntry scheduleEntry) {
		DefaultSchedule newSchedule=new DefaultSchedule();
		return newSchedule;
	}
}
