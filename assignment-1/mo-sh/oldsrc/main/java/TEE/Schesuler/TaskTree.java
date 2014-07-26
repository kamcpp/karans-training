package TEE.Schesuler;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskTree<T> implements Iterable<TaskTree<T>> {

    T data;
    TaskTree<T> parent;
    List<TaskTree<T>> children;

    public TaskTree(T data) {
        this.data = data;
        this.children = new LinkedList<TaskTree<T>>();
    }

    public TaskTree<T> addChild(T child) {
    	TaskTree<T> childNode = new TaskTree<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }

	public Iterator<TaskTree<T>> iterator() {
	return null;

	}
}