package searchengine.impl;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import searchengine.ConnectionEstablisher;
import searchengine.ContentExtractor;
import searchengine.LinkExtaractor;
import searchengine.LinkBank;

public class CrawlerRunable implements Runnable {

	private LinkBank linkBank;
	private ConnectionEstablisher connectionEstablisher;
	private DefaultQueue queue;
	private List<String> linksList = new ArrayList<String>();
	private LinkExtaractor linkExtaractor;
	private ContentExtractor contentExtractor;
	private AddFileInDirectory addFile;
	private String link;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public void run() {

		String html = null;
		File file;
		try {
			html = connectionEstablisher.extractHtmlContent(link);
		} catch (URISyntaxException e) {

			e.printStackTrace();
		}
		if (html != null) {
			file = contentExtractor.extract(html);
			addFile.add(file);
			linksList = linkExtaractor.extract(html);

			for (String links : linksList) {

				linkBank.add(links);
				queue.inq(links);
			}
		}

	}

	public LinkBank getLinkReop() {
		return linkBank;
	}

	public void setLinkReop(LinkBank linkReop) {
		this.linkBank = linkReop;
	}

	public ConnectionEstablisher getConnectionEstablisher() {
		return connectionEstablisher;
	}

	public void setConnectionEstablisher(
			ConnectionEstablisher connectionEstablisher) {
		this.connectionEstablisher = connectionEstablisher;
	}

	public LinkExtaractor getLinkExtaractor() {
		return linkExtaractor;
	}

	public void setLinkExtaractor(LinkExtaractor linkExtaractor) {
		this.linkExtaractor = linkExtaractor;
	}

}
