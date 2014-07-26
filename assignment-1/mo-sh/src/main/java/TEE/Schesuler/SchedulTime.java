package TEE.Schesuler;

import java.util.List;

public class SchedulTime {
	
	private String type;
	private String time;
	private List<String> daysWeek;	
	

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

	public String getTimeAsString() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	

	

}
