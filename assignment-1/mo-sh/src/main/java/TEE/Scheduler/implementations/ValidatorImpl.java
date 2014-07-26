package TEE.Scheduler.implementations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import TEE.Scheduler.Exceptions.BeanNotFoundException;
import TEE.Scheduler.Exceptions.InvalidSchedulePatternException;
import TEE.Schesuler.SchedulTime;

public class ValidatorImpl {

	public static boolean validateSchedule(SchedulTime t)
			throws InvalidSchedulePatternException {
		SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");

		if (!t.getTimeAsString().isEmpty() && !t.getTimeAsString().equalsIgnoreCase("hourly")) {
			try {
				df.parse(t.getTimeAsString());
			} catch (ParseException e) {
				throw new InvalidSchedulePatternException(e);
			}
			return true;
		} else if (!t.getTimeAsString().equalsIgnoreCase("hourly")) {
			throw new InvalidSchedulePatternException(new Exception(
					" incorrect Time pattern"));

		} else {

			String type = t.getType();
			if (type.equalsIgnoreCase("weekly") && t.getDaysWeek().isEmpty()) {
				throw new InvalidSchedulePatternException(new Exception(
						" schedule type is weekly but missing days in week"));

			} else {
				return true;
			}

		}

	}

	public static void validateTasks(Taskdescription task)
			throws BeanNotFoundException {

		if (task.getTaskId().isEmpty() || task.getTaskId() == null) {
			throw new BeanNotFoundException(new Exception("Missing Task id"));
		}

		String fullClassPath = "";
		if (task.getClassPackageName() == null
				|| task.getClassPackageName().isEmpty()) {
			fullClassPath = task.getBasePackageName() + '.'
					+ task.getClassName();

		} else {
			fullClassPath = task.getBasePackageName() + '.'
					+ task.getClassPackageName() + '.' + task.getClassName();

		}

		try {
			TestBeanValidity(fullClassPath, task);
		} catch (ClassNotFoundException e) {
			throw new BeanNotFoundException(e);
		} catch (InstantiationException e) {
			throw new BeanNotFoundException(e);
		} catch (IllegalAccessException e) {
			throw new BeanNotFoundException(e);
		} catch (NoSuchMethodException e) {
			throw new BeanNotFoundException(e);
		} catch (SecurityException e) {
			throw new BeanNotFoundException(e);
		} catch (IllegalArgumentException e) {
			throw new BeanNotFoundException(e);
		} catch (InvocationTargetException e) {
			throw new BeanNotFoundException(e);
		}
	}

	public static void TestBeanValidity(String fullClassPath,
			Taskdescription task) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException, BeanNotFoundException {

		Class c = Class.forName(fullClassPath);

		for (Method m : c.getMethods()) {
			if (m.getName().equalsIgnoreCase(task.getMethodName())) {
				return;
			}
		}

		throw new BeanNotFoundException(new Exception(fullClassPath
				+ " Missing run Method"));

	}
}
