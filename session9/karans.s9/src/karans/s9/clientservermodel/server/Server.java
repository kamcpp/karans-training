package karans.s9.clientservermodel.server;

import karans.s9.clientservermodel.Connector;

public class Server {

	private Connector connector;

	public void start() {
		connector.setup();
		new Thread(new Runnable() {

			@Override
			public void run() {
				connector.accept();
			}
		}).start();
	}
}
