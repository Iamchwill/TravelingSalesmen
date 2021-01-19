import java.util.*;
import java.io.*;

public class Distance {
  public static void main(String[] args) throws FileNotFoundException {
    ArrayList<String> cities = findCities("cities.txt");
    int[][] distances = arrayifyDistances(cities, "cities.txt");
  }

  public static ArrayList<String> findCities(String filename) throws FileNotFoundException {
    Scanner in = new Scanner(new File(filename));
    ArrayList<String> cities = new ArrayList<String>();

    while(in.hasNextLine()) {
      Scanner column = new Scanner(in.nextLine());
      String from = column.next();
      column.next();
      String to = column.next();

      if(!cities.contains(from)) cities.add(from);
      if(!cities.contains(to)) cities.add(to);
    }

    return cities;
  }

  public static int[][] arrayifyDistances(ArrayList<String> cities, String filename) throws FileNotFoundException {
    int[][] distances = new int[cities.size()][cities.size()];

    Scanner scan2 = new Scanner(new File(filename));
    while (scan2.hasNextLine()) {
      String lineScan2 = scan2.nextLine();

      String[] sentenceToArray = lineScan2.split(" ");

      distances[cities.indexOf(sentenceToArray[0])]
                [cities.indexOf(sentenceToArray[2])]
                = Integer.parseInt(sentenceToArray[4]);
      distances[cities.indexOf(sentenceToArray[2])]
                [cities.indexOf(sentenceToArray[0])]
                = Integer.parseInt(sentenceToArray[4]);
    }

    return distances;
  }



}
