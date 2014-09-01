package searchengine.impl;

import java.net.URI;

import searchengine.StartCrawler;

public class Starter {
	private StartCrawler startCrawler;
	private URI uri;

	public void start() {
		startCrawler.startCrawl(uri);
	}
}
