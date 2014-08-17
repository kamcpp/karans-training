package rpc.serverside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ConnectionPool p = new ConnectionPool();
		try {
			ServerSocket socket = new ServerSocket(2000);

			while (true) {
				System.out.println("waiting for client");
				Socket s = socket.accept();
				System.out.println("client acepted");
				

				BufferedReader br = new BufferedReader(new InputStreamReader(
						s.getInputStream()));
				System.out.println("waiting for line");
				String line = br.readLine();
				System.out.println(line);
				
				
				RequestHandler handler = new RequestHandler();
				handler.setS(s);
				handler.setIncommingLine(line);
				p.getServicePool().execute(handler);
				//s.close();

			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
