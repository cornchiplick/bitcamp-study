package com.eomcs.quiz.bjquiz;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int a = input.nextInt();
    int b = input.nextInt();

    if (a<b) {
      System.out.println("<");
    } else if (a>b) {
      System.out.println(">");
    } else {
      System.out.println("==");
    }

  }
}