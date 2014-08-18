package karans.s9.clientservermodel;

public interface Protocol {

	void validate(ConnectorRequest connectorRequest);

	Request unmarshalRequest(ConnectorRequest connectorRequest);

	ConnectorRequest marshalRequest(Request request);

	Response unmarshalResponse(ConnectorResponse connectorResponse);

	ConnectorResponse marshalResponse(Response response);

}
