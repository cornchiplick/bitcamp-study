package com.eomcs.quiz.bjquiz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    String[] arr = new String[N];

    for (int i = 0; i < N; i++) {
      arr[i] = in.next();
    }

    Arrays.sort(arr, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        if(s1.length() == s2.length()) {
          return s1.compareTo(s2);
        }else {
          return s1.length() - s2.length();
        }

      }
    });

    System.out.println(arr[0]);
    for(int i = 1; i < N; i++) {
      if (!arr[i].equals(arr[i - 1])) {
        System.out.println(arr[i]);
      }
    }


  }
}

