package rpc.serverside;

import java.io.StringReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class xmlParser implements Parser{
	
	private Request clientRequest;
	SAXParserFactory factory;
	SAXParser saxParser;

	
	public xmlParser(){
		clientRequest = new Request();
		
	}

	public void parse(String line) {
		 try {
			 factory = SAXParserFactory.newInstance();
			 saxParser = factory.newSAXParser();
	
			DefaultHandler handler = new DefaultHandler() {
				 
				boolean interfaceName = false;
				boolean methodName = false;

				
			 
				public void startElement(String uri, String localName,String qName, 
			                Attributes attributes) throws SAXException {
			 
					System.out.println("Start Element :" + qName);
			 
					if (qName.equalsIgnoreCase("INTERFACE")) {
						interfaceName = true;
					}
			 
					if (qName.equalsIgnoreCase("METHOD")) {
						methodName = true;
					}
			 
					
				}
			 
				public void endElement(String uri, String localName,
					String qName) throws SAXException {
			 
					System.out.println("End Element :" + qName);
			 
				}
			 
				public void characters(char ch[], int start, int length) throws SAXException {
			 
					if (interfaceName) {
						System.out.println("interface: " + new String(ch, start, length));
						clientRequest.setIntefaceName( new String(ch, start, length));
						interfaceName = false;
					}
			 
					if (methodName) {
						clientRequest.setMethodName( new String(ch, start, length));
						methodName = false;
					}
			 
				}
			 
			     };
			 
			       saxParser.parse(new InputSource(new StringReader(line)), handler);
			 
			     } catch (Exception e) {
			       e.printStackTrace();
			     }

	}

	public Request getClientRequest() {
		return clientRequest;
	}

	public void setClientRequest(Request clientRequest) {
		this.clientRequest = clientRequest;
	}
	

}
