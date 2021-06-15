/**
 * 
 */
package a00551718_assignment2;

/**
 * @author leung
 *
 */
public class Residence extends Property {
	private int numberOfBedrooms;
	private boolean swimmingPool;
	private boolean strata;

	public static final int MIN_BEDROOM = 1;
	
	public Residence() {
		super();
	}
	/**
	 * @param priceUsd
	 * @param address
	 * @param type
	 * @param propertyId
	 */
	public Residence(double priceUsd, Address address, String type, String propertyId) {
		super(priceUsd, address, type, propertyId);
		
	}	
	
	public Residence(double priceUsd, Address address, String type, String propertyId, int numberOfBedrooms, boolean swimmingPool,boolean strata) {
		super(priceUsd, address, type, propertyId);
		if(numberOfBedrooms < MIN_BEDROOMS) {
            throw new IllegalArgumentException("Invalid number of bedrooms: " + numberOfBedrooms);
        }
		
		this.numberOfBedrooms = numberOfBedrooms;
        this.swimmingPool = swimmingPool;
        this.strata = strata;
	}
	/**
	 * @return the numberOfBedrooms
	 */
	public int getNumberOfBedrooms() {
		return numberOfBedrooms;
	}
	/**
	 * @return the swimmingPool
	 */
	public boolean hasSwimmingPool() {
		return swimmingPool;
	}
	/**
	 * @return the strata
	 */
	public boolean hasStrata() {
		return strata;
	}
	@Override
	public String toString() {
		return "Residence [numberOfBedrooms=" + numberOfBedrooms + ", swimmingPool=" + swimmingPool + ", strata="
				+ strata + ", toString()=" + super.toString() + "]";
	}
}
