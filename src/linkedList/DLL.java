package linkedList;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class DLL<E> implements List<E> {
	/**
	 * If true null values can be stored in this list
	 * false otherwise
	 */
	boolean letNulls = false;
	/**
	 * 
	 */
	private DLLNode<E> head;
	/**
	 * 
	 */
	private DLLNode<E> tail;
	/**
	 * 
	 */
	private int size;
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		inBound(index, false);
		nullify(toAdd, false);
		if (index == size)
			return add(toAdd);
		if (index == 0)
			return addHead(toAdd);
		DLLNode<E> n = head;
		int i;
		for (i = 0; i < index; i++) {
			n = n.next;
		}
		DLLNode<E> newNode = new DLLNode<E>(toAdd, n.prev, n);
		n.prev.next = newNode;
		n.prev = newNode;
		size++;
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		nullify(toAdd, false);
		DLLNode<E> t = tail; 
		DLLNode<E> newNode = new DLLNode<E>(toAdd, t, null);
		tail = newNode;
		if (t == null) // empty array
			head = newNode;
		else // head and tail are pointing to the same address
			t.next = newNode;
		size++;
		return true;
	}

	@Override
	public boolean addAll(List<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null)
			throw new NullPointerException();
		for (int i = 0; i < toAdd.size(); i++) {
			add(toAdd.get(i));
		}
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		inBound(index, true);
		return (E) getNode(index).element;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		inBound(index, true);
		if (index == 0)
			return removeHead();
		if (index == size - 1)
			return removeTail();
		DLLNode<E> n = getNode(index);
		Object el = n.element;
		n.next.prev = n.prev;
		n.prev.next = n.next;
		n = null;
		size--;
		return (E) el;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		nullify(toRemove, false);
		int index = indexOf(toRemove);
		return (index == -1) ? null : remove(index);
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		inBound(index, true);
		add(index, toChange);
		return remove(index + 1);
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		nullify(toFind, false);
		return (finder(toFind) != -1);
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null)
			throw new NullPointerException();
		if (size > 0) {
			if (toHold.length < size)
				toHold = (E[]) Array.newInstance(toHold.getClass().getComponentType(), size);
			int index = 0;
			for (DLLNode<E> n = head; n != null; n = n.next)
				toHold[index++] = (E) n.element;
		}
		return toHold;
	}

	@Override
	public E[] toArray() {
		Object[] arr = new Object[size];
		if (size > 0) {
			int index = 0;
			for (DLLNode<E> n = head; n != null; n = n.next)
				arr[index++] = n.element;
		}
		return (E[]) arr;
	}

	@Override
	public Iterator<E> iterator() {
		return new myIterator();
	}

	@Override
	public String toString() {
		String a = "[";
		for (DLLNode<E> n = head; n != null; n = n.next)
			a += (n.element + ", ");
		a = (head != null) ? a.substring(0, (a.length() - 2)) + "]" : "[]";
		return a;
	}

	// adds before head
	private boolean addHead(E element) {
		DLLNode<E> newNode = new DLLNode<E>(element, null, head);
		head.prev = newNode;
		head = newNode;
		size++;
		return true;
	}

	private E removeHead() {
		Object el = head.element;
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			head.next.prev = null;
			head = head.next;
		}
		size--;
		return (E) el;
	}

	private E removeTail() {
		Object el = tail.element;
		tail.prev.next = null;
		tail = tail.prev;
		size--;
		return (E) el;
	}

//	/finds the first element 
	/**
	 * @param find
	 * @return
	 */
	private int indexOf(E find) {
		int index = 0;
		for (DLLNode<E> x = head; x != null; x = x.next) {
			if (find.equals(x.element))
				return index;
			index++;
		}
		return -1;
	}

//	Awesome dual search! for unique elements or first instance 
	/**
	 * @param find
	 * @return
	 */
	public int finder(E find) {
		int i = 0, j = size - 1;
		for (DLLNode<E> x = head, y = tail; i <= j; x = x.next, y = y.prev) {
			if (find.equals(x.element) || i++ > size)
				return i;
			if (find.equals(y.element) || j-- < 0)
				return j;
		}
		return -1;
	}

	/**
	 * returns anode using index
	 * 
	 * @param index
	 * @return the node
	 */
	private DLLNode<E> getNode(int index) {
		if (index < (size / 2)) {
			DLLNode<E> n = head;
			for (int i = 0; i < index; i++)
				n = n.next;
			return n;
		} else {
			DLLNode<E> n = tail;
			for (int i = size - 1; i > index; i--)
				n = n.prev;
			return n;
		}
	}

	/**
	 * @param toFind
	 * @param empty  true if it should throw error when an empty array.
	 * @throws NullPointerException
	 */
	private void nullify(E value, boolean empty) throws NullPointerException {
		if (empty && isEmpty())
			throw new NullPointerException();
		if (!letNulls && value == null)
			throw new NullPointerException();
	}

	/**
	 * @param index     the index to validate
	 * @param inclusive true if the index bound should include the size (i >= s)
	 *                  false if the index should not include size (i > s)
	 */
	private void inBound(int index, boolean inclusive) throws IndexOutOfBoundsException {
		if (inclusive && index >= size || index < 0)
			throw new IndexOutOfBoundsException();
		else if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
	}

	//////////////////
	public class myIterator<E> implements Iterator<E> {
		private int currentIndex = 0;
		private DLLNode<E> x = (DLLNode<E>) head;
		
		@Override
		public boolean hasNext() {
			return size > 0 && currentIndex < size && x != null;
		}

		@Override
		public E next() {
			if (currentIndex == size)
				throw new NoSuchElementException();
			++currentIndex;
			Object el = x.element;
			x = x.next;
			return (E) el;
		}
	}
}
