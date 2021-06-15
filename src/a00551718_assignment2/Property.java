package a00551718_assignment2;

/**
 * @author jacqueline leung
 *
 */
public class Property {
	private double priceUsd;
	private Address address;
	private String type; /* residence, commercial, or retail */
	private String propertyId;

	public static final int MIN_BEDROOMS = 1;
	public static final int MAX_BEDROOMS = 20;

	public static final int MIN_PROPERTY_ID_LEN = 1;
	public static final int MAX_PROPERTY_ID_LEN = 6;

	public Property() {
		super();
	}

	/**
	 * @param priceUsd
	 * @param address
	 * @param type
	 * @param propertyId
	 */
	public Property(double priceUsd, Address address, String type, String propertyId) {
		if (priceUsd < 0.0) {
			throw new IllegalArgumentException(String.format("Invalid price: " + priceUsd, "%.2f"));
		}
		if (address == null) {
			throw new NullPointerException("Invalid address: null");
		}

		if (type == null) {
			throw new NullPointerException("Invalid property type: null");
		}
		if (!type.equalsIgnoreCase("residence") && !type.equalsIgnoreCase("commercial")
				&& !type.equalsIgnoreCase("retail")) {
			throw new IllegalArgumentException("Invalid property type: " + type);
		}

		if (propertyId == null) {
			throw new NullPointerException("Invalid property id: null");
		}

		if (propertyId.length() < MIN_PROPERTY_ID_LEN || propertyId.length() > MAX_PROPERTY_ID_LEN) {
			throw new IllegalArgumentException("Invalid property id: " + propertyId);
		}
		this.priceUsd = priceUsd;
		this.address = address;
		this.type = type;
		this.propertyId = propertyId;
	}

	/**
	 * @return the priceUsd
	 */
	public double getPriceUsd() {
		return priceUsd;
	}

	/**
	 * @param priceUsd the priceUsd to set
	 */
	public void setPriceUsd(double priceUsd) {
		if (priceUsd < 0.0) {
			throw new IllegalArgumentException(String.format("Invalid price: " + priceUsd, "%.2f"));
		}
		this.priceUsd = priceUsd;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the propertyId
	 */
	public String getPropertyId() {
		return propertyId;
	}

	public String getPropertyDetails() {
		return String.format("Property ID: %s, Type: %s, Price: $%.2f, Address:%s", propertyId, type, priceUsd,
				address.getAddressDetails());
	}

	@Override
	public String toString() {
		return "Property [priceUsd=" + priceUsd + ", address=" + address + ", type=" + type + ", propertyId="
				+ propertyId;
	}
}