package searchengine.impl;

import searchengine.CrawlerFactory;
import searchengine.Queue;

public class DefaultCrawlerFactory implements CrawlerFactory{
   private Queue queue;
   private LinkBankWithMap linkRepo;
	@Override
	public Runnable creat() {
		String link;
		link=queue.deq();
		if(!linkRepo.search(link))
		{
			link=queue.deq();
		}
		CrawlerRunable crawlerRunable=new CrawlerRunable();
		crawlerRunable.setLink(link);
		return crawlerRunable;		
	}

}
