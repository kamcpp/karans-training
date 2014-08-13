package traverser.impl;

import traverser.Item;
import traverser.TraverseFilter;

public class FileTraverseFilter implements TraverseFilter {

	@Override
	public boolean isTraversable(Item it) {
		if (!(it instanceof FileItem)) {
			throw new ItemNotSupportedException();
		}
		FileItem item = (FileItem) it;
		return item.getFile().isDirectory()
				&& !item.getFile().getName().startsWith(".");
	}

	@Override
	public boolean shouldGetProcessed(Item it) {
		return !isTraversable(it);
	}
}
