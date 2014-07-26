package taskclass;

import java.util.Calendar;
import java.util.Date;

public class DateReader {
	public Date getCurrentDate(Object obj) {
		java.util.Calendar calendar=Calendar.getInstance();
		return calendar.getTime();
		
	}
}
