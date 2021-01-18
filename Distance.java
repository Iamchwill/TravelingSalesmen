import java.util.*;

public class Distance {
  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> distances = new ArrayList<ArrayList<Integer>>();
    ArrayList<String> allPlaces = new ArrayList<String>();

    Scanner scan = new Scanner(System.in);
    while (scan.hasNextLine()) {
      String lineScan = scan.nextLine();
      String[] placesAndDistance = lineScan.split(" = ");
      String[] places = placesAndDistance[0].split(" to ");
    }

    int[][] distances = new int[allPlaces.size()][allPlaces.size()];

    Scanner scan2 = new Scanner(System.in);
    while (scan2.hasNextLine()) {
      String lineScan2 = scan2.nextLine();

      String[] sentenceToArray = lineScan2.split(" ");

      distances[allPlaces.indexOf(sentenceToArray[0])]
                [allPlaces.indexOf(sentenceToArray[2])]
                = Integer.parseInt(sentenceToArray[4]);
      distances[allPlaces.indexOf(sentenceToArray[2])]
                [allPlaces.indexOf(sentenceToArray[0])]
                = Integer.parseInt(sentenceToArray[4]);
      }
  }
}
