package echoManager;

public interface ConfigSource {
	public void  read(String configFilePath);
	public String getBasePackageName();
	public String getClassName();

}
