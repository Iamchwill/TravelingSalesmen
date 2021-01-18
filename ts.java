
import java.util.*;
public class ts{
//   public static void thing(String[] args){
// // Tami's main
//     ArrayList<String> allPlaces = new ArrayList<String>();
//
//     Scanner scan = new Scanner(System.in);
//     while (scan.hasNextLine()) {
//       String lineScan = scan.nextLine();
//
//       String[] placesAndDistance = lineScan.split(" = ");
//       String[] places = placesAndDistance[0].split(" to ");
//
//       int index = 0;
//       if (!allPlaces.contains(places[0])) {
//         index = allPlaces.size();
//         allPlaces.add(places[0]);
//     //    distances.add(new ArrayList<Integer>());
//       } else index = allPlaces.indexOf(places[0]);
//
//       int indexTwo = 0;
//       if (!allPlaces.contains(places[1])) {
//         indexTwo = allPlaces.size();
//         allPlaces.add(places[1]);
//       } else indexTwo = allPlaces.indexOf(places[1]);
//
//       System.out.println(Integer.valueOf(placesAndDistance[1]));
//       System.out.println(allPlaces);
//     //  distances.get(index).set(indexTwo) = Integer.valueOf(placesAndDistance[1]);
//     }

  // }
  public static String[] two(String a){
    String[] me = new String[3];
    int end = 0;
    int end2 = 0;

    for (int i = 0; i<a.length()-2; i++){
      if (a.substring(i, i+2).equals("to")){
        end = i-1;
      }
      if (a.substring(i, i+1).equals("=")){
        end2 = i-1;
      }
    }
    me[0]= a.substring(0, end);
    me[1]= a.substring(end+4, end2);
    me[2] = a.substring(end2+3, a.length());
    return me;
  }
  public static String[][] three(String[] a, int cities){
    ArrayList<String> cit = new ArrayList<String>();
    cit.add("Faerun");
    cit.add("Norrath");
    cit.add("Tristram");
    cit.add("AlphaCentauri");
    cit.add("Arbre");
    cit.add("Snowdin");
    cit.add("Tambi");
    cit.add("Straylight");
    String[][] x = new String[cities][cities];
    // a[cit.indexOf(a[0])][cit.indexOf(a[1])] = a[2];
    a[0][0] += "hi";
  }
  // public static ArrayList<String> four()
  // public static String[] yay(String a){
  //
  // }
//
//
}
