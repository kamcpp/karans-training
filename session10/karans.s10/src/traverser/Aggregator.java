package traverser;

public interface Aggregator<ResultType> extends ProcessFinishedListener {

	void aggregate(ProcessResult result);

	ResultType getResult();
}
