package karans.s9.clientservermodel.client;

import karans.s9.clientservermodel.RequestListener;
import karans.s9.clientservermodel.ResponseListener;

public interface AppInterface extends ResponseListener {

	void addRequestListener(RequestListener listener);

	void setup();
}
