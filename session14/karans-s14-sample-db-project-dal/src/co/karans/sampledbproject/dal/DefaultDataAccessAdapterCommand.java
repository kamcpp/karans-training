package co.karans.sampledbproject.dal;

import java.util.ArrayList;
import java.util.List;

public class DefaultDataAccessAdapterCommand implements
		DataAccessAdapterCommand {

	private String command;
	private List<Object> parameters;

	public DefaultDataAccessAdapterCommand(String command,
			List<Object> parameters) {
		this.command = command;
		this.parameters = new ArrayList<Object>(parameters);
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public List<Object> getParameters() {
		if (parameters == null) {
			parameters = new ArrayList<Object>();
		}
		return parameters;
	}
}
