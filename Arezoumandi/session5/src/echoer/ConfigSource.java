package echoer;

public interface ConfigSource {

	public void read(String configFilePath);
	public String getType();
	
}
