package TEE.Schesuler;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class SchedulTime {
	
	private String type;
	private int hours;
	private int minutes;
	private int seconds;
	private List<String> daysWeek;	
	private boolean scheduleValid;
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getDaysWeek() {
		return daysWeek;
	}

	public void setDaysWeek(List<String> daysWeek) {
		this.daysWeek = daysWeek;
	}

	public boolean isScheduleValid() {
		return scheduleValid;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	

}
