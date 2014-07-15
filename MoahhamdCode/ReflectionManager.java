package reflectionPackage;
import java.lang.reflect.Method;


public class ReflectionManager {
	
	private ConfigSource configSource;
	private MyFactory echoFactory;
	
	public ReflectionManager(){
		configSource = new textConfigSource();
		echoFactory = new MyFactory();
		
	}

	public void doEcho(String fileName){
		
		configSource.read(fileName);
		echoFactory.setConfigSeaorce(configSource);
		
		Echo e = (Echo) echoFactory.create();
		System.out.println(e.echo());
	}

}
