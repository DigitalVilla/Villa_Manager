package model.persistence;

import java.util.List;

/**
 * @version 1.0
 * Class Description:  
 *
 */
public interface Broker {
	/**
	 * Persists new object to database or persists modifications to existing object in the database
	 * @param o Object to be persisted
	 * @return true if the modification was successful, otherwise false
	 */
	public boolean persist(Object o);

	/**
	 * Searches database and returns a list of matching objects
	 * @param searchItem item to search for
	 * @param type the search type
	 * @return a list of matching objects matching the search criteria
	 */
	public List search(String searchItem, String type);

	/**
	 * Deletes the specified object from the database.
	 * @param o Object to be deleted
	 * @return true if object specified was removed, false otherwise
	 */
	public boolean remove(Object o);

	/**
	 * Releases resources allocated to the broker and saves (commits) all modified data to database.
	 */
	public void closeBroker();
}


