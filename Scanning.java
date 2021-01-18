import java.util.*;

public class Scanning {
  public static void main(String[] args) {

    ArrayList<String> allPlaces = new ArrayList<String>();
    allPlaces.add("Faerun");
    allPlaces.add("Norrath");
    allPlaces.add("Tristram");
    allPlaces.add("AlphaCentauri");
    allPlaces.add("Arbre");
    allPlaces.add("Snowdin");
    allPlaces.add("Tambi");
    allPlaces.add("Straylight");

    int[][] distances = new int[allPlaces.size()][allPlaces.size()];

    Scanner scan2 = new Scanner(System.in);
    while (scan2.hasNextLine()) {
      String lineScan2 = scan2.nextLine();

      String[] sentenceToArray = lineScan2.split(" "); //[Faerun,to,Norrath,=,129]

      distances[allPlaces.indexOf(sentenceToArray[0])]
                [allPlaces.indexOf(sentenceToArray[2])]
                = Integer.parseInt(sentenceToArray[4]);
      distances[allPlaces.indexOf(sentenceToArray[2])]
                [allPlaces.indexOf(sentenceToArray[0])]
                = Integer.parseInt(sentenceToArray[4]);
      }

    for (int i = 0; i < distances.length; i++) {
      for (int k = 0; k < distances[i].length; k++) {
        System.out.println(distances[i][k]);
      }
    }
  }
}
