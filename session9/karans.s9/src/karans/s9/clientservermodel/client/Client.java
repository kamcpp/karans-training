package karans.s9.clientservermodel.client;

public class Client {

	private AppInterface appInterface;
	private Communicator communicator;

	public void start() {
		appInterface.setup();
		appInterface.addRequestListener(communicator);
		communicator.addResponseListener(appInterface);
	}
}
