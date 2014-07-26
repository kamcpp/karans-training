package tee.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import tee.interfaces.TaskEngine;

public class DefaultTaskEngine implements TaskEngine {
	private List<Task> tasks;
	public DefaultTaskEngine() {
		
		tasks=new ArrayList<Task>();
	}
	public void runEngine() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object result=null;
		for(int i=0;i<tasks.size();i++)
		{
			if(i==0)
			{
				result=tasks.get(i).invoke(null);
			}else
			{
				result=tasks.get(i).invoke(result);
			}
				
		}
		
	}
	public void run() {
		// TODO Auto-generated method stub
		try {
			this.runEngine();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addTask(Task t) {
		tasks.add(t);
	}
	

}
