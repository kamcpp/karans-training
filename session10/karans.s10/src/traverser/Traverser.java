package traverser;

public interface Traverser {

	void traverse();

	void traverse(Item item);

	TraverseResult getResult();
}
