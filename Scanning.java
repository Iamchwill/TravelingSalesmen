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
      System.out.println(Arrays.toString(distances[i]));
    }
  }
}

// 
// cities = {A, B, C, D}
// distance[0] = A
//
// distance[][] =
//    A      B       C      D
//
// A  0      5      3       8
//
// B  5      0      7       9
//
// C  3      7      0       6
//
// D  8      9      6       0
//
//
//
// A --> B --> C --> D
// A B D C
// A C D B
//
// A --> B
// A --> C
// A --> D
//
// D -->
//
// int total = 0;
// total += 5;
// total += 7;
//
// int min = 09821387;
