package searchengine.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import searchengine.ConnectionEstablisher;

public class HttpClientConnectionEstablisher implements ConnectionEstablisher {

	HttpClient httpClient;
	HttpUriRequest getRequest;
	HttpResponse response;

	public HttpClientConnectionEstablisher() {
		this.httpClient = new DefaultHttpClient();
	}

	@Override
	public String extractHtmlContent(String link) throws URISyntaxException {
		String html = null;
		try {
			getRequest = new HttpGet(link);
			response = httpClient.execute(getRequest);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			while ((reader.readLine()) != null) {
				html += reader.readLine();
			}

		} catch (HttpException | IOException e) {
			e.printStackTrace();
		}

		return html;
	}

}
