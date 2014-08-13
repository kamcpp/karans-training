package traverser;

public interface ItemProcessor {

	void process(Item it);
	
	void registerProcessFinishedListener(ProcessFinishedListener listener);

}
