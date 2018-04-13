package model.persistence.property;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import linkedList.SLL;
import java.io.*;
import model.persistence.Broker;
import model.problemDomain.property.Property;
import model.problemDomain.property.ResidentialProperty;
import model.exceptions.property.InvalidLegalDescriptionException;
import model.exceptions.property.InvalidNumberOfBathroomsException;

/**
 * An implementation of the Broker interface that regulates the persistence of residential properties
 *
 */
/**
 * @author 767110
 *
 */
public class ResidentialPropertyBroker implements Broker {
	private static final String	INPUT_FILE = "res/resprop.txt"; 
	private static final String	SER_FILE ="res/resprop.ser"; 
	private static ResidentialPropertyBroker rb;
	private long nextId;
	private SLL myList;


	/**
	 * Initialize Linkedlist and set id to 0;
	 */
	private ResidentialPropertyBroker() {
		myList = new SLL();
		nextId = 0;
	}

	public static ResidentialPropertyBroker getBroker() {
		File file = new File(SER_FILE);
		if (file.exists()) {
			if (rb == null) {
				rb = new ResidentialPropertyBroker();
				try {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SER_FILE));
					rb.myList.append((ArrayList) ois.readObject()); 
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
				rb.setNextId();
			}
		} else if (rb == null) {
			rb = new ResidentialPropertyBroker();
			rb.loadSerFile();
			rb.setNextId();
		}
		return rb;
	}

	@Override
	public boolean persist(Object object) {
		ResidentialProperty cp = (ResidentialProperty)object;
		if (cp.getId() == 0) {
			cp.setId(this.nextId++);
			return this.myList.append(cp);
		} else {
			for (int i = 0; i < this.myList.size(); i++) 
				if (((cp = (ResidentialProperty) this.myList.get(i))).getId() == ((Property) object).getId()) break;			
			return ((object = (ResidentialProperty)this.myList.set(object,myList.indexOf(cp))) != null);
		}
	}

	@Override
	public boolean remove(Object object) {
		int n = this.myList.indexOf(object);
		return ((object = this.myList.remove(n)) != null)?true:false;
	}

	@Override
	public List search(String search, String type) {
		SLL theList = new SLL();
		if (type.equalsIgnoreCase("id")) 
			return this.searchBy(theList, search,"getId");
		if (type.equalsIgnoreCase("price")) 
			return this.searchBy(theList, search,"getAskingPrice");
		if (type.equalsIgnoreCase("quadrant")) 
			return this.searchBy(theList, search,"getQuadrant");
		if (type.equalsIgnoreCase("legal description")) 
			return this.searchBy(theList, search,"getLegalDescription");
		return theList.getList();
	}

	private List searchBy(SLL theList, String search, String method) {
		Method obj = null;
		ResidentialProperty cp = null;
		for (int i = 0; i < this.myList.size(); i++) {
			cp = (ResidentialProperty)this.myList.get(i); 
			try {
				obj = cp.getClass().getMethod(method);
				if (method.equals("getAskingPrice") && Double.parseDouble(obj.invoke(cp)+"") <= Double.parseDouble(search))
						theList.append(cp);	
				if ((obj.invoke(cp)+"").equalsIgnoreCase(search))
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
		rb = null;
	}

	/**
	 * Method fills a Singly Linked List as a data structure to store
	 * residential property information in a object format. 
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
//				System.out.println(line[1]);
				ResidentialProperty pro = new ResidentialProperty(line);
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
		} catch (InvalidNumberOfBathroomsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to search for the last highest id assigned and save it in the class level attribute nextId.
	 */
	private void setNextId() {
		nextId = (((ResidentialProperty) this.myList.getLast()).getId()) + 1;
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

