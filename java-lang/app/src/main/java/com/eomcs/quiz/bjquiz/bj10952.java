package com.eomcs.quiz.bjquiz;
import java.util.Scanner;

public class Main {

  static int plus(int a, int b) {
    return a + b;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    while (in.hasNextInt()) {
      int a = in.nextInt();
      int b = in.nextInt();

      if (a == 0 && b == 0) {
        break;
      } else {
        System.out.println(plus(a, b));
      }
    }
  }
}
