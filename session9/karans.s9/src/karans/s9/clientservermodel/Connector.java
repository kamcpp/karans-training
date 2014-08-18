package karans.s9.clientservermodel;

public interface Connector {

	void setup();

	void accept();

	void submitResponse(UniqueId id, ConnectorResponse connectorResponse);

	void destroy(UniqueId clientId);

	void submitRequest(UniqueId id, ConnectorRequest connectorRequest);
}
