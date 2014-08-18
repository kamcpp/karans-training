package karans.s9.clientservermodel;

import karans.s9.clientservermodel.Connector;

public interface ConnectorRequest {

	byte[] getBytes();
	
	Connector getConnector();
	
	UniqueId getId();
	
}
