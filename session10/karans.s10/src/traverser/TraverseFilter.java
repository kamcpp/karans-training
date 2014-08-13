package traverser;

public interface TraverseFilter {

	boolean isTraversable(Item it);

	boolean shouldGetProcessed(Item it);

}
