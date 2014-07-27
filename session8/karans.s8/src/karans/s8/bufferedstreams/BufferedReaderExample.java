package karans.s8.bufferedstreams;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedReaderExample {
	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream("/home/morteza/Desktop/test4.txt");
		Reader reader = new InputStreamReader(in);
		BufferedReader bufferedReader = new BufferedReader(reader);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
		
		System.out.println(bufferedReader.readLine());
		System.out.println(bufferedInputStream.read());

		bufferedReader.close();
	}
}
