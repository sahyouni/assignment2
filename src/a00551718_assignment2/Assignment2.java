package a00551718_assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Assignment2 {
	
	Agency agency1 = new Agency("Shanty Hills Real Estate Co.");

	public static void main(String[] args) throws FileNotFoundException{
//		File addressFile = new File("files//address_data.txt");
//		File propertyFile = new File("files//property_data.txt");		
		
		Assignment2 a2 = new Assignment2();
//		Agency agency = new Agency("Shanty Hills Real Estate Co.");
//		System.out.println(AddressReader.readAddressData(addressFile));
//		System.out.println(PropertyReader.readPropertyData(propertyFile));
		a2.init();
		a2.doSearches();
	}
	
	public void init() throws FileNotFoundException{
//		Agency agency = new Agency("Shanty Hills Real Estate Co.");
		File addressFile = new File("files//address_data.txt");
		File propertyFile = new File("files//property_data.txt");
		
		ArrayList<String> propertyFileList = PropertyReader.readPropertyData(propertyFile);
		ArrayList<Address> addressFileList = AddressReader.readAddressData(addressFile);
						
		int addressFileSize = AddressReader.readAddressData(addressFile).size();
		int propertyFileSize = PropertyReader.readPropertyData(propertyFile).size();
		int index = 0;
		
		if(addressFileSize == propertyFileSize) {
			while(index < addressFileSize) {
//			for(Address address: addressFileList) {
				for(String s: propertyFileList) {
					String[] stringValue = s.split("\\|");
					
					if(stringValue[3].equalsIgnoreCase("residence")) {						
						
						double price = Double.parseDouble(stringValue[0]);
						Address address = addressFileList.get(index);
						String type = stringValue[3];
						String propertyId = stringValue[4];
						int numberOfBedrooms = Integer.parseInt(stringValue[1]);
						boolean SwimmingPool = Boolean.parseBoolean(stringValue[2]);
						boolean strata = Boolean.parseBoolean(stringValue[5]);
						
						Residence residence = new Residence(price, address, type, propertyId, numberOfBedrooms, SwimmingPool, strata);
						agency1.addProperty(residence);
						index++;
//						System.out.println(residence);	
//						System.out.println(agency.toString());
					}else if(stringValue[1].equalsIgnoreCase("commercial")){						
						
						double price = Double.parseDouble(stringValue[0]);
						Address address = addressFileList.get(index);
						String type = stringValue[1];
						String propertyId = stringValue[2];
						boolean loadingDock = Boolean.parseBoolean(stringValue[3]);
						boolean highwayAccess = Boolean.parseBoolean(stringValue[4]);
						
						Commercial commercial = new Commercial(price, address, type, propertyId, loadingDock, highwayAccess);
						agency1.addProperty(commercial);
						index++;
//						System.out.println(commercial);		
//						System.out.println(agency);
					}else if(stringValue[1].equalsIgnoreCase("retail")) {
												
						double price = Double.parseDouble(stringValue[0]);
						Address address = addressFileList.get(index);
						String type = stringValue[1];
						String propertyId = stringValue[2];
						int squareFootage = Integer.parseInt(stringValue[3]);
						boolean customerParking = Boolean.parseBoolean(stringValue[4]);
						
						Retail retail = new Retail(price, address, type, propertyId, squareFootage, customerParking);
						agency1.addProperty(retail);
						index++;
//						System.out.println(retail);
//						System.out.println(agency);
					}			
				}				
			}			
		}
	}
	
	public void doSearches(){
		Scanner scanner = new Scanner(System.in);
//		Agency agency = new Agency("Shanty Hills Real Estate Co.");
		
		int optionOne = 1;
		int optionTwo = 2;
		int optionThree = 3;
		int optionFour = 4;
		int optionFive = 5;
		
		boolean proceed = true;
		do {
			System.out.println("Welcome to our Property search.");
			System.out.println("Choose one of the following options:");
			System.out.println("\t 1. General Queries");
			System.out.println("\t 2. Residence Queries");
			System.out.println("\t 3. Commercial Queries");
			System.out.println("\t 4. Retail Queries");
			System.out.println("\t 5. Exit");
			int mainMenuOption = scanner.nextInt();
			
			if(mainMenuOption == optionOne) {
				do {
					System.out.println("General Queries");
					System.out.println("\t 1. By Property ID");
					System.out.println("\t 2. By Price");
					System.out.println("\t 3. By Street");
					System.out.println("\t 4. By Type");
					System.out.println("\t 5. Back");
					int generalQueryMenuOption = scanner.nextInt();
					
					if(generalQueryMenuOption == optionOne) {
						
						System.out.println("Please enter Property ID: ");
						String propertyIdInput = scanner.next();
						System.out.println(agency1.getProperty(propertyIdInput));
						System.out.println("\n");
						proceed = true;
						
					}else if(generalQueryMenuOption == optionTwo) {
						
						System.out.println("Enter minimum selling price: ");
						double minPrice = scanner.nextDouble();
						System.out.println("Enter maximum selling price: ");
						double maxPrice = scanner.nextDouble();
						Property[] priceRangeProperties = agency1.getPropertiesBetween(minPrice, maxPrice);
						for(Property prop: priceRangeProperties) {
							System.out.println(prop);
						}
						System.out.println("\n");
						proceed = true;
						
					}else if(generalQueryMenuOption == optionThree) {
						
						System.out.println("Please enter street name: ");
						String streetNameInput1 = scanner.next();
						String streetNameInput2 = scanner.next();
						String streetNameInput = streetNameInput1 + " " + streetNameInput2;
						ArrayList<Address> streetAddress = agency1.getPropertiesOn(streetNameInput);
						for(Address address : streetAddress) {
							System.out.println(address);
						}
						System.out.println("\n");
						proceed = true;
						
					}else if(generalQueryMenuOption == optionFour) {
						System.out.println("Please enter Property Type: ");
						String propertyTypeInput = scanner.next();
						
						ArrayList<Property> propertyType = agency1.getPropertiesOfType(propertyTypeInput);
						for(Property prop : propertyType) {
							System.out.println(prop);
						}
						System.out.println("\n");
						proceed = true;
					}else if(generalQueryMenuOption == optionFive){
						proceed = false;
					}
				
				}while(proceed);
			proceed = true;
				
			}else if(mainMenuOption == optionTwo) {
				do {
					System.out.println("Residence Queries");
					System.out.println("\t 1. By Bedroom");
					System.out.println("\t 2. By Pool");
					System.out.println("\t 3. By Strata");
					System.out.println("\t 4. Back");
					int residenceOption = scanner.nextInt();
					
					if(residenceOption == optionOne) {
						System.out.println("Enter minimum number of bedrooms: ");
						int minBedrooms = scanner.nextInt();
						System.out.println("Enter maximum number of bedrooms: ");
						int maxBedrooms = scanner.nextInt();
	
						HashMap<String, Residence> propertyWithBedrooms = agency1.getPropertiesWithBedrooms(minBedrooms, maxBedrooms);
						for(Residence key: propertyWithBedrooms.values()) {
							System.out.println(key);
						}
						System.out.println("\n");
						proceed = true;
						
					}else if(residenceOption == optionTwo) {
						ArrayList<Residence> propertyWithPools = agency1.getPropertiesWithPools();
						
						for(Residence residence: propertyWithPools) {
							System.out.println(residence);
						}
						System.out.println("\n");
						proceed = true;
					}else if(residenceOption == optionThree) {
						ArrayList<Residence> propertyWithStrata = agency1.getPropertiesWithStrata();
						
						for(Residence residence: propertyWithStrata) {
							System.out.println(residence);
						}
						System.out.println("\n");
						proceed = true;
					}else if(residenceOption == optionFour){
						proceed = false;
					}
					
				}while(proceed);
			proceed = true;		
				
			}else if(mainMenuOption == optionThree) {
				
				do {
					System.out.println("Commercial Queries");
					System.out.println("\t 1. By Loading Dock");
					System.out.println("\t 2. Highway Access");
					System.out.println("\t 3. Back");
					int commercialOption = scanner.nextInt();
					
					
						if(commercialOption == optionOne) {
							ArrayList<Commercial> propertyWithLoadingDock = agency1.getPropertiesWithLoadingDock();
							
							for(Commercial commercial: propertyWithLoadingDock) {
								System.out.println(commercial);						
							}
							
							System.out.println("\n");
							proceed = true;
						}else if(commercialOption == optionTwo){
							ArrayList<Commercial> propertyWithHighwayAccess = agency1.getPropertiesWithHighwayAccess();
							
							for(Commercial commercial : propertyWithHighwayAccess) {
								System.out.println(commercial);
							}
							
							System.out.println("\n");
							proceed = true;
						}else if(commercialOption == optionThree){
							proceed = false;
						}
					}while(proceed);
				proceed = true;	
				
			}else if(mainMenuOption == optionFour) {
				do {
					System.out.println("Retail Queries");
					System.out.println("\t 1. By Square Footage");
					System.out.println("\t 2. Customer Parking");
					System.out.println("\t 3. Back");
					int retailOption = scanner.nextInt();
					
					
						if(retailOption == optionOne) {
							System.out.println("Enter square footage: ");
							int squareFootageInput = scanner.nextInt();
							
							ArrayList<Retail> propertyWithSquareFootage = agency1.getPropertiesWithSquareFootage(squareFootageInput);
							
							for(Retail retail: propertyWithSquareFootage) {
								System.out.println(retail);
							}
							
							System.out.println("\n");
							proceed = true;
							
						}else if(retailOption == optionTwo){
							ArrayList<Retail> propertyWithCustomerParking = agency1.getPropertiesWithCustomerParking();
							
							for(Retail retail : propertyWithCustomerParking) {
								System.out.println(retail);
							}
							
							System.out.println("\n");
							proceed = true;
							
						}else if(retailOption == optionThree){
							proceed = false;
						}
					}while(proceed);
				proceed = true;
					
			}else if(mainMenuOption == optionFive){
				proceed = false;
			}
		
		}while(proceed);
		scanner.close();	
			
	}
}
