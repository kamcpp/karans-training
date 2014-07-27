/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import co.karans.TaskSpecification.Task;
import co.karans.threadpool.TaskThread;
import co.karans.graph.Node;
import co.karans.threadpool.ThreadPool;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


/**
 *
 * @author Ya Mahdi
 */
public class NewClass {
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, InterruptedException{
        
       ArrayList<Task> taskArray =  co.karans.XMLParser.XmlParser.getTaskArray("C:\\Config.xml");
       Node node;
       ArrayList<Node> nodeArray = new ArrayList<Node>();
       ArrayList<Task> dependentArray;
       for(Task t : taskArray){
            ArrayList<String> dependencyList = t.getDependencyList(t.getDependsOn(), ",");
            dependentArray = new ArrayList<Task>();
            for(String label: dependencyList){
                 dependentArray.add(t.getTaskObj(label, taskArray));
            }
           
            node = new Node(t.getid(),dependentArray);    //Generating all hashmap in this block of code!
            nodeArray.add(node);
       }
       
       String basePkg = co.karans.XMLParser.XmlParser.getbasePkg("C:\\Config.xml");
       ArrayList<String> features = co.karans.XMLParser.XmlParser.getFeatures("C:\\Config.xml");
       
       Node n = new Node();
       n.setMap(nodeArray);
       int counter = n.calculateParallelTasks(nodeArray);
       ArrayList<String> parallelTasks = new ArrayList<String>();
       parallelTasks = n.parallelTasks(nodeArray);
       
       
       LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>() {};
       Runnable r = null;

        HashMap<String,ArrayList<Task>> map = n.getMap();
       for(Task t: taskArray){
            r = new TaskThread(t, basePkg, features,parallelTasks,n.getMap());
            queue.add(r);
     }
       
       
       ThreadPool tp = new ThreadPool(counter+1, 3, 3, TimeUnit.DAYS, queue); 
       
       for(int i=0;i<queue.size();i++){
           tp.execute(queue.take());
       }
       
       /*tp.execute(queue.take());
       tp.execute(queue.take());
       tp.execute(queue.take());
       tp.execute(queue.take());
       tp.execute(queue.take());
       */
       tp.shutdown();
       

    
    }
    
}
