package reflectionPackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class textConfigSource implements ConfigSource{
	
	private String className;
	private String packageName;
	
	@Override
	public String getPackageNme() {
		
		return packageName;
	}
	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return className;
	}
	@Override
	public void read(String fileName) {
		File f= new File(fileName);
		FileReader fr;
		try {
			fr = new FileReader(f);
		
		BufferedReader br = new BufferedReader(fr);
		packageName = br.readLine().split("=")[1];
		className = br.readLine().split("=")[1];
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
