package traverser;

public abstract class AbstractAggregator<ResultType> implements Aggregator<ResultType> {

	@Override
	public void processFinished(ProcessResult result) {
		aggregate(result);
	}
}
