package model.persistence.property;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import linkedList.SLL;
import model.persistence.Broker;
import model.problemDomain.property.CommercialProperty;
import model.problemDomain.property.Property;
import model.exceptions.property.InvalidLegalDescriptionException;

/**
 * An implementation of the Broker interface that regulates the persistence of commercial properties.
 *
 */
public class CommercialPropertyBroker implements Broker {
	private static final String	INPUT_FILE = "res/comprop.txt"; 
	private static final String	SER_FILE ="res/comprop.ser"; 
	private static CommercialPropertyBroker cb;
	private long nextId;
	private SLL myList;
	
	
	/**
	 * Default Constructor
	 */
	private CommercialPropertyBroker() {
		myList = new SLL();
		nextId = 0;
	}
		
	 /**
	 * @return
	 */
	public static CommercialPropertyBroker getBroker() {
		File file = new File(SER_FILE);
		if (file.exists()) {
			if (cb == null) {
				cb = new CommercialPropertyBroker();
				try {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SER_FILE));
					cb.myList.append((ArrayList) ois.readObject()); 
					ois.close();
				}
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				cb.setNextId();
			}
		} else if (cb == null) {
			cb = new CommercialPropertyBroker();
			cb.loadSerFile();
			cb.setNextId();
		}
		return cb;
	}

	@Override
	public boolean persist(Object object) {
		CommercialProperty cp = (CommercialProperty)object;
		if (cp.getId() == 0) {
			cp.setId(nextId++);
			return myList.append(cp);
		} else {
			for (int i = 0; i < myList.size(); i++) 
				if ((cp = (CommercialProperty) myList.get(i)).getId() == ((Property) object).getId())break;
			return ((object = (CommercialProperty)myList.set(object,myList.indexOf(cp))) != null);
		}
	}

	@Override
	public boolean remove(Object object) {
		return ((object =myList.remove(myList.indexOf(object))) != null)?true:false;
	}

	@Override
	public List search(String search, String type) {
		SLL theList = new SLL();
		if (type.equalsIgnoreCase("id")) 
			return searchBy(theList, search,"getId");
		if (type.equalsIgnoreCase("price")) 
			return searchBy(theList, search,"getAskingPrice");
		if (type.equalsIgnoreCase("quadrant")) 
			return searchBy(theList, search,"getQuadrant");
		if (type.equalsIgnoreCase("legal description")) 
			return searchBy(theList, search,"getLegalDescription");
		return theList.getList();
	}

	private List searchBy(SLL theList, String search, String method) {
		Method obj = null;
		CommercialProperty cp = null;
		for (int i = 0; i <myList.size(); i++) {
			cp = (CommercialProperty)this.myList.get(i); 
			try {
				obj = cp.getClass().getMethod(method);
				if (!method.equals("getAskingPrice")) {
					if((obj.invoke(cp)+"").equalsIgnoreCase(search))
						theList.append(cp);					
				} else if(Double.parseDouble(obj.invoke(cp)+"") <= Double.parseDouble(search))
						theList.append(cp);	
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return theList.getList();
	}

	@Override
	public void closeBroker() {
		saveSerFile();
		cb = null;
	}

	/**
	 * Method fills a Singly Linked List as a data structure to store
	 * commercial property information in a object format. 
	 * This method is then used to create a serialized file 
	 * if no serialized file for the commercial property currently exists.
	 */
	private void loadSerFile() {
		this.myList = new SLL();
		try {
			String str;
			BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
			while ((str = reader.readLine()) != null) {
				str = ++this.nextId+";"+str;
				String[] line = str.split(";");
				CommercialProperty pro = new CommercialProperty(line);
				this.myList.append(pro);
			}
			reader.close();
			saveSerFile();
			return;
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			return;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		catch (IOException e) {
			e.printStackTrace();
			return;
		}
		catch (InvalidLegalDescriptionException e) {
			e.printStackTrace();
			return;
		}
	}

	/**
	 * Method to search for the last highest id assigned and save it in the class level attribute nextId.
	 */
	private void setNextId() {
		nextId = (((CommercialProperty)myList.getLast()).getId()) + 1;
	}

	/**
	 * Method saves the propertyList to a serialized linked list file.
	 */
	private void saveSerFile() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SER_FILE));
			oos.writeObject(this.myList.getList());
			oos.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}


