package model.problemDomain.property;

import model.exceptions.property.InvalidLegalDescriptionException;
import model.exceptions.property.InvalidNumberOfBathroomsException;

/**
 * @author 767110
 *
 */
public class ResidentialProperty extends Property {

	private static final long serialVersionUID = -1976424532353685995L;
	private double bathrooms;
	private int bedrooms;
	private double area;
	private char garage;

	public ResidentialProperty() {
	}
	
	/**
	 * @param line an array of strings with all the required values
	 * @throws InvalidLegalDescriptionException
	 */
	public ResidentialProperty(String[] line) throws InvalidLegalDescriptionException, InvalidNumberOfBathroomsException  {	
		super(Long.parseLong(line[0]),line[1],line[2],line[3],line[4],Double.parseDouble(line[5]),line[6]);
		this.setBathrooms(Double.parseDouble(line[8]));
		this.bedrooms = Integer.parseInt(line[9]);
		this.garage = line[9].charAt(0);
		this.area = Double.parseDouble(line[7]);
	}
	
	/**
	 * @param id unique value calculated or enter zero if new property.
	 * @param legalDescription property description of max. 20 characters.
	 * @param address  property address of max. 80 characters.
	 * @param quadrant city location with valid entries NE,NW,SE,SW.
	 * @param zone applied zoning with valid entries R1,R2,R3,R4,I1,I2,I3,I4.
	 * @param price price property is listed for.
	 * @param comments  general comments on the property.
	 * @param area  area of property in square metres.
	 * @param bathrooms number of bathrooms respresented as #.0 or #.5.
	 * @param bedrooms number of bedrooms located in home.
	 * @param garage a value of 'a', 'd' or 'n' representing attached, detached or no garage.
	 * @throws InvalidLegalDescriptionException
	 * @throws InvalidNumberOfBathroomsException
	 */
	public ResidentialProperty(long id, String legalDescription, String address, String quadrant, String zone, double askingPrice,String comments,
			double area,double bathrooms, int bedrooms, char garage) throws InvalidLegalDescriptionException, InvalidNumberOfBathroomsException {
		super(id,legalDescription,address,quadrant,zone,askingPrice,comments);
		this.setBathrooms(bathrooms);
		this.bedrooms = bedrooms;
		this.garage = garage;
		this.area = area;
	}

	/**
	 * validates that the number of bathrooms is a half or full number (int or .5)
	 * @param bathrooms
	 * @throws InvalidNumberOfBathroomsException
	 */
	public void setBathrooms(double bathrooms) throws InvalidNumberOfBathroomsException {
		String[] arr = Double.toString(bathrooms).split("[.]");
		if (Integer.parseInt(arr[1])%5!=0)
			throw new InvalidNumberOfBathroomsException("Invalid number of bathrooms");
		this.bathrooms = bathrooms;
	}

	/**
	 * @return area
	 */
	public double getArea() {
		return this.area;
	}

	/**
	 * @param area
	 */
	public void setArea(double area) {
		this.area = area;
	}

	/**
	 * @return bathrooms
	 */
	public double getBathrooms() {
		return this.bathrooms;
	}

	/**
	 * @return bedrooms
	 */
	public int getBedrooms() {
		return this.bedrooms;
	}

	/**
	 * @param bedrooms
	 */
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	/**
	 * @return garage
	 */
	public char getGarage() {
		return this.garage;
	}

	/**
	 * @param garage
	 */
	public void setGarage(char garage) {
		this.garage = garage;
	}

	@Override
	public String toString() {
		return super.toString() + "  Area: " + this.area + "  Bathrooms: " + this.bathrooms + "  Bedrooms: " + this.bedrooms + "  Garage: " + this.garage;
	}
}

