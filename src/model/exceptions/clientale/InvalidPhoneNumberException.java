package model.exceptions.clientale;

public class InvalidPhoneNumberException extends Exception {
	public InvalidPhoneNumberException () {

	} 
	public InvalidPhoneNumberException (String string) {
		super(string);

	}
}