/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.karans.threadpool;

import co.karans.TaskSpecification.Task;
import co.karans.reflection.reflect;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ya Mahdi
 */
public class TaskThread implements Runnable{

    private Task t;
    private String baseName;
    private ArrayList<String> features;
    private ArrayList<String> parallelTask;
    private HashMap<String,ArrayList<Task>> map;
    private boolean isProcessed = false;
    public TaskThread(Task task, String basePkg , ArrayList<String> features, ArrayList<String> parallelTask,HashMap<String,ArrayList<Task>> map){
        this.t = task;
        this.baseName = basePkg;
        this.features = features;
        this.parallelTask = parallelTask;
        this.map = map;
    }

    public String getBaseName() {
        return baseName;
    }

    public ArrayList<String> getFeatures() {
        return features;
    }
    
    public void setProcessed(Task task){
         task.setProcessed(true);
    }
    
    public static long F(int n) { 
   if (n == 0) return 0; 
   if (n == 1) return 1; 
   return F(n-1) + F(n-2); 
} 
    
  @Override  
   public void run() {
        try {
            
            processTask(this.t);
          
            //search(this.t,this.t.getid());
        } catch (InstantiationException ex) {
            Logger.getLogger(TaskThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TaskThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(TaskThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(TaskThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(TaskThread.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//run
  
  public void processTask(Task task) throws InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
        Iterator keyIterator = this.map.keySet().iterator();
        ArrayList<Task> adjacency = new ArrayList<Task>();
        HashMap<String, ArrayList<Task>> m= this.map;
        adjacency= m.get(task.getid());
        if(adjacency == null && !task.isProcessed()){
             reflect myReflection = new reflect();
             
                        myReflection.generateReflection(getBaseName(), task.getPackageName(), task.getClassName(), task.getMethod(),task.getBefore(),task.getAfter());
                        setProcessed(task);

        }
        
       else{
           for(int i = 0; i< adjacency.size();i++){
               if(!adjacency.get(i).isProcessed()){ 
                   processTask(adjacency.get(i));
              }
           }//for
       }//else
       
       
  
  
  }
  
  
  
    public void search(Task task,String id){
        Iterator keyIterator = this.map.keySet().iterator();
        ArrayList<Task> adjacency = new ArrayList<Task>();
        HashMap<String, ArrayList<Task>> m= this.map;
        adjacency= m.get(id);
        
        if(adjacency == null && !task.isProcessed()){
                reflect myReflection = new reflect();
                  try {
                        myReflection.generateReflection(getBaseName(), task.getPackageName(), task.getClassName(), task.getMethod(),task.getBefore(),task.getAfter());
                        setProcessed(task);
                        
                } catch (InstantiationException ex) {
                    System.out.println(ex.getMessage());
                    Logger.getLogger(TaskThread.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    System.out.println(ex.getMessage());
                    Logger.getLogger(TaskThread.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    System.out.println(ex.getMessage());
                    Logger.getLogger(TaskThread.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                    Logger.getLogger(TaskThread.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    System.out.println(ex.getMessage());
                    Logger.getLogger(TaskThread.class.getName()).log(Level.SEVERE, null, ex);
                }

      }//if
        /*if(adjacency != null){*/
        else{
            
           for(int i=0; i< adjacency.size();i++){
               //  for(Task ta: adjacency){
               //if(!adjacency.get(0).isProcessed()){
                search(adjacency.get(i),adjacency.get(i).getid());
            }
        }
      
       
    }//search
   
    
}
