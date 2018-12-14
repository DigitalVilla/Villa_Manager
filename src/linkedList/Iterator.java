package linkedList;

import java.util.NoSuchElementException;

/**
 * This interface will provide an mono-directional iterator for any of the
 * Linear ADT's that are specified in this package. The implementor is only
 * responsible for the simple methods. A more functional iterator is available
 * in the <code>java.util</code> package.
 * 
 * Created on: 1-Jun-2004
 * Updated on: 21-Nov-2008
 * 
 * @author Don Heninger, Alex Peterson & Dave Watson
 * @version 1.1
 * 
 * @param <E> The type of element this iterator returns. 
 */
public interface Iterator<E> 
{	
	/**
	 * Returns <code>true</code> if the iteration has more elements. 
	 * (In other words, returns <code>true</code> if <code>next()</code> 
	 * would return an element rather than throwing an exception.)
	 * 
	 * @return <code>true</code> if the iterator has more elements.
	 */
	public boolean hasNext();
	
	
	/**
	 * Returns the next element in the iteration.
	 * 
	 * @return The next element in the iteration.
	 * @throws NoSuchElementException
	 * 			If the iteration has no more elements.
	 */
	public E next() throws NoSuchElementException;
}
