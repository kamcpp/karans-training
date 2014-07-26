package TEE.Scheduler.implementations;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import TEE.Scheduler.Exceptions.BeanNotFoundException;
import TEE.Scheduler.Exceptions.ConfigParseException;
import TEE.Scheduler.Exceptions.InvalidSchedulePatternException;
import TEE.Schesuler.SchedulTime;
import TEE.Schesuler.TaskConfigSource;

public class XmlConfigSources implements TaskConfigSource {

	List<Taskdescription> allTaskDescriptions;
	//Hashtable<String, Taskdescription> descriptionTable;
	SchedulTime scheduleTime;

	public XmlConfigSources() {
		allTaskDescriptions = new LinkedList<Taskdescription>();
		scheduleTime= new SchedulTime();
		
	}

	public void read(String fileName) throws InvalidSchedulePatternException, BeanNotFoundException, ConfigParseException {

		File fXmlFile = new File(fileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("task");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					Taskdescription taskdes = new Taskdescription();
					taskdes.setBasePackageName(doc
							.getElementsByTagName("base-package").item(0)
							.getTextContent());
					taskdes.setTaskId(eElement.getAttribute("id"));
					taskdes.setClassName(eElement.getAttribute("class"));
					taskdes.setMethodName(eElement.getAttribute("method"));
					taskdes.setBeforeMethod(eElement.getAttribute("before"));
					taskdes.setAfterMethod(eElement.getAttribute("after"));
					taskdes.setClassPackageName(eElement
							.getAttribute("package"));
					String taskDependencies = eElement
							.getAttribute("dependsOn");

					taskdes.setDependencies(fixDependencies(taskDependencies));
					NodeList sList = doc.getElementsByTagName("schedule");
					for (int i = 0; i < sList.getLength(); i++) {
						Node sNode = sList.item(i);
						if (sNode.getNodeType() == Node.ELEMENT_NODE) {
							Element sElement = (Element) sNode;
							String runType = sElement.getAttribute("type");
							String runTime = sElement.getAttribute("time");
							String runDays = sElement.getAttribute("days");
							SchedulTime taskScheduleTime = fixTaskDate(runType,
									runTime, runDays);
						
						}
					}
					
					
					allTaskDescriptions.add(taskdes);
					//descriptionTable.put(taskdes.getTaskId(), taskdes);
				}
				
			}
			

		} catch (ParserConfigurationException e) {
			throw new ConfigParseException(e);
		} catch (SAXException e) {
			throw new ConfigParseException(e);
		} catch (IOException e) {
			throw new ConfigParseException(e);
		} 
		for(Taskdescription td: allTaskDescriptions){
			ValidatorImpl.validateTasks(td);
		}
	}

	private List<String> fixDependencies(String dependency) {
		LinkedList<String> dependencies = new LinkedList<String>();
		for (String s : dependency.split(",")) {
			if (!s.isEmpty()) {
				dependencies.add(s);
			}
		}
		return dependencies;
	}

	private SchedulTime fixTaskDate(String runType, String runTime,
			String runDays) {
	
		scheduleTime.setType(runType);
		scheduleTime.setTime(runTime);
		LinkedList<String> weekDays = new LinkedList<String>();
		for (String s : runDays.split(",")) {
			weekDays.add(s);
		}
		scheduleTime.setDaysWeek(weekDays);
		return scheduleTime;
	}

	public List<Taskdescription> getTaskDescriptions() {
		return allTaskDescriptions;
	}

	public SchedulTime getScheduleTime() {
		return scheduleTime;
	}
	

}
