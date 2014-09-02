package karans.s16.calculator;

import java.util.Hashtable;
import java.util.Map;

public class Errors {

	private Map<String, String> errors;

	public Errors() {
		errors = new Hashtable<String, String>();
	}

	public void addError(String field, String message) {
		errors.put(field, message);
	}

	public boolean hasAnyErrors() {
		return errors.size() > 0;
	}
}
