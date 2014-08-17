package rpc.serverside;

public class MyBeanImpl implements MyBean{
	
	private String response;

	public String getString() {
		return "this is a server side getstring method";
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	

}
