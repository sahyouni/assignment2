package a00551718_assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PropertyReader {
	File file = new File("files//property_data.txt");

	public static ArrayList<String> readPropertyData(File file) throws FileNotFoundException {
		ArrayList<String> propertyList = new ArrayList<>();
		Scanner fileScanner = null;

		try {

			fileScanner = new Scanner(file);

			while (fileScanner.hasNext()) {

				String line = fileScanner.nextLine();
				propertyList.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			for (String s : propertyList) {
			}

			fileScanner.close();
		}

		return propertyList;
	}
}
