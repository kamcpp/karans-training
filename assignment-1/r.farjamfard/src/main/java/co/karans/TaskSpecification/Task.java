/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.karans.TaskSpecification;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Ya Mahdi
 */
public class Task  {
    private String id;
    private String className;
    private String packageName;
    private String method;
    private String before;
    private String after;
    private String dependsOn;
    private boolean isProcessed = false;
    
     public Task(String id, String className, String packageName, String method, String before, String after, String dependsOn ){
         setId(id);
         setClassName(className);
         setMethod(method);
         setPackageName(packageName);
         setBefore(before);
         setAfter(after);
         setDependsOn(dependsOn);
        
    
    }

     
    public boolean isProcessed(){
        return isProcessed;
    }
    
    public void setProcessed(boolean processed){
        this.isProcessed = processed;
    }
     
    // public Task(String id)

    public String getid() {
        String trueId = null;
        String[] idToken = this.id.split("task");
        for(String str : idToken){
            if(!str.equals("")){
             trueId = str;
            }
        }
        return trueId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }
    
    public Task getTaskObj(String id,ArrayList<Task> taskArray ){
        Task target = null;
        for(Task task:taskArray){
            if(task.getid().equalsIgnoreCase(id)){
                target = task;
                break;
            }
        }
        return target;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public String getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(String dependsOn) {
        this.dependsOn = dependsOn;
    }
    
    /**
     * get the list of task dependencies for a specific task
     * @param dependsOn
     * @param delim
     * @return ArrayList 
     */
    public ArrayList getDependencyList(String dependsOn,String delim){
        String[] tokens = dependsOn.split(delim);
         String[] strTokens = null;
         ArrayList<String> idsToken = new ArrayList<String>();
         
         for(String str : tokens){
                strTokens = str.split("task");
                int i = 0;
                for(String s : strTokens)
                    if(!s.equals("")){
                        idsToken.add(s); 
                        i++;
                    }
        }
        
        return idsToken;
    }
   
  /* public void run() {
            while (true) {
                try {
                    Runnable r = workerQueue.take();
                    r.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            } 
    */
}//class
