package a00551718_assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PropertyReader {
	File file = new File("files//property_data.txt");
		
	public static ArrayList<String> readPropertyData(File file) throws FileNotFoundException{
		ArrayList<String> propertyList = new ArrayList<>();		
		Scanner fileScanner = null;
		
		try {
			
			fileScanner = new Scanner(file);
			
			while(fileScanner.hasNext()) {
//				StringBuilder builder = new StringBuilder();
				
				String line = fileScanner.nextLine();
//				String[] value = line.split("\\|");
				propertyList.add(line);
								
//				if(value[3].equalsIgnoreCase("residence")) {
//					String price = value[0];
//					String type = value[3];
//					String propertyId = value[4];
//					String numberOfBedrooms = value[1];
//					String hasSwimmingPool = value[2];
//					String strata = value[5];
//					
//					propertyList.add(price);
//					propertyList.add(type);
//					propertyList.add(propertyId);
//					propertyList.add(numberOfBedrooms);
//					propertyList.add(hasSwimmingPool);
//					propertyList.add(strata);	
//					
//				}else if(value[1].equalsIgnoreCase("commercial")){
//					String price = value[0];
//					String type = value[1];
//					String propertyId = value[2];
//					String hasLoadingDock = value[3];
//					String hasHighwayAccess = value[4];
//					
//					propertyList.add(price);
//					propertyList.add(type);
//					propertyList.add(propertyId);
//					propertyList.add(hasLoadingDock);
//					propertyList.add(hasHighwayAccess);
//					
//				}else if(value[1].equalsIgnoreCase("retail")) {
//					String price = value[0];
//					String type = value[1];
//					String propertyId = value[2];
//					String squareFootage = value[3];
//					String hasCustomerParking = value[4];
//					
//					propertyList.add(price);
//					propertyList.add(type);
//					propertyList.add(propertyId);
//					propertyList.add(squareFootage);
//					propertyList.add(hasCustomerParking);
//				}
//				
//				if(value.length <= 5) {
//					builder.append(value[0] + " ");
//					builder.append(value[1] + " ");
//					builder.append(value[2] + " ");
//					builder.append(value[3] + " ");
//					builder.append(value[4] + " ");
//					String propertyValue = builder.toString();
//					propertyList.add(propertyValue);
//					
//				}else if(value.length > 5) {
//					builder.append(value[0] + " ");
//					builder.append(value[1] + " ");
//					builder.append(value[2] + " ");
//					builder.append(value[3] + " ");
//					builder.append(value[4] + " ");
//					builder.append(value[5] + " ");
//					String propertyValue = builder.toString();
//					propertyList.add(propertyValue);
//				}
				
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}finally {
			for (String s: propertyList) {
//				System.out.println(s);
			}
			
			fileScanner.close();
		}
				
		return propertyList;
	}
	
//	public static void main(String[] args) throws FileNotFoundException {
//		PropertyReader.readPropertyData(file);
//	}
}

