package traverser.impl;

import java.io.File;

import traverser.Item;
import traverser.ItemFactory;

public class FileItemFactory implements ItemFactory {

	@Override
	public Item getDefaultItem() {
		return createByPath("/home/morteza");
	}

	public FileItem createByPath(String path) {
		return new FileItem(new File(path));
	}
}
