import java.util.*;
import java.io.*;

public class TravelingSalesmen {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("cities.txt"));
		ArrayList<String> cities = new ArrayList<>(); //result

		
		while (in.hasNextLine()) {
			Scanner line = new Scanner(in.nextLine());
			String from = line.next(); //first column
			//System.out.println(from);
			line.next();
			String to = line.next(); //second column
			//System.out.println(to);

			if(!cities.contains(from)) cities.add(from);
			if(!cities.contains(to)) cities.add(to); //adding cities that aren't alr in the arraylist
		}
		//System.out.println(cities);
	}
}