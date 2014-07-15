package echoManager.Imp;

import echoManager.ConfigSource;
import echoManager.Echoer;
import echoManager.EchoerFactory;

public class ReflectionEchoFactory implements EchoerFactory {

	private ConfigSource configSource;

	@Override
	public Echoer create() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class c=Class.forName(configSource.getBasePackageName()+"."+configSource.getClassName());
		return (Echoer)c.newInstance();
	}

	@Override
	public void setConfigSource(ConfigSource config) {
		// TODO Auto-generated method stub
		configSource=config;
	}

}
