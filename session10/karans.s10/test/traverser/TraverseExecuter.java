package traverser;

import org.springframework.beans.factory.annotation.Autowired;

public class TraverseExecuter {

	@Autowired
	private Traverser traverser;
	
	public void execute() {
		traverser.traverse();
	}
}
