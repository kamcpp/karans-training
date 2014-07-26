package tee.interfaces;

import java.lang.reflect.InvocationTargetException;

import tee.impl.Task;

public interface TaskEngine extends Runnable{
	public void runEngine() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void addTask(Task t);

}
