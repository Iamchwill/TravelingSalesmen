import java.util.*;

public class Distance {
  public static void main(String[] args) {
  //  ArrayList<ArrayList<Integer>> distances = new ArrayList<ArrayList<Integer>>();
    ArrayList<String> allPlaces = new ArrayList<String>();

    Scanner scan = new Scanner(System.in);
    while (scan.hasNextLine()) {
      String lineScan = scan.nextLine();

      String[] placesAndDistance = lineScan.split(" = ");
      String[] places = placesAndDistance[0].split(" to ");

      int index = 0;
      if (!allPlaces.contains(places[0])) {
        index = allPlaces.size();
        allPlaces.add(places[0]);
    //    distances.add(new ArrayList<Integer>());
      } else index = allPlaces.indexOf(places[0]);

      int indexTwo = 0;
      if (!allPlaces.contains(places[1])) {
        indexTwo = allPlaces.size();
        allPlaces.add(places[1]);
      } else indexTwo = allPlaces.indexOf(places[1]);

      System.out.println(Integer.valueOf(placesAndDistance[1]));
      System.out.println(allPlaces);
    //  distances.get(index).set(indexTwo) = Integer.valueOf(placesAndDistance[1]);
    }
  }
}
