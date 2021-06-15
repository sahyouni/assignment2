/**
 * 
 */
package a00551718_assignment2;

/**
 * @author leung
 *
 */
public class Address
{
    private final String unitNumber;
    private final int streetNumber;
    private final String streetName;
    private final String postalCode;
    private final String city;

    public static final int MIN_LEN_UNIT_NUM = 1;
    public static final int MAX_LEN_UNIT_NUM = 4;

    public static final int MIN_STREET_NUM = 0;
    public static final int MAX_STREET_NUM = 999999;

    public static final int MIN_LEN_STREET_NAME = 1;
    public static final int MAX_LEN_STREET_NAME = 20;

    public static final int MIN_LEN_POSTAL = 5;
    public static final int MAX_LEN_POSTAL = 6;

    public static final int MIN_LEN_CITY = 1;
    public static final int MAX_LEN_CITY = 30;

    /**
     * @param unitNumber the unit number to set
     * @param streetNumber the street number (only) to set
     * @param streetName the name of the street to set
     * @param postalCode the postal code / zip code to set
     * @param city the name of the city to set
     */
    public Address(final String unitNumber, final int streetNumber, final String streetName, final String postalCode, final String city)
    {
        if(unitNumber != null)
        {
            if(unitNumber.length() < MIN_LEN_UNIT_NUM || unitNumber.length() > MAX_LEN_UNIT_NUM)
            {
                throw new IllegalArgumentException("Invalid unit number: " + unitNumber);
            }
        }

        if(streetNumber < MIN_STREET_NUM || streetNumber > MAX_STREET_NUM)
        {
            throw new IllegalArgumentException("Invalid street number: " + streetNumber);
        }

        if(streetName == null)
        {
            throw new NullPointerException("Invalid street name: null");
        }

        if(streetName.length() < MIN_LEN_STREET_NAME || streetName.length() > MAX_LEN_STREET_NAME)
        {
            throw new IllegalArgumentException("Invalid street name: " + streetName);
        }

        if(postalCode == null)
        {
            throw new NullPointerException("Invalid postal code: null");
        }

        if(postalCode.length() < MIN_LEN_POSTAL || postalCode.length() > MAX_LEN_POSTAL)
        {
            throw new IllegalArgumentException("Invalid postal code: " + postalCode);
        }

        if(city == null)
        {
            throw new NullPointerException("Invalid city: null");
        }

        if(city.length() < MIN_LEN_CITY || city.length() > MAX_LEN_CITY)
        {
            throw new IllegalArgumentException("Invalid city: " + city);
        }

        this.unitNumber = unitNumber;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;
    }

    /**
     * @return the unit number as a String; null if there is none
     */
    public String getUnitNumber()
    {
        return unitNumber;
    }

    /**
     * @return the number of the street address; e.g. for "123 main street" returns 123
     */
    public int getStreetNumber()
    {
        return streetNumber;
    }

    /**
     * @return the name of the street; e.g. "electric avenue"
     */
    public String getStreetName()
    {
        return streetName;
    }

    /**
     * @return the postal/zip code
     */
    public String getPostalCode()
    {
        return postalCode;
    }

    /**
     * accessor method for the city field
     * @return the name of the city
     */
    public String getCity()
    {
        return city;
    }
    
    public String getAddressDetails() {
    	
    	String unit = unitNumber;
    	if(unit == null) {
    		unit = "";
    	}
    	return String.format("%s %d, %s, %s, %s", 
    			unit, streetNumber, streetName, postalCode, city);
    }

	@Override
	public String toString() {
		return "Address [unitNumber=" + unitNumber + ", streetNumber=" + streetNumber + ", streetName=" + streetName
				+ ", postalCode=" + postalCode + ", city=" + city + "]";
	}
    
    
}
