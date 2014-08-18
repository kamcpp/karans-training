package karans.s9.clientservermodel.client;

import java.util.ArrayList;
import java.util.List;

import karans.s9.clientservermodel.Request;
import karans.s9.clientservermodel.RequestListener;

public abstract class AbstractAppInterface implements AppInterface {

	private List<RequestListener> listeners;

	public AbstractAppInterface() {
		listeners = new ArrayList<RequestListener>();
	}

	@Override
	public void addRequestListener(RequestListener listener) {
		listeners.add(listener);
	}

	protected void notifyRequestListeners(Request request) {
		for (RequestListener listener : listeners) {
			listener.processRequest(request);
		}
	}
}
