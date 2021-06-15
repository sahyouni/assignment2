package a00551718_assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Agency {
    @SuppressWarnings("unused")
    private final String name;
    private HashMap<String, Property> properties;

    public static final int MIN_NAME_LEN = 1;
    public static final int MAX_NAME_LEN = 30;

    public Agency(final String name) {
        if (name == null) {
            throw new NullPointerException("Invalid name: null");
        }

        if (name.length() < MIN_NAME_LEN || name.length() > MAX_NAME_LEN) {
            throw new IllegalArgumentException("Invalid name: " + name);
        }
        this.name = name;

        properties = new HashMap<>();
    }

    public void addProperty(final Property property) {
        if (property == null) {
            throw new NullPointerException("Invalid property: null");
        }

        properties.put(property.getPropertyId(), property);
    }

    public Property getProperty(final String propertyId) {

        if (properties.containsKey(propertyId)) {
            return (properties.get(propertyId));
        } 

        return null;
    }

    public void removeProperty(final String propertyId) {
        if (properties.containsKey(propertyId)) {
            properties.remove(propertyId);
        }
    }

    public double getTotalPropertyValues() {
        double totalUsd = 0.0;
        Set<String> propertyIds = properties.keySet();

        for (String propertyId : propertyIds) {
            totalUsd += properties.get(propertyId).getPriceUsd();
        }

        return totalUsd;
    }

    public ArrayList<Residence> getPropertiesWithPools() {
        ArrayList<Residence> matches = new ArrayList<>();
        Set<String> propertyIds = properties.keySet();

        for (String propertyId : propertyIds) {
            Property property = properties.get(propertyId);

            if (property instanceof Residence) {
                Residence residence = (Residence) property;
                if (residence.hasSwimmingPool()) {
                    matches.add(residence);
                }
            }
        }

        if (matches.size() == 0) {
            //try not to return null. callers of the method might not check on nulls
            return null;
        }

        return matches;
    }

    public Property[] getPropertiesBetween(final double minUsd, final double maxUsd) {
        int numberOfMatches = 0;
        int i = 0;

        Set<String> propertyIds = properties.keySet();

        for (String propertyId : propertyIds) {
            Property property = properties.get(propertyId);

            if (property.getPriceUsd() >= minUsd && property.getPriceUsd() <= maxUsd) {
                numberOfMatches++;
            }
        }

        if (numberOfMatches == 0) {
            //don't return nulls in genearal because if the caller of the method doesn't check nulls the codee will throw 
            //a runtime exception
            return null;
        }

        Property[] matches = new Property[numberOfMatches];

        for (String propertyId : propertyIds) {
            Property property = properties.get(propertyId);

            if (property.getPriceUsd() >= minUsd && property.getPriceUsd() <= maxUsd) {
                matches[i] = property;
                i++;

            }
        }
        return matches;
    }

    public ArrayList<Address> getPropertiesOn(final String streetName) {
        ArrayList<Address> matches = new ArrayList<>();

        Set<String> propertyIds = properties.keySet();

        for (String propertyId : propertyIds) {
            Property property = properties.get(propertyId);

            if (property.getAddress().getStreetName().equalsIgnoreCase(streetName)) {
                matches.add(property.getAddress());
            }
        }

        if (matches.size() == 0) {
            return new ArrayList<Address>();
        }

        return matches;
    }

    public HashMap<String, Residence> getPropertiesWithBedrooms(final int minBedrooms, final int maxBedrooms) {
        // Residence residence = new Residence();
        HashMap<String, Residence> propertiesWithBedrooms = new HashMap<>();
        Set<String> propertyIds = properties.keySet();

        for (String propertyId : propertyIds) {
            Property property = properties.get(propertyId);

            if (property instanceof Residence) {
                Residence residence1 = (Residence) property;
                if (residence1.getNumberOfBedrooms() >= minBedrooms
                        && residence1.getNumberOfBedrooms() <= maxBedrooms) {
                    propertiesWithBedrooms.put(property.getPropertyId(), (Residence) property);
                }
            }

        }

        if (propertiesWithBedrooms.size() == 0) {
            return null;
        }
        return propertiesWithBedrooms;
    }

    public ArrayList<Property> getPropertiesOfType(final String propertyType) {
        ArrayList<Property> propertiesType = new ArrayList<>();

        Set<String> key = properties.keySet();

        for (String keys : key) {

            Property prop = properties.get(keys);
            if (prop.getType().equalsIgnoreCase(propertyType) && propertyType.equalsIgnoreCase("residence")) {
                propertiesType.add(prop);
            } else if (prop.getType().equalsIgnoreCase(propertyType) && propertyType.equalsIgnoreCase("commercial")) {
                propertiesType.add(prop);
            } else if (prop.getType().equalsIgnoreCase(propertyType) && propertyType.equalsIgnoreCase("retail")) {
                propertiesType.add(prop);
            }
        }
        return propertiesType;
    }

    public ArrayList<Commercial> getPropertiesWithLoadingDock() {
        ArrayList<Commercial> propertiesWithLoadingDock = new ArrayList<>();

        Set<String> propertyIds = properties.keySet();

        for (String propertyId : propertyIds) {

            Property property = properties.get(propertyId);

            if (property instanceof Commercial) {
                Commercial commercial = (Commercial) property;

                if (commercial.hasLoadingDock() == true) {
                    propertiesWithLoadingDock.add(commercial);
                }
            }
        }
        return propertiesWithLoadingDock;
    }

    public ArrayList<Commercial> getPropertiesWithHighwayAccess() {
        ArrayList<Commercial> propertiesWithHighwayAccess = new ArrayList<>();

        Set<String> propertyIds = properties.keySet();

        for (String propertyId : propertyIds) {
            Property property = properties.get(propertyId);

            if (property instanceof Commercial) {
                Commercial commercial = (Commercial) property;
                if (commercial.hasHighwayAccess() == true) {
                    propertiesWithHighwayAccess.add(commercial);
                }
            }
        }
        return propertiesWithHighwayAccess;
    }

    public ArrayList<Retail> getPropertiesWithSquareFootage(int squareFootage) {
        ArrayList<Retail> propertyWithSquareFootage = new ArrayList<>();

        Set<String> propertyIds = properties.keySet();

        for (String propertyId : propertyIds) {
            Property property = properties.get(propertyId);

            if (property instanceof Retail) {
                Retail retail = (Retail) property;
                if (retail.getSquareFootage() >= squareFootage) {
                    propertyWithSquareFootage.add(retail);
                }
            }
        }
        return propertyWithSquareFootage;
    }

    public ArrayList<Retail> getPropertiesWithCustomerParking() {
        ArrayList<Retail> propertyWithCustomerParking = new ArrayList<>();

        Set<String> propertyIds = properties.keySet();

        for (String propertyId : propertyIds) {
            Property property = properties.get(propertyId);

            if (property instanceof Retail) {
                Retail retail = (Retail) property;

                if (retail.hasCustomerParking() == true) {
                    propertyWithCustomerParking.add(retail);
                }
            }

        }
        return propertyWithCustomerParking;
    }

    public ArrayList<Residence> getPropertiesWithStrata() {
        ArrayList<Residence> propertyWithStrata = new ArrayList<>();

        Set<String> propertyIds = properties.keySet();

        for (String propertyId : propertyIds) {
            Property property = properties.get(propertyId);

            if (property instanceof Residence) {
                Residence residence = (Residence) property;
                if (residence.hasStrata() == true) {
                    propertyWithStrata.add(residence);
                }
            }

        }
        return propertyWithStrata;
    }

    @SuppressWarnings("unused")
    private String toTitleCase(final String input) {
        StringBuilder titleCase = new StringBuilder(input.length());
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }

    public int getNumberOfProperties() {

        return properties.size();
    }

    @Override
    public String toString() {
        return "Agency [name=" + name + ", properties=" + properties + ", toString()=";
    }

}