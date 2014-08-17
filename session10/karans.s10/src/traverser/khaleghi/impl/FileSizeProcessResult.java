package traverser.khaleghi.impl;

import traverser.ProcessResult;

public class FileSizeProcessResult implements ProcessResult {

	private long size;

	public FileSizeProcessResult(long size) {
		setSize(size);
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
}
