package echoManager;

public interface EchoerFactory {
	public Echoer create() throws InstantiationException, IllegalAccessException, ClassNotFoundException;
	public void setConfigSource(ConfigSource config);
}
