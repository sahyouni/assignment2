package a00551718_assignment2;

public class Commercial extends Property{
	private boolean loadingDock;
	private boolean highwayAccess;
	/**
	 * 
	 */
	public Commercial() {
		super();
		
	}
	/**
	 * @param priceUsd
	 * @param address
	 * @param type
	 * @param propertyId
	 */
	public Commercial(double priceUsd, Address address, String type, String propertyId) {
		super(priceUsd, address, type, propertyId);
		
	}
	
	public Commercial(double priceUsd, Address address, String type, String propertyId, boolean loadingDock, boolean highwayAccess) {
		super(priceUsd, address, type, propertyId);
		
		this.loadingDock = loadingDock;
		this.highwayAccess = highwayAccess;		
	}
	/**
	 * @return the loadingDock
	 */
	public boolean hasLoadingDock() {
		return loadingDock;
	}
	/**
	 * @return the highwayAccess
	 */
	public boolean hasHighwayAccess() {
		return highwayAccess;
	}
	
	@Override
	public String toString() {
		return "Commercial [loadingDock=" + loadingDock + ", highwayAccess=" + highwayAccess + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
