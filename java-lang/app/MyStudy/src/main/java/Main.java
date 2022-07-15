import java.lang.Math;
import java.util.Scanner;

public class Main {

  static void triangle(int a, int b, int c) {
    int a2 = Math.pow(a, 2);
    int b2 = Math.pow(b, 2);
    int c2 = Math.pow(c, 2);

    if ((a2 + b2 == c2) || (a2 + c2 == b2) || (b2 + c2 == a2)) {
      System.out.println("right");
      return;
    } else {
      System.out.println("wrong");
      return;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    while (in.hasNextInt()) {
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();

      if (a == 0 && b == 0 && c == 0) {
        break;
      } else {
        triangle(a, b, c);
      }
    }
  }
}
