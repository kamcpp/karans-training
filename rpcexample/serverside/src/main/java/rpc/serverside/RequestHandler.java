package rpc.serverside;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestHandler implements Runnable {

	Socket s;
	String incommingLine;
	xmlParser xmlParser;
	Request request;
	BeanFactory factory;

	static {

	}

	public RequestHandler() {

	}

	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}

	public void run() {
		System.out.println("in the run method");

		try {
			xmlParser = new xmlParser();
			xmlParser.parse(incommingLine);
			System.out.println(incommingLine);
			request = xmlParser.getClientRequest();
		

			if (request.getIntefaceName().equalsIgnoreCase("MyBean")) {

				MyBeanImpl bean = (MyBeanImpl) factory.createBean(request
						.getIntefaceName());
				Response r = new Response();
				r.setResponseString(bean.getResponse());
				String response = r.toString();
				System.out.println(" this is the response " + response);

				PrintWriter pw = new PrintWriter(s.getOutputStream());
				pw.write(response);
				pw.flush();
				

			}
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public String getIncommingLine() {
		return incommingLine;
	}

	public void setIncommingLine(String incommingLine) {
		this.incommingLine = incommingLine;
	}

	public xmlParser getXmlParser() {
		return xmlParser;
	}

	public void setXmlParser(xmlParser xmlParser) {
		this.xmlParser = xmlParser;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

}
