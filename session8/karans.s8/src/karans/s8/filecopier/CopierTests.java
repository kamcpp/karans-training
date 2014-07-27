package karans.s8.filecopier;

import java.util.Date;

public class CopierTests {
	public static void main(String[] args) throws InterruptedException {
		FileCopier fileCopier = new AsyncBufferedFileCopier(
				"/home/morteza/Desktop/xyz.bin",
				"/home/morteza/Desktop/xyz-copy.bin");
		long start = new Date().getTime();
		fileCopier.copy();
		((AsyncBufferedFileCopier) fileCopier).getWorkingThread().join();
		long duration = new Date().getTime() - start;

		System.out.println("Duration: " + duration);
	}
}
