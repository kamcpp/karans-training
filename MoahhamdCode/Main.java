package reflectionPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {
	
	public static final String FILE_PATH = "/Volumes/data/java-class-config2.txt";

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		
		ReflectionManager manager = new ReflectionManager();
		manager.doEcho(FILE_PATH);
		
		
	}

}
