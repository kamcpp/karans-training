package karans.s8.charstreams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class ReaderExample {
	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream("/home/morteza/Desktop/test4.txt");
		Reader reader = new InputStreamReader(in, Charset.forName("UTF-16"));
		System.out.println(reader.read());
		System.out.println(reader.read());
		System.out.println(reader.read());
		System.out.println(reader.read());
		System.out.println(reader.read());
		System.out.println(reader.read());
		System.out.println(reader.read());
		System.out.println(reader.read());
		System.out.println(reader.read());
		System.out.println(reader.read());
		System.out.println(reader.read());
		System.out.println(reader.read());
		reader.close();
		in.close();
	}
}
