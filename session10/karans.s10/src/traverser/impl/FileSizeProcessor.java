package traverser.impl;

import traverser.AbstractItemProcessor;
import traverser.Item;
import traverser.ProcessResult;
import traverser.khaleghi.impl.FileSizeProcessResult;

public class FileSizeProcessor extends AbstractItemProcessor {

	@Override
	protected ProcessResult internalProcess(Item it) {
		if (it instanceof FileItem) {
			return new FileSizeProcessResult(((FileItem) it).getFile()
					.getTotalSpace());
		}
		throw new ItemNotSupportedException();
	}
}
