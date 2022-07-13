import java.util.Scanner;
import java.lang.Math;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    int[] muse = new int[8];
    for (int i = 0; i < 8; i++) {
      muse[i] = input.nextInt();
    }

    String ans = "917325";
    String ans1 = "1234567";
    String ans2 = "987654321";

    for (int i = 0; i < 7; i++) {
      if (muse[i] < muse[i+1]) {
        ans = "ascending";
        continue;
      } else {
        break;
      }
    }

    for (int i = 0; i < 7; i++) {
      if (muse[i] > muse[i+1]) {
        ans = "descending";
        continue;
      } else {
        break;
      }
    }
  


    System.out.println(ans);
    

  }
}