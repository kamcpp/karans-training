package TEE.Schesuler;

import java.util.HashMap;
import java.util.List;

public interface TaskConfigSource {


	public void read(String fileName);
	public List<Taskdescription> getTaskDescriptions();
	
	
	
	

}
