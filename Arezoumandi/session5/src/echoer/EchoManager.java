package echoer;

public class EchoManager {
	public void doEcho(String configFilePath) {
		EchoerFactory echoerFactory = new DefultEchoerImpl();
		ConfigSource configSource = new DefultConfigImpl();
		configSource.read(configFilePath);
		Echoer e = (Echoer) echoerFactory.create();
		System.out.println(e.echo());
	}

}
