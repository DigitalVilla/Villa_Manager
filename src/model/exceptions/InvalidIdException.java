package model.exceptions;



public class InvalidIdException extends Exception {
	public InvalidIdException () {

	}

	public InvalidIdException (String string) {
        super(string);
	}

}
