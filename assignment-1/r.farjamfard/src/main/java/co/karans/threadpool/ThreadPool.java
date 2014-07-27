/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.karans.threadpool;

import co.karans.TaskSpecification.Task;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ya Mahdi
 */
public class ThreadPool extends ThreadPoolExecutor {

 //  private final ExecutorService executorService;

    public ThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }
   
    
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        
    }
 
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t != null) {
            System.out.println("Perform exception handler logic");
        }
        
    }
    
    
   /* public ThreadPool(int nthreads,LinkedBlockingQueue<Runnable> queue){
        new ThreadPoolExecutor(nthreads, nthreads,
                                  0L, TimeUnit.MILLISECONDS,
                                  queue);
        // executorService = Executors.newFixedThreadPool(nthreads);
    
    }*/
    /*
   public void myExecute(Runnable r){
       
           executorService.execute(r);
   }
   
   public void myShutDown(){
       executorService.shutdown();
       while (!executorService.isTerminated()) {
        }
        System.out.println("Finished all tasks!");
   }
   */ 
    
    
    
    
    
}
