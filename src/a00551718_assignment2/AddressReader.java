package a00551718_assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressReader {
	File file = new File("files//address_data.txt");
	
	public static ArrayList<Address> readAddressData(File file) throws FileNotFoundException{
		ArrayList<Address> addressList = new ArrayList<>();
		Scanner fileScanner = null;
		
		try {
					
			fileScanner = new Scanner(file);
			
			while(fileScanner.hasNext()) {
				String line = fileScanner.nextLine();
				String[] value = line.split("\\|");
				
				Address address = new Address(value[0], Integer.parseInt(value[1]), value[2], value[3], value[4]);
				addressList.add(address);
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}finally {
			fileScanner.close();
		}
				
		return addressList;
	}
}
