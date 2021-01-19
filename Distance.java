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


// Start(3):
//   paths = [0]
//       [1]
//       [2]
//   ArrayList<ArrayList<Integer>> paths
//   for(int i = 0; i < cities.size(); i++)
//     ArrayList<Integer> apath
//     apath.add(i)
//     paths.add(apath)
//
//
// while(path.get(0)).size() < cities.size()
// Iterating 1
//   paths = [0, 1]
//       [0, 2]
//       [1, 0]
//       [1, 2]
//       ...
//   for(ArrayLists in ArrayList<ArrayList> paths)
//     for(int i = 0; i < cities.size(); i++)
//       if(ArrayList doesn't contain i)
//         add i
//
//
// Iterating 2
//   paths = [0, 1, 2]
//       [0, 2, 1]
//       [1, 0, 2]
//       [1, 2, 0]
//       ...
//
// Go through each path and add costs
// for(i : paths)
//   for
//     add
//   if total < min, min = total
