package model.problemDomain.property;

import model.exceptions.property.InvalidLegalDescriptionException;

public class CommercialProperty extends Property {
	private static final long serialVersionUID = -2094286967097053708L;
	private String type;
	private int floors;
	
	public CommercialProperty() {
		
	}
	
	/**
	 * @param line an array of strings with all the required values
	 * @throws InvalidLegalDescriptionException
	 */
	public CommercialProperty(String[] line) throws InvalidLegalDescriptionException  {	
		super(Long.parseLong(line[0]),line[1],line[2],line[3],line[4],Double.parseDouble(line[5]),line[6]);
		this.floors = Integer.parseInt(line[8]);
		this.type =line[7];
	}
	/**
	 * @param id unique value calculated or enter zero if new property.
	 * @param legalDescription property description of max. 20 characters.
	 * @param address  property address of max. 80 characters.
	 * @param quadrant city location with valid entries NE,NW,SE,SW.
	 * @param zone applied zoning with valid entries R1,R2,R3,R4,I1,I2,I3,I4.
	 * @param price price property is listed for.
	 * @param comments  general comments on the property.
	 * @param type property type as either 'm' manufacturing or 'o' office.
	 * @param noFloors  number of floors in building.
	 * @throws InvalidLegalDescriptionException
	 */
	public CommercialProperty(long id, String legalDescription, String address, String quadrant, String zone, double askingPrice,String comments,
			String type, int floors) throws InvalidLegalDescriptionException {
		super(id,legalDescription,address,quadrant,zone,askingPrice,comments);
		this.floors = floors;
		this.type =type;
	}

	/**
	 * @return floors
	 */
	public int getNoFloors() {
		return this.floors;
	}

	/**
	 * @param floors 
	 */
	public void setNoFloors(int floors) {
		this.floors = floors;
	}

	/**
	 * @return type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return super.toString() + "  Type: " + this.type + "  Floors: " + this.floors;
	}
}

