package rpc.serverside;

public class Response {
	
	private String responseString;

	public String getResponseString() {
		return responseString;
	}

	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}
	
	
	@Override
	public String toString(){
		return "<response><result>"+ responseString+ "/result></response>\r\n";
		
	}
	
	

}
