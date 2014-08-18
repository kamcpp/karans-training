package karans.s9.clientservermodel.client;

import java.util.ArrayList;
import java.util.List;

import karans.s9.clientservermodel.Connector;
import karans.s9.clientservermodel.ConnectorRequest;
import karans.s9.clientservermodel.ConnectorResponse;
import karans.s9.clientservermodel.Protocol;
import karans.s9.clientservermodel.Request;
import karans.s9.clientservermodel.RequestListener;
import karans.s9.clientservermodel.ResponseListener;

public class Communicator implements RequestListener, ConnectorListener {

	private Connector connector;
	private Protocol protocol;
	private List<ResponseListener> listeners;

	public Communicator() {
		listeners = new ArrayList<ResponseListener>();
	}

	public void addResponseListener(ResponseListener listener) {
		listeners.add(listener);
	}

	public void setup() {
		connector.setup();
		connector.addConnectorListener(this);
	}

	@Override
	public void processRequest(Request request) {
		ConnectorRequest connectorRequest = protocol.marshalRequest(request);
		connector.submitRequest(request.getId(), connectorRequest);
	}

	@Override
	public void processRequest(ConnectorRequest request) {
	}

	@Override
	public void processResponse(ConnectorResponse response) {
		
	}
}
