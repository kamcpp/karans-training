package taskclass;

import annotations.ResourcedTask;

@ResourcedTask
public class Printer {
	public Object print(Object obj) {
		System.out.println(obj);
		return obj;
	}
	
	public void DisposeTask() {
		System.out.println("Disposing printer...");
		
	}
}
