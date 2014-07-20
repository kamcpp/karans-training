package contextManager;

import java.util.List;

public interface ContextConfigurationReader {
	public List<BeanDescription> read(String path);
}
