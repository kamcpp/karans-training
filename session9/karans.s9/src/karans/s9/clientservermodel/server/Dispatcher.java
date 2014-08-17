package karans.s9.clientservermodel.server;

import karans.s9.clientservermodel.ConnectorRequest;

public interface Dispatcher {

	void submit(ConnectorRequest connectorRequest);
}
