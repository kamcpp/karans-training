package reflectionPackage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MyFactory implements EchoFactory {
	
	ConfigSource configSeaorce;
	
	public MyFactory(){
		
	}

	@Override
	public Echo create() {

		Echo myEchoClass= null;
		Class c;
		try {
			c = Class.forName(configSeaorce.getPackageNme()+"."+configSeaorce.getClassName());
		 
		 myEchoClass = (Echo) c.newInstance();
		
		
		}catch (ClassNotFoundException | InstantiationException |
				IllegalAccessException | SecurityException | IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myEchoClass;
	}

	public ConfigSource getConfigSeaorce() {
		return configSeaorce;
	}

	public void setConfigSeaorce(ConfigSource configSeaorce) {
		this.configSeaorce = configSeaorce;
	}
	

}
