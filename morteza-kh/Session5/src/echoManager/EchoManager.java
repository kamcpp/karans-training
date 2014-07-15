package echoManager;

import echoManager.Imp.ReflectionEchoFactory;
import echoManager.Imp.InMemoryConfigSource;

public class EchoManager {
	private ConfigSource configSource;
	private EchoerFactory echoerFactory;

	public EchoManager() {

		configSource = new InMemoryConfigSource();
		echoerFactory = new ReflectionEchoFactory();
		echoerFactory.setConfigSource(configSource);
	}
	
	public void doEcho(String configFilePath) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		configSource.read(configFilePath);
		Echoer e=(Echoer)echoerFactory.create();
		System.out.println(e.Echo());
	}
}
