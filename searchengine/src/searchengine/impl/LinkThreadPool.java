package searchengine.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LinkThreadPool {
	private ExecutorService threadPoolExtractor = Executors.newFixedThreadPool(5);

	public ExecutorService getThreadPoolExtractor() {
		return threadPoolExtractor;
	}

	public void setThreadPoolExtractor(ExecutorService threadPoolExtractor) {
		this.threadPoolExtractor = threadPoolExtractor;
	}

}
