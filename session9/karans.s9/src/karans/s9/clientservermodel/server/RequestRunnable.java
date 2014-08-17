package karans.s9.clientservermodel.server;

import karans.s9.clientservermodel.ConnectorRequest;
import karans.s9.clientservermodel.ConnectorResponse;
import karans.s9.clientservermodel.KeepAliveRequest;
import karans.s9.clientservermodel.Protocol;
import karans.s9.clientservermodel.Request;
import karans.s9.clientservermodel.Response;
import karans.s9.clientservermodel.Service;

public class RequestRunnable implements Runnable {

	private ConnectorRequest connectorRequest;
	private Protocol protocol;
	private ServiceFactory serviceFactory;

	public RequestRunnable(ConnectorRequest connectorRequest) {
		this.connectorRequest = connectorRequest;
	}

	public Protocol getProtocol() {
		return protocol;
	}

	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}

	public ServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(ServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	@Override
	public void run() {
		protocol.validate(connectorRequest);
		Request request = protocol.unmarshalRequest(connectorRequest);
		Service service = serviceFactory.create();
		Response response = service.process(request);
		ConnectorResponse connectorResponse = protocol.marshalResponse(response);
		connectorRequest.getConnector().submitSend(
				connectorRequest.getClientId(), connectorResponse);
		boolean shouldKeepClient = false;
		if (request instanceof KeepAliveRequest) {
			shouldKeepClient = ((KeepAliveRequest) request).keepAlive();
		}
		if (!shouldKeepClient) {
			connectorRequest.getConnector().destroy(
					connectorRequest.getClientId());
		}
	}
}
