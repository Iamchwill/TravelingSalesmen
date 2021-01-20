import java.util.*;
import java.io.*;

public class Distance {
  private static ArrayList<String> cities = new ArrayList<String>();

  public static void main(String[] args) throws FileNotFoundException {
    ArrayList<ArrayList<Integer>> distances = getDistanceArr("cities.txt");

    ArrayList<ArrayList<Integer>> permutations = allpaths();

    System.out.println("The smallest distance is "
                        + smollestDistance(permutations, distances));
  }

  public static ArrayList<ArrayList<Integer>> getDistanceArr(String filename) throws FileNotFoundException {
    Scanner in = new Scanner(new File(filename));
    cities = new ArrayList<String>();
    ArrayList<ArrayList<Integer>> distances = new ArrayList<ArrayList<Integer>>();

    while(in.hasNextLine()) {
      String line = in.nextLine();
      String[] places = line.split(" = ")[0].split(" to ");

      int index = 0;
      if(!cities.contains(places[0])) {
        cities.add(places[0]);
        index = distances.size();
        distances.add(new ArrayList<Integer>());
      } else index = cities.indexOf(places[0]);

      int indexTwo = 0;
      if(!cities.contains(places[1])) {
        cities.add(places[1]);
        indexTwo = distances.size();
        distances.add(new ArrayList<Integer>());
      } else indexTwo = cities.indexOf(places[1]);

      int dist = Integer.valueOf(line.split(" = ")[1]);
      ArrayList<Integer> placeZeroDists = distances.get(index);
      ArrayList<Integer> placeOneDists = distances.get(indexTwo);

      if (placeZeroDists.size() <= indexTwo) {
        for (int i = placeZeroDists.size(); i < indexTwo; i++) {
          placeZeroDists.add(0);
        }
        placeZeroDists.add(dist);
      } else placeZeroDists.set(indexTwo, dist);

      if (placeOneDists.size() <= index) {
        for (int i = placeOneDists.size(); i < index; i++) {
          placeOneDists.add(0);
        }
        placeOneDists.add(dist);
      } else placeOneDists.set(index, dist);
    }

    distances.get(cities.size() - 1).add(0);
    return distances;
  }

  public static ArrayList<ArrayList<Integer>> allpaths() throws FileNotFoundException {
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

  //given an ArrayList of an ArrayList with the cities' permutations
  //and a matrix containing the distances between every city
  //find the total distance of each permutation
  //and keep track (and return) the smallest distance
  public static int smollestDistance(ArrayList<ArrayList<Integer>> permutations, ArrayList<ArrayList<Integer>> distances) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < permutations.size(); i++) {
      int total = 0;
      for (int j = 0; j < permutations.get(i).size()-1; j++) {
        total += distances.get(permutations.get(i).get(j)).get(permutations.get(i).get(j+1));
      }
      if (total < min) min = total;
    }
    return min;
  }

}
