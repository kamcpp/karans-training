/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.karans.graph;

import co.karans.TaskSpecification.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Ya Mahdi
 */
public class Node {
 
     private String label;   // This is tasks' ids
   //  private ArrayList<Integer> adjacencyList;
      private ArrayList<Task> adjacencyList;
   //  private HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
      private HashMap<String, ArrayList<Task>> map = new HashMap<String, ArrayList<Task>>();
     private boolean runAsParallel = false;
             
    public HashMap<String, ArrayList<Task>> getMap() {
        return map;
    }

    public boolean isRunAsParallel() {
        return runAsParallel;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ArrayList<Task> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(ArrayList<Task> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }
     
   public Node(String id, ArrayList<Task> adjacencyList){
       
       if(!adjacencyList.isEmpty()){
           this.adjacencyList = adjacencyList;
       }
       
       if(adjacencyList.isEmpty()){
           runAsParallel = true;           
       }
       
       this.label = id; 
       //this.map.put(id, adjacencyList);         
   }
   
   public void setMap(ArrayList<Node> nodeArray){
        for(Node node: nodeArray){
            String key = node.getLabel();
            ArrayList<Task> value = node.getAdjacencyList();
            this.map.put(key, value);
            
        
        }
   
   }
   public Node(){
   
   }
   
   public int calculateParallelTasks(ArrayList<Node> nodeArray){
       int counter = 0;
       for(Node node: nodeArray)
           if(node.isRunAsParallel())
               counter++;
           
       return counter;
   }//cal
   
   public ArrayList parallelTasks(ArrayList<Node> nodeArray){
        ArrayList<String> parallelTask = new ArrayList<String>();
        
        for(Node node: nodeArray){
           if(node.isRunAsParallel())
               parallelTask.add(node.getLabel());
        }//for
   
        return parallelTask;
   }//
   
        
}
