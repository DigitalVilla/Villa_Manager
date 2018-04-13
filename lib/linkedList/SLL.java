package linkedList;

import java.util.ArrayList;

/**
 * @author this is a nodeList implementation class
 *
 */
public class SLL implements List {

	/**
	 * tail will always keep track of last element 
	 * to save resources
	 */
	private SLLNode head;
	private SLLNode tail;
	private int size;
	
	//adds after tail 
	@Override
	public boolean append(Object element) {
		final SLLNode newNode = new SLLNode(element, null);
		if (head == null)
			head = newNode;
		else if (size == 1) {
			tail = newNode;
			tail.prev = head;
			head.next = tail;
		} else if (size > 1) {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		} 
		size++;
		return true;
	}

	//adds before head
	@Override
	public boolean add(Object element) {
		SLLNode newNode= new SLLNode(element, null);
		if(head==null)
			head=newNode;
		else if (size == 1) {
			tail = head;
			tail.prev = newNode; 
			newNode.next = tail;
			head = newNode;
		} else if (size > 1) {
			newNode.next = head;		
			head = newNode;
		} 
		size++;
		return true;
	}

	@Override
	public boolean add(Object element, int position) throws IndexOutOfBoundsException {
		if (position <0 || position > size)
			throw new IndexOutOfBoundsException();	
		if (position == size) append(element);
		else if (position == 0) add(element);
		else {
			int i = 0;
			SLLNode n = head;
			while (n!=null && i++ != position-1)
				n = n.next;
			SLLNode  newNode= new SLLNode(element, n.next);
			n.next = newNode;
			size++;
		}			
		return true;		
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	@Override
	public Object remove() {
		Object e = null; 
		if (size >=1) {	
			e= head.element;
			this.head = head.next;
			--size;
		}
		return e;
	}

	@Override
	public Object removeLast() {
		Object e = null; 
		if (size <2) 	
			return remove();
		if (size == 2) {
			e = tail.element;
			tail.prev = null;
			head.next = null; 
		} else if (size > 2) { 
			e = tail.element;
			tail = tail.prev;
			tail.next = null;
		}
		--size;	
		return e;
	}

	@Override
	public Object remove(int position) throws IndexOutOfBoundsException {
		if (position <0 || position >= size)
			throw new IndexOutOfBoundsException();	
		if (position == 0) return remove();
		if (position == size-1 && size > 3) return removeLast();
		Object e = null; 
		int i = 0;
		SLLNode n = head;
		while (n!=null && i++ != position-1)
			n = n.next;
		e = n.next.element;
		n.next = n.next.next;
		size--;
		return e;		
	}

	@Override
	public Object get() {
		return (head != null)?head.element:null;
	}

	@Override
	public Object getLast() {
		return (tail != null)?tail.element:get();
	}

	@Override
	public Object get(int position) throws IndexOutOfBoundsException {
		if (position <0 || position >= size)
			throw new IndexOutOfBoundsException();	
		if (position == 0) return get();
		if (position == size-1 && size >= 2) return getLast();
		Object e = null; 
		int i = 0;
		SLLNode n = head;
		while (n!=null && i++ != position-1)
			n = n.next;
		e = n.next.element;
		return e;	
	}

	@Override
	public Object set(Object element, int position) throws IndexOutOfBoundsException {
		if (position <0 || position >= size)
			throw new IndexOutOfBoundsException();	
		int i = 0;
		SLLNode n = head;
		while (n!=null && i++ != position)
			n = n.next;
		Object e = n.element;
		n.element = element;
		return e;	
	}

	@Override
	public boolean contains(Object element) {
		SLLNode n = head;
		while (n!=null && !n.element.equals(element))
			n = n.next;
		return (n!=null)?true:false;	
	}
	


	@Override
	public int indexOf(Object element) {
		int i = 0;
		SLLNode n = head;
		while (n!=null && !n.element.equals(element) && i++ > -1)
			n = n.next;
		return (n!=null)?i:-1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (head == null && size == 0)?true:false;
	}

	@Override
	public String toString(){
		SLLNode n = head;
		String a = "[";
		while(n!=null){
			a+=(n.element+", ");
			n=n.next;
		}
		a = (head!=null)?a.substring(0,(a.length()-2))+"]":"[]";		
		return a;
	}

	/**
	 *Method to append each element of an arrayList to the current SLL List.
	 *If the list is empty a new list will be created. If the list exist 
	 *the list will be appended to the current list 
	 *@param list - ArrayList of Objects to be added to this list
	 *@return - Count of the elements added  
	 */
	public int append(ArrayList<Object> list) {
		int count = 0;
		for(Object o: list)
			if (append(o) && ++count> 0);
		return count;
	}
	
	/**
	 *Method to append every element of the SLL list into an arrayList.
	 *If the list is empty an empty list will be returned 
	 *@return -an ArrayList of Objects 
	 */
	public ArrayList<Object> getList() {
		ArrayList<Object>  list = new ArrayList<Object> ();
		for (int i = 0; i < size; i++) {
			list.add(this.get(i));
		}
		return list;
	}
}
