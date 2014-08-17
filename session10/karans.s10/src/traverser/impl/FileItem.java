package traverser.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import traverser.Item;

public class FileItem implements Item {

	private File file;

	public FileItem(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	@Override
	public List<Item> getChildren() {
		List<Item> children = new ArrayList<Item>();
		for (File child : this.file.listFiles()) {
			children.add(new FileItem(child));
		}
		return children;
	}

	@Override
	public String toString() {
		return file.getPath();
	}
}
