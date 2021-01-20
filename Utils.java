import java.util.*;


public class Utils {
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
