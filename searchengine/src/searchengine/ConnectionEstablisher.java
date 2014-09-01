package searchengine;

import java.net.URISyntaxException;




public interface ConnectionEstablisher {

	
	String extractHtmlContent(String link) throws URISyntaxException   ;

}
