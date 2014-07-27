/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.karans.XMLParser;

import co.karans.TaskSpecification.Task;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

/**
 *
 * @author Ya Mahdi
 */
public class XmlParser {
    
 
    
    public static ArrayList getTaskArray(String filePath) throws ParserConfigurationException, SAXException, IOException{
        File file = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = (Document) dBuilder.parse(file);
        
	doc.getDocumentElement().normalize();
        ArrayList<Task> taskArr = new ArrayList<Task>();
	
       
       NodeList tasksList = doc.getElementsByTagName("tasks");
       Node nNodeTasks = tasksList.item(0);
           if (nNodeTasks.getNodeType() == Node.ELEMENT_NODE) {

                //Loop for getting tasks specification
                NodeList nListTaskSpec = doc.getElementsByTagName("task");
                for (int temp = 0; temp < nListTaskSpec.getLength(); temp++) {
 
		 Node nNodeTaskSpec = nListTaskSpec.item(temp);
 
		//System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNodeTaskSpec.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElementTaskSpec = (Element) nNodeTaskSpec;
                        
                        //System.out.println("temp is "+ temp);
                        
			String id =  eElementTaskSpec.getAttribute("id");
			String className = eElementTaskSpec.getAttribute("class");
			String packageName = eElementTaskSpec.getAttribute("package");
			String before = eElementTaskSpec.getAttribute("before");
			String method = eElementTaskSpec.getAttribute("method");
                        String dependsOn = eElementTaskSpec.getAttribute("dependsOn");
                        String after = eElementTaskSpec.getAttribute("after");
                        
                        Task t = new Task(id, className, packageName, method, before, after, dependsOn);
                        taskArr.add(t);
		}
	}//for                                        
      }//if 
           
           return taskArr; 
    }  
    
    public static String getbasePkg(String filePath) throws ParserConfigurationException, SAXException, IOException{
        
        File file = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = (Document) dBuilder.parse(file);
        
	doc.getDocumentElement().normalize();
        String basePackage = null;
        NodeList tasksList = doc.getElementsByTagName("tasks");
        Node nNodeTasks = tasksList.item(0);
           if (nNodeTasks.getNodeType() == Node.ELEMENT_NODE) {
		Element eElement = (Element) nNodeTasks;                     
                basePackage = eElement.getElementsByTagName("base-package").item(0).getTextContent();
                //System.out.println(basePackage);

    }//if
           return basePackage;
    }    
    
    public static ArrayList getFeatures(String filePath) throws ParserConfigurationException, SAXException, IOException{
        File file = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = (Document) dBuilder.parse(file);
        
	doc.getDocumentElement().normalize();
 
	NodeList scheduleList = doc.getElementsByTagName("schedule");
        
        ArrayList<String> taskFeatures= new ArrayList<String>();
	
        Node nNode = scheduleList.item(0);
             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		Element eElement = (Element) nNode;                       
                        taskFeatures.add(eElement.getAttribute("type"));
                        taskFeatures.add(eElement.getAttribute("time"));
                        taskFeatures.add(eElement.getAttribute("days"));
                                
                }//if              
        
        return taskFeatures;
    
    }
    
}
