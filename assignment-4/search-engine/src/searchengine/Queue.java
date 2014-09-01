package searchengine;



public interface Queue {
	void inq(String url);

	String deq();

	int getSize();
}
