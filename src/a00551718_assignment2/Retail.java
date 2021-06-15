package a00551718_assignment2;

public class Retail extends Property{
	private int squareFootage;
	private boolean customerParking;
	
	public static final int MIN_SQAURE_FOOTAGE = 100;
	
	public Retail() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param priceUsd
	 * @param address
	 * @param type
	 * @param propertyId
	 */
	public Retail(double priceUsd, Address address, String type, String propertyId) {
		super(priceUsd, address, type, propertyId);		
	}
	
	public Retail(double priceUsd, Address address, String type, String propertyId, int squareFootage, boolean customerParking ) {
		super(priceUsd, address, type, propertyId);		
		
		if(squareFootage < MIN_SQAURE_FOOTAGE) {
			throw new IllegalArgumentException("Invalid floor space (sq. ft) available.");
		}
		
		this.squareFootage = squareFootage;
		this.customerParking = customerParking;
	}
	/**
	 * @return the squareFootage
	 */
	public int getSquareFootage() {
		return squareFootage;
	}
	/**
	 * @return the customerParking
	 */
	public boolean hasCustomerParking() {
		return customerParking;
	}
	
	@Override
	public String toString() {
		return "Retail [squareFootage=" + squareFootage + ", customerParking=" + customerParking + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
