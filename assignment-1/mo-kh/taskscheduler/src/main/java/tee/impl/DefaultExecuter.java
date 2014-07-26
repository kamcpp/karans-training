package tee.impl;

import tee.interfaces.Executer;
import tee.interfaces.Schedule;

public class DefaultExecuter implements Executer {

	public void execute(Runnable objectToRun, Schedule schedule) {
		// TODO Auto-generated method stub
		
		//TODO: implement scheduling! run at true time
		objectToRun.run();
		
	}

}
