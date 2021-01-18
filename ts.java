import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
public class ts{
  public static void thing(String[] args){

    String hi = "";
    Scanner me = new Scanner(System.in);

    while (me.hasNextLine()) {
      Scanner line = new Scanner(me.nextLine());
      while (line.hasNext()) {
        String a = line.next();
        hi += a;
        if (line.hasNext()){
          hi += " ";

        }
      }
    }
    System.out.println("hi");

  }
  public static String[] two(String a){
    String[] me = new String[2];
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
    return me;
  }
  // public static String[] yay(String a){
  //
  // }


}
