package model.problemDomain.property;

import java.io.Serializable;
import model.exceptions.property.*;

public abstract class Property	implements Serializable {
	private static final long serialVersionUID = -162935740478840755L;
	private String legalDescription;
	private double askingPrice;
	private String comments;
	private String quadrant;
	private String address;
	private String zone;
	private long id;

	public Property() {
	}

	/**
	 * @param id unique value calculated or enter zero if new property.
	 * @param legalDescription property description of max. 20 characters.
	 * @param address  property address of max. 80 characters.
	 * @param quadrant city location with valid entries NE,NW,SE,SW.
	 * @param zone applied zoning with valid entries R1,R2,R3,R4,I1,I2,I3,I4.
	 * @param price price property is listed for.
	 * @param comments  general comments on the property.
	 * @throws InvalidLegalDescriptionException
	 */
	public Property (long id, String legalDescription, String address, String quadrant, String zone, double price, String comments)throws InvalidLegalDescriptionException {
		setLegalDescription(legalDescription);
		this.comments = comments;
		this.askingPrice = price;
		this.quadrant =quadrant;
		this.address = address;
		this.zone = zone;
		setId(id);
	}

	public void setLegalDescription(String legal) throws InvalidLegalDescriptionException {	
		String pattern = "^[0-9]{1,4}[A-Z]{1}[0-9]{1,4}[-]{1}[0-9]{1,2}$";
		if (!(legal.matches(pattern))) {
			throw new InvalidLegalDescriptionException("Legal description: [0-9999][A-Z][0-9999][-][0-99]");
		}
		this.legalDescription = legal;
	}
	
	
	/**
	 * Unique identifier for each property. Self generated field.
	 * When adding a property enter 0 the id will be calculated.
	 * For searching the id may be specified to find a unique record.
	 * @param id
	 */
	public void setId(long id) {
		if (id > 0)	this.id = id;
	}
	
	/**
	 * this method returns 
	 * @return id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @return legalDescription
	 */
	public String getLegalDescription() {
		return legalDescription;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return quadrant
	 */
	public String getQuadrant() {
		return quadrant;
	}
	/**
	 * @param quadrant
	 */
	public void setQuadrant(String quadrant) {
		this.quadrant = quadrant;
	}
	/**
	 * @return zone
	 */
	public String getZone() {
		return zone;
	}
	/**
	 * @param zone
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}
	/**
	 * @return askingPrice
	 */
	public double getAskingPrice() {
		return askingPrice;
	}
	/**
	 * @param askingPrice
	 */
	public void setAskingPrice(double askingPrice) {
		this.askingPrice = askingPrice;
	}
	/**
	 * @return comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "\nId: " + this.id + "  Legal description: " + this.legalDescription + "  Address: " + this.address + "  Quadrant " + this.quadrant + "  Asking price: " + this.askingPrice + "  Comments : " + this.comments;
	}
}
