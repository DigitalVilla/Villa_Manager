package linkedList;

public class DLLNode<E> {
	Object element;
	DLLNode<E> next;
	DLLNode<E> prev;

	public DLLNode(E element) {
		this.element = element;
	}
 
	public DLLNode(E element, DLLNode<E> prev, DLLNode<E> next) {
		this.element = element;
		this.prev = prev;
		this.next = next;
	}

}
