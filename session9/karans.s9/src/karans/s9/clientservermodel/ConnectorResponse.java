package karans.s9.clientservermodel;

public interface ConnectorResponse {

	UniqueId getId();

	Connector getConnector();

	byte[] getBytes();
}
