package tee.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import annotations.ResourcedTask;
import tee.beans.TaskEntry;
import tee.exceptions.TaskEntryNotValidException;

public class Task {
	private Class taskClass;
	private Object obj;
	private Method runMethod;
	private Method beforeMethod;
	private Method afterMethod;
	private Method DisposeTaskMethod;
	private Task(){
		
	}
	
	public static Task getInstance(TaskEntry taskEntry) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException, TaskEntryNotValidException {
		taskEntry.validate(); //it will throw some exception
		java.util.Date date=new Date();
		Task newTask=new Task();
		String className=taskEntry.getFullClassName();
		newTask.taskClass=Class.forName(className);
		newTask.obj=newTask.taskClass.newInstance();
		
		newTask.runMethod=newTask.taskClass.getMethod(taskEntry.getRunMethod(),new Class[] {Object.class});
		
		if(taskEntry.getBeforeMethod()!=null)
			newTask.beforeMethod=newTask.taskClass.getMethod(taskEntry.getBeforeMethod(),new Class[] {});
		if(taskEntry.getAfterMethod()!=null)
			newTask.afterMethod=newTask.taskClass.getMethod(taskEntry.getAfterMethod(),new Class[] {}); 
		
		
		if(newTask.taskClass.getAnnotation(ResourcedTask.class)!=null) //Class has @ResourcesTask annotaion
		{
			newTask.DisposeTaskMethod=newTask.taskClass.getMethod("DisposeTask",new Class[] {}); 
		}
		
		return newTask;
	}

	public Object invoke(Object input) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		if(beforeMethod!=null)
			beforeMethod.invoke(obj,new Object[]{});
		Object result=runMethod.invoke(obj, input);
		if(afterMethod!=null)
			afterMethod.invoke(obj, new Object[]{});
		
		if(DisposeTaskMethod!=null)
			DisposeTaskMethod.invoke(obj, new Object[]{});
		
		return result;
	}

}
