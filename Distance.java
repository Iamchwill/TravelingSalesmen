import java.util.*;
import java.io.*;

public class Distance {
  public static void main(String[] args) throws FileNotFoundException {
    ArrayList<String> cities = findCities("cities.txt");

    int[][] distances = arrayifyDistances(cities, "cities.txt");

    ArrayList<ArrayList<Integer>> permutations = allpaths(cities);

    System.out.println(smollestDistance(permutations, distances));
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

  public static ArrayList<ArrayList<Integer>> allpaths(ArrayList<String> cities) throws FileNotFoundException {
    ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    for(int i = 0; i < cities.size(); i++) {
      ArrayList<Integer> start = new ArrayList<>();
      start.add(i);
      paths.add(start); //when u print paths: [0], [1], [2]... (length of cities.size())
    }

    while(paths.get(0).size() < cities.size()) { //since [0] only has one city n not all, we have to continue n add
      ArrayList<ArrayList<Integer>> morepaths = new ArrayList<>(); // i created a new array to add more paths bc multiple paths start at [0]... [1]... [2]...
      for(ArrayList<Integer> i : paths) { //for each path
        for(int j = 0; j < cities.size(); j++) { //we go through the list of cities
          if(!i.contains(j)) { //if the path does not contain a city
            ArrayList<Integer> newpath = (ArrayList<Integer>) i.clone(); //clone the path. rn its [0]
            newpath.add(j); //add the city to it --> [0,1]
            morepaths.add(newpath); //add this path to the new array n itll keep doing this until theres [0,1] [0,2] [0,3]... [1,0], [1,2]...
            //then it goes back to while loop n adds more cities until all cities r in the path
          }
        }
      }
      paths = morepaths; //replace the original path arraylist to the new arraylist (have to do this bc morepaths is in a while loop so i cant just return it)
    }
    return paths; //all paths:) hope u guys understand bc i need to studyy
  }

  //uses matrix generated from arrayifyDistances to find distance between 2 cities
  public static int cityDistance(int city1, int city2, int[][] matrix) {
    return matrix[city1][city2];
  }

  //given an ArrayList of an ArrayList with the cities' permutations
  //and a matrix containing the distances between every city
  //find the total distance of each permutation
  //and keep track (and return) the smallest distance
  public static int smollestDistance(ArrayList<ArrayList<Integer>> permutations, int[][] distances) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < permutations.size(); i++) {
      int total = 0;
      for (int j = 0; j < permutations.get(i).size()-1; j++) {
        total += cityDistance(permutations.get(i).get(j), permutations.get(i).get(j+1), distances);
      }
      if (total < min) min = total;
    }
    return min;
  }

}
