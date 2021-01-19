import java.util.*;
import java.io.*;

public class Distance {
  public static void main(String[] args) throws FileNotFoundException {
    ArrayList<String> cities = findCities("cities.txt");
    int[][] distances = arrayifyDistances(cities, "cities.txt");
    System.out.println(allpaths());
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

  public static ArrayList<ArrayList<Integer>> allpaths() throws FileNotFoundException { //initializing
    ArrayList<String> cities = findCities("cities.txt");
    ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    for(int i = 0; i < cities.size(); i++) {
      ArrayList<Integer> start = new ArrayList<>();
      start.add(i);
      paths.add(start);
    }

    while(paths.get(0).size() < cities.size()) {
      ArrayList<ArrayList<Integer>> morepaths = new ArrayList<>();
      for(ArrayList<Integer> i : paths) {
        for(int j = 0; j < cities.size(); j++) {
          if(!i.contains(j)) {
            ArrayList<Integer> newpath = (ArrayList<Integer>) i.clone();
            newpath.add(j); 
            morepaths.add(newpath);
          }
        }
      }
      paths = morepaths;
    }
    return paths;
  }
}







