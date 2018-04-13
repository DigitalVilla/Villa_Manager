package model.persistence.clientale;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import formatColumns.Column;
import model.exceptions.InvalidIdException;
import model.exceptions.clientale.InvalidPhoneNumberException;
import model.exceptions.clientale.InvalidPostalCodeException;
import model.problemDomain.clientale.*;
import model.persistence.Broker;

/**
 * An implementation of the abstract class that regulates how the client RandomAccessFile database is accessed by the GUI ClientScreen.
 * @author 767110
 *
 */
public class ClientBroker implements Broker  {
	private static final String	INPUT_FILE = "res/clients.txt"; 
	private static final String	RANDOM_FILE ="res/clients.bin"; 
	private static ClientBroker cb; 
	private RandomAccessFile raf; 
	private long maxId;


	/**
	 * Creates a ClientBroker object.
	 * @throws FileNotFoundException if the binary file clients.bin is not found or 
	 * the file path specified is not found.
	 */
	private ClientBroker() throws FileNotFoundException{
		raf = new RandomAccessFile(RANDOM_FILE,"rw");
	}

	/**
	 * Returns a single reference to the ClientBroker object.
	 * @return the reference to the ClientBroker object.
	 */
	public static ClientBroker getBroker() {
		File file = new File(RANDOM_FILE);
		try {				
			if(file.exists()) {
				if (cb == null) {
					cb = new ClientBroker();
				}
			} else 	{
				if (cb == null) {
					cb = new ClientBroker();
					cb.loadBinaryFile();
				}		
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file was not not found: res/clients.bin");
			e.printStackTrace();
		}
		cb.setMaxId();
		return cb;
	}

	@Override
	public List search(String search, String type) {
		ArrayList<Client> myList = new ArrayList<Client>();
		if (type.equalsIgnoreCase("id")) 
			return this.searchBy(myList, search,"getId");
		if (type.equalsIgnoreCase("name")) 
			return this.searchBy(myList, search,"getLastName");
		if (type.equalsIgnoreCase("type")) 
			return this.searchBy(myList, search,"getClientType");
		return myList;
	}



	@Override
	public boolean remove(Object obj) {
		try	{
			long offSet = searchById(((Client) obj).getId());
			if(offSet >= 0)	{
				raf.seek(offSet);
				raf.writeBoolean(false);
				return true;
			}
		} catch (IOException e)	{
			e.printStackTrace();
			return false;
		}
		return false;
	}


	@Override
	public boolean persist(Object object) {
		Client c = (Client) object;
		try {
			if (c.getId() == 0) {
				c.setId(++maxId);
				raf.seek(raf.length());
				writeRecord(c);
				return true;
			} else {
				raf.seek(searchById(c.getId()));
				writeRecord(c);
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void closeBroker() {
		try {
			raf.close();
			cb = null;
		}
		catch (IOException e) {
			System.out.println("Failed to close ClientBroker properly - data may be lost.");
			e.printStackTrace();
		}
	}

	
	/**
	 * Method to search for the client id , type and name, and returns all matching results as a list to the calling method.
	 * @param myLsit ArrayList to contain all clients found.
	 * @param search search parameter of client id
	 * @param method Method to reflect ("getId", "getClienType", "getLastName")
	 * @return an ArrayList of all clients found.
	 */
	private List searchBy(ArrayList<Client> myLsit,String search, String method){
		try	{
			long i = 0L;
			raf.seek(i);
			Method obj = null;
			Client c = new Client();
			obj = c.getClass().getMethod(method);			
			for(; i < raf.length(); i += Client.SIZE) {
				c = readRecord();
				if((obj.invoke(c)+"").equalsIgnoreCase(search) && c.isActive())
					myLsit.add(c);
			}
		}
		catch(IOException | NoSuchMethodException | SecurityException | IllegalAccessException |InvalidIdException
				| InvalidPostalCodeException | InvalidPhoneNumberException | IllegalArgumentException | InvocationTargetException e){
			e.printStackTrace();
		}

		return myLsit;
	}
	
	
	/**
	 * Method to open the text file and transfer the data to a binary file as
	 * a RandomAccessFile.
	 */
	private void loadBinaryFile() {
		long id = 1;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
			String line = reader.readLine();
			while (line != null) {
				//append Id
				line = (id++) + ";" + line;
				Client c = new Client(line);
				writeRecord(c);
				line = reader.readLine();
			}
			reader.close();
		}
		catch (IOException | InvalidIdException | InvalidPostalCodeException | InvalidPhoneNumberException e ) {
			e.printStackTrace(); 
		}		
	}
	/**
	 * Method to read a Client object from the RandomAccessFile.
	 * @return the Client record as an object read the file.
	 * @throws IOException when access to the file is lost.
	 * @throws InvalidIdException 
	 */
	private Client readRecord() throws InvalidIdException, IOException, InvalidPostalCodeException, InvalidPhoneNumberException {
		Client c = new Client();
		c.setActive(raf.readBoolean()); //1
		c.setId(raf.readLong());//8
		c.setFirstName(raf.readUTF().trim()); //22
		c.setLastName(raf.readUTF().trim()); // 22
		c.setAddress(raf.readUTF().trim()); // 52 
		c.setPostalCode(raf.readUTF().trim()); // 9 
		c.setPhoneNumber(raf.readUTF().trim()); //14
		c.setClientType(raf.readChar()); //2
		return c;
	}
	/**
	 * Method to write a Client object to the RandomAccessFile
	 * at the current position of the FilePointer.
	 * @throws IOException when access to the file is lost.
	 */
	private void writeRecord(Client c) throws IOException {
		raf.writeBoolean(c.isActive()); //1
		raf.writeLong(c.getId());//8
		raf.writeUTF(Column.leftJustify(c.getFirstName(),20)); //22
		raf.writeUTF(Column.leftJustify(c.getLastName(),20)); // 22
		raf.writeUTF(Column.leftJustify(c.getAddress(),50)); // 52 
		raf.writeUTF(Column.leftJustify(c.getPostalCode(),7)); // 9 
		raf.writeUTF(Column.leftJustify(c.getPhoneNumber(),12)); //14
		raf.writeChar(c.getClientType()); //2
	}

	/**
	 * Method to search for the last highest id assigned and save it in the class level attribute highId.
	 */
	private void setMaxId() {
		try {
			this.maxId = raf.length() / Client.SIZE;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to locate a Client record in the RandomAccessFile given the
	 * id of the Client item to find.
	 * @param id the id of the Client to locate
	 * @return the byte offset from the beginning of the RandomAccessFile
	 * or -1 if no match is found. 
	 */
	public long searchById(long id) {
		try	{
			raf.seek(0L);
			for(long i = 0L; i < raf.length(); i += Client.SIZE) {
				Client c = readRecord();
				if(c.getId() == id && c.isActive())
					return i;
			}
		}
		catch (IOException | InvalidPostalCodeException | InvalidPhoneNumberException | InvalidIdException e) {
			e.printStackTrace();
			return -1L;
		} 
		return -1L;
	}
}
