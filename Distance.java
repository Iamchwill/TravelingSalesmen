import java.util.*;
import java.io.*;

public class Distance {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("cities.txt"));
    ArrayList<String> cities = new ArrayList<>(); //result

    
    while(in.hasNextLine()) {
      Scanner column = new Scanner(in.nextLine());
      String from = column.next(); //first column
      //System.out.println(from);
      column.next(); //skip over column w "to"
      String to = column.next(); //second column
      //System.out.println(to);

      if(!cities.contains(from)) cities.add(from);
      if(!cities.contains(to)) cities.add(to); //adding cities that aren't alr in the arraylist
    }
    //System.out.println(cities);
  }
}
