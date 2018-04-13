package model.problemDomain.clientale;

import model.exceptions.InvalidIdException;
import model.exceptions.clientale.*;

/**
 * A Client object is a representation of client data. The client is represented by a membership id,
 * last name, first name, address, phone number, client type and active record status.
 * @author 767110
 *
 */
/**
 * @author 767110
 *
 */
public class Client{
	public static final int SIZE = 130; 
	private long id;//8
	private String lastName; // 22
	private String firstName; //22
	private String address; // 52 
	private String postalCode; // 9 
	private String phone; //14
	private boolean active; //1
	private char type; //2

	/**
	 * Creates an instance of this object with default values.
	 */
	public Client() {
		this.active = true;
	}

	/**
	 * Creates an instance of this object with a specified list of initial values.
	 * @param id - Holds the client's membership number.
	 * @param firstName - Holds the client's first name.
	 * @param lastName - Holds the client's last name.
	 * @param address - Holds the client's address.
	 * @param postalCode - Holds the client's PO.
	 * @param phone - Holds the client's phone.
	 * @param type - Holds the client's type status R = residential and C = commercial.
	 * @throws InvalidIdException 
	 * @throws InvalidPhoneNumberException.
	 * @throws InvalidPostalCodeException.
	 */
	public Client(long id, String firstName, String lastName, String address, String postalCode, String phone, char type) throws InvalidPhoneNumberException,
	InvalidPostalCodeException, InvalidIdException {
		setId(id);
		this.address = address;
		this.lastName = lastName;
		this.firstName = firstName;
		this.type = type;
		setPostalCode(postalCode);
		setPhoneNumber(phone);
		this.active = true;
	}

	/**
	 * Creates an instance of this object with a specified list of initial values based on the string input..
	 * @param line Holds the customer's complete information
	 * @throws InvalidIdException
	 * @throws InvalidPostalCodeException 
	 * @throws InvalidPhoneNumberException 
	 */
	public Client(String line) throws InvalidIdException, InvalidPostalCodeException, InvalidPhoneNumberException {
		String[] fields = line.split(";");
		setId(fields[0]);
		this.firstName = fields[1];
		this.lastName = fields[2];
		this.address = fields[3];
		setPostalCode(fields[4]);
		setPhoneNumber(fields[5]);
		this.type = fields[6].charAt(0);
		this.active = true;
	}
	
	/**
	 * Sets the customer's membership id number.
	 * @param id - A String containing the customers membership id number.
	 */
	public void setId(String id) throws InvalidIdException {
		long myId = 0;
		try {
			myId = Long.parseLong(id);
		}
		catch(NumberFormatException e) {
			throw new InvalidIdException();
		}
		catch(NullPointerException e) {
			throw new InvalidIdException();
		}
		this.id = myId;
	}


	/**
	 * Sets the customer's membership id number.
	 * @param id - A long containing the customers membership id number.
	 */
	public void setId(long id){
		if (id > 0)
			this.id = id;
	}

	/**
	 * Sets the customer's current postal code.
	 * @param postalCode  A String containing the customers postal code
	 * @throws InvalidPostalCodeException
	 */
	public void setPostalCode(String postalCode ) throws InvalidPostalCodeException {
		String string2 = postalCode ;
		String string3 = "[A-Z][0-9][A-Z]\\s[0-9][A-Z][0-9]";
		if (!string2.matches(string3)) {
			throw new InvalidPostalCodeException("Postal Code does not match A9A 9A9 format.");
		}
		this.postalCode = postalCode ;
	}

	/**
	 * Sets the customer's current phone number.
	 * @param phone  A String containing the customers phone number
	 * @throws InvalidPostalCodeException
	 */
	public void setPhoneNumber(String phone) throws InvalidPhoneNumberException {
		String string2 = phone;
		String string3 = "(\\d{3}-\\d{3}-\\d{4})";
		if (!string2.matches(string3)) {
			throw new InvalidPhoneNumberException("Phone Number does not match 222-222-2222 format.");
		}
		this.phone = phone;
	}

	/**
	 * Returns the record's current status.
	 * @return A boolean containing the record's status
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the record's current status.
	 * @param active A boolean containing the record's status
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Sets the customer's firstName.
	 * @param firstName A String containing the firstName.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Sets the customer's lastName.
	 * @param lastName A String containing the customers lastName.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * Sets the customer's client type.
	 * @param type A String containing the customers type.
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * Sets the customer's client type.
	 * @param type A String containing the customers type.
	 */
	public void setClientType(char type) {
		this.type = type;
	}

	/**
	 * Returns the customer's membership id number.
	 * @return A String containing the customers membership id number.
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Returns the customer's type.
	 * @return A String containing the customers type
	 */
	public char getClientType() {
		return type;
	}
	
	/**
	 * Returns the customer's address.
	 * @return A String containing the customers address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Returns the customer's last name.
	 * @return A String containing the customers last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Returns the customer's first name.
	 * @return A String containing the customers first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Returns the customer's postal Code.
	 * @return A String containing the customers Postal Code
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * Returns the customer's Phone number.
	 * @return A String containing the customers phone number
	 */
	public String getPhoneNumber() {
		return phone;
	}
	
	
	@Override
	public boolean equals(Object object) {
		if (this.id == ((Client)object).getId()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "ID: " + this.id + "\nName: " + this.firstName + " " + this.lastName + "\nAddress: " + this.address + "\nPostal Code: " + this.postalCode + "\nPhone Number: " + this.phone + "\nClient Type: " + this.type + "\nStatus: " + this.active + "\n";
	}
}
