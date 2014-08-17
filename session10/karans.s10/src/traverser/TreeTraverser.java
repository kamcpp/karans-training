package traverser;

import org.springframework.beans.factory.annotation.Autowired;

public class TreeTraverser implements Traverser {

	@Autowired
	private TraverseFilter filter;
	@Autowired
	private ItemProcessor processor;
	@Autowired
	private ItemFactory itemFactory;
	@Autowired
	private Aggregator<?> aggregator;

	public void traverse() {
		traverse(itemFactory.getDefaultItem());
	}

	@Override
	public void traverse(Item item) {
		for (Item it : item.getChildren()) {
			if (filter.isTraversable(it)) {
				traverse(it);
			}
			if (filter.shouldGetProcessed(it)) {
				processor.registerProcessFinishedListener(aggregator);
				processor.process(it);				
			}
		}
	}

	@Override
	public TraverseResult getResult() {
		// TODO Auto-generated method stub
		return null;
	}
}
