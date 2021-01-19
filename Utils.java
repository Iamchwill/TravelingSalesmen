import java.util.*;


public class Utils {
  private static Random rng = new Random();

  public static void showRandomResults(ArrayList<String> info) {
    for (int i = 0; i < info.size(); i++) {
      System.out.println("Randomized tests #" + (i + 1) + ": FAIL: " + info.get(i));
    }
    if (info.size() == 0) System.out.println("Randomized tests: PASS");
  }

  public static void showResults(ArrayList<Boolean> results, String testName) {
    for (int i = 0; i < results.size(); i++) {
      if (results.get(i)) System.out.println(testName + " #" + (i + 1) + ": PASS");
      else System.out.println(testName + " #" + (i + 1) + ": FAIL");
    }
  }

  public static String generateFileLine(String cityOne, String cityTwo, int distance) {
    return cityOne + " to " + cityTwo + " = " + distance + "\n";
  }

}
