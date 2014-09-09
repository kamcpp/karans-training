package example.web.forms;

import javax.validation.constraints.NotNull;

import example.web.validation.annotation.EqualWith;
import example.web.validation.annotation.UniqueUser;

public class SignupForm {
	@NotNull
	private String name;
	private String family;
	@NotNull
	@UniqueUser
	private String username;
	@NotNull
	@EqualWith(field = "passwordConfirmation")
	private String password;
	private String passwordConfirmation;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	
	

	
}
