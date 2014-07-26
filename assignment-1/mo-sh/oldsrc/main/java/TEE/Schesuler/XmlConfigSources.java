package TEE.Schesuler;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.util.HashMap;

import org.xml.sax.InputSource;

public class XmlConfigSources implements TaskConfigSource {

	// private HashMap<String, List<String>> tasks;
	List<Taskdescription> allTaskDescriptions;

	// Taskdescription taskdescription;

	public XmlConfigSources() {
		// tasks = new HashMap<String, List<String>>();
		// taskdescription = new Taskdescription();
		allTaskDescriptions = new LinkedList<Taskdescription>();
	}

	/*
	 * public HashMap<String, List<String>> getTasks() { return tasks; }
	 * 
	 * public String getPackageNme() { return packageName; }
	 * 
	 * public String getClassName() { return className; }
	 * 
	 * public String getMethodName() { return methodName; }
	 * 
	 * public SchedulTime getTaskRuntime() { return taskScheduleTime; }
	 * 
	 * public String getAfterMethod() { return afterMethod; }
	 * 
	 * public List<String> getDependencies() { return dependencies; }
	 * 
	 * public String getBeforeMethod() { return beforeMethod; }
	 * 
	 * 
	 * public String getTaskId() { return taskId; }
	 * 
	 * public void setTaskId(String taskId) { this.taskId = taskId; }
	 */

	public void read(String fileName) {

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			InputStream inputStream = new FileInputStream(fileName);
			Reader reader = new InputStreamReader(inputStream, "UTF-8");
			InputSource is = new InputSource(reader);
			is.setEncoding("UTF-8");
			Document doc = dBuilder.parse(is);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("DOC");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					Taskdescription taskdes = new Taskdescription();

					taskdes.setBasePackageName(eElement
							.getElementsByTagName("base-package").item(0)
							.getTextContent());
					taskdes.setClassPackageName(eElement
							.getElementsByTagName("package").item(0)
							.getTextContent());

					taskdes.setTaskId(eElement.getElementsByTagName("TASK ID")
							.item(0).getTextContent());

					taskdes.setClassName(eElement
							.getElementsByTagName("TASK ID").item(1)
							.getTextContent());

					taskdes.setMethodName(eElement
							.getElementsByTagName("TASK ID").item(2)
							.getTextContent());

					taskdes.setBeforeMethod(eElement
							.getElementsByTagName("BEFORE").item(2)
							.getTextContent());
					taskdes.setAfterMethod(eElement
							.getElementsByTagName("AFTER").item(2)
							.getTextContent());

					String taskDependencies = eElement
							.getElementsByTagName("dependsOn").item(3)
							.getTextContent();
					taskdes.setDependencies(fixDependencies(taskDependencies));

					String runType = eElement.getElementsByTagName("type")
							.item(0).getTextContent();

					String runTime = eElement.getElementsByTagName("schedule")
							.item(0).getTextContent();
					String runDays = eElement.getElementsByTagName("days")
							.item(0).getTextContent();

					SchedulTime taskScheduleTime = fixTaskDate(runType,
							runTime, runDays);
					taskdes.setTimeTorun(taskScheduleTime);
					allTaskDescriptions.add(taskdes);

				}
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());

		}

	}

	private List<String> fixDependencies(String dependency) {
		LinkedList<String> dependencies = new LinkedList<String>();

		for (String s : dependency.split(",")) {
			dependencies.add(s);
		}
		return dependencies;
	}

	private SchedulTime fixTaskDate(String runType, String runTime,
			String runDays) {

		SchedulTime sc = new SchedulTime();
		sc.setType(runType);
		sc.setHours((Integer.parseInt(runTime.split(":")[0])));
		sc.setMinutes((Integer.parseInt(runTime.split(":")[1])));
		sc.setSeconds((Integer.parseInt(runTime.split(":")[2])));
		LinkedList<String> weekDays = new LinkedList<String>();
		for (String s : runDays.split(",")) {
			weekDays.add(s);
		}
		sc.setDaysWeek(weekDays);
		return sc;

	}

	public List<Taskdescription> getTaskDescriptions() {
		return allTaskDescriptions;
	}

}
