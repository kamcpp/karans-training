package traverser.khaleghi.impl;

import traverser.AbstractAggregator;
import traverser.ProcessResult;

public class FileSizeAggregator extends AbstractAggregator<Long> {

	private long sum;

	public FileSizeAggregator() {
		sum = 0;
	}

	@Override
	public void aggregate(ProcessResult result) {
		if (result instanceof FileSizeProcessResult) {
			sum += ((FileSizeProcessResult) result).getSize();
			return;
		}
		throw new ProcessResultNotSupportedException();
	}

	@Override
	public Long getResult() {
		return sum;
	}
}
