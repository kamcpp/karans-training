package searchengine.impl;


import java.util.concurrent.ConcurrentMap;

import searchengine.LinkBank;
import searchengine.enumdata.State;

public class LinkBankWithMap implements LinkBank {
	private ConcurrentMap<String, State> repoMap;

	@Override
	public String getUnVisitedLink() {
		String returnedKey = null;
		for (String key : repoMap.keySet()) {
			if (repoMap.get(key) == State.EXTRACTED) {
				returnedKey = key;
				break;
				
			}
		}
		return returnedKey;
	}
	

	boolean search( String item)
	{
		return false;
		
	}
	@Override
	public void add(String links) {
		repoMap.put(links, State.UNVISITED);
	}

	public ConcurrentMap<String, State> getRepoMap() {
		return repoMap;
	}

	public void setRepoMap(ConcurrentMap<String, State> repoMap) {
		this.repoMap = repoMap;
	}

}
