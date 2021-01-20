import java.util.*;
import java.io.*;

public class Tester{
  public static void main(String[] args){
    testFindCities();
    testArrayifyDistance();
  }

  public static void testArrayifyDistance() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();
    File testFile = new File("pasta.txt");

    String[] places = {"Penne", "Fusili", "Rotini"};
    int[] distances = {80, 121, 57};

    try {
      FileWriter writer = new FileWriter("pasta.txt");
      String all = Utils.generateFileLine(places[0], places[1], distances[0]) +
                    Utils.generateFileLine(places[0], places[2], distances[1]) +
                    Utils.generateFileLine(places[1], places[2], distances[2]);
      writer.write(all);
      writer.close();
    } catch (IOException e) {
      results.add(false);
      System.out.println(e);
    }

    ArrayList<String> placesList = new ArrayList<String>();

    try {
      placesList = Distance.findCities("pasta.txt");
    } catch (FileNotFoundException e) {
      results.add(false);
      System.out.println(e);
    }

    try {
      int[][] allDistances = Distance.arrayifyDistances(placesList, "pasta.txt");
      String[] expected = {"[0, 80, 121]", "[80, 0, 57]", "[121, 57, 0]"};

      for (int i = 0; i < allDistances.length; i++) {
        results.add(Arrays.toString(allDistances[i]).equals(expected[i]));
      }
    } catch (FileNotFoundException e) {
      results.add(false);
      System.out.println(e);
    }

    places = new String[]{"Fetuccine", "Bucatini", "Tagliatelle", "Tortellini", "Orecchiette"};
    distances = new int[]{12, 34, 50, 32, 22, 10, 5, 77, 89, 21};

    try {
      FileWriter writer = new FileWriter("pasta.txt");
      String all = "";
      int index = 0;
      for (int i = 0; i < places.length - 1; i++) {
        for (int j = i + 1; j < places.length; j++) {
          all += Utils.generateFileLine(places[i], places[j], distances[index]);
          index++;
        }
      }
      writer.write(all);
      writer.close();
    } catch (IOException e) {
      System.out.println(e);
    }

    try {
      placesList = Distance.findCities("pasta.txt");
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }

    try {
      int[][] allDistances = Distance.arrayifyDistances(placesList, "pasta.txt");
      String[] expected = {
        "[0, 12, 34, 50, 32]",
        "[12, 0, 22, 10, 5]",
        "[34, 22, 0, 77, 89]",
        "[50, 10, 77, 0, 21]",
        "[32, 5, 89, 21, 0]"
      };

      for (int i = 0; i < allDistances.length; i++) {
        results.add(Arrays.toString(allDistances[i]).equals(expected[i]));
      }
    } catch (FileNotFoundException e) {
      results.add(false);
      System.out.println(e);
    }

    Utils.showResults(results, "Test array-ify distance");
  }

  public static void testFindCities() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();
    File testFile = new File("pasta.txt");

    String[] places = {"Penne", "Fusili", "Rotini"};
    int[] distances = {80, 121, 57};

    try {
      FileWriter writer = new FileWriter("pasta.txt");
      String all = Utils.generateFileLine(places[0], places[1], distances[0]) +
                    Utils.generateFileLine(places[0], places[2], distances[1]) +
                    Utils.generateFileLine(places[1], places[2], distances[2]);
      writer.write(all);
      writer.close();
    } catch (IOException e) {
      System.out.println("oh no :{");
    }

    ArrayList<String> failInfo = new ArrayList<String>();

    try {
      Scanner scanner = new Scanner(new File("pasta.txt"));
      String[] expectedLines = {
        "Penne to Fusili = 80",
        "Penne to Rotini = 121",
        "Fusili to Rotini = 57"
      };

      int count = 0;

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (!line.equals(expectedLines[count])) {
          failInfo.add("EXPECTED - " + expectedLines[count] + "\nGOT - " + line + "\n\n");
        }
        count++;
      }
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }

    if (!failInfo.isEmpty()) System.out.println(failInfo);
    results.add(failInfo.isEmpty());

    ArrayList<String> placesList = new ArrayList<String>();

    try {
      placesList = Distance.findCities("pasta.txt");
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }

    results.add(placesList.toString().equals("[Penne, Fusili, Rotini]"));

    places = new String[]{"Marinara", "Bolognese"};
    distances = new int[]{20};

    try {
      FileWriter writer = new FileWriter("pasta.txt");
      String all = Utils.generateFileLine(places[0], places[1], distances[0]);
      writer.write(all);
      writer.close();
    } catch (IOException e) {
      System.out.println("oh no :{");
    }

    placesList = new ArrayList<String>();

    try {
      placesList = Distance.findCities("pasta.txt");
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }

    results.add(placesList.toString().equals("[Marinara, Bolognese]"));

    places = new String[]{"Ziti", "Farfalle", "Spaghetti", "Linguini", "Rigatoni"};
    distances = new int[]{20};

    try {
      FileWriter writer = new FileWriter("pasta.txt");

      String all = "";
      for (int i = 0; i < places.length - 1; i++) {
        all += Utils.generateFileLine(places[i], places[i + 1], distances[0]);
      }

      writer.write(all);
      writer.close();
    } catch (IOException e) {
      System.out.println("oh no :{");
    }

    placesList = new ArrayList<String>();

    try {
      placesList = Distance.findCities("pasta.txt");
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }

    results.add(placesList.toString().equals("[Ziti, Farfalle, Spaghetti, Linguini, Rigatoni]"));

    Utils.showResults(results, "Test find cities");
  }



}
