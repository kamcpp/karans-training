package rpc.serverside;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionPool {
	
	ExecutorService servicePool = Executors.newFixedThreadPool(10);

	public ExecutorService getServicePool() {
		return servicePool;
	}

	public void setServicePool(ExecutorService servicePool) {
		this.servicePool = servicePool;
	}
	
	
	

}
