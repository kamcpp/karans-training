package searchengine.impl;


import java.util.concurrent.ConcurrentLinkedQueue;

import searchengine.Queue;

public class DefaultQueue implements Queue {
	private ConcurrentLinkedQueue<String> linkQueue;

	public DefaultQueue() {
		linkQueue = new ConcurrentLinkedQueue<String>();
	}

	@Override
	public void inq(String link) {
		linkQueue.add(link);
	}

	@Override
	public String deq() {
		return linkQueue.poll();

	}

	@Override
	public int getSize() {
		return linkQueue.size();
		 
	}

}
