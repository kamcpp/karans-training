package fs;

import java.io.File;

public class EnumerateFiles {
	public static void main(String[] args) {
		File f = new File("/home/morteza");
		File[] files = f.listFiles();
		for (File ff : files) {
			System.out.println(ff.getPath());
		}
	}
}
