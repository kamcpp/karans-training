package karans.s9.clientservermodel.client;

import karans.s9.clientservermodel.ConnectorRequest;
import karans.s9.clientservermodel.ConnectorResponse;

public interface ConnectorListener {

	void processRequest(ConnectorRequest request);

	void processResponse(ConnectorResponse response);
}
