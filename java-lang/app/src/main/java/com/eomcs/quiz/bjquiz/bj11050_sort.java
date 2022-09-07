package com.eomcs.quiz.bjquiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class bj11050_sort {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    int N = in.nextInt();
    List<Integer> a = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      a.add(in.nextInt());
    }

    Collections.sort(a);

    for (int i = 0; i < N; i++) {
      System.out.println(a.get(i));
    }
  }
}

/*
    while (count < N) {

      for(int i=1; i < arr.length; i++){
        for(int j=i ; j >= 1; j--){

          if(arr[j] < arr[j-1]){  //한 칸씩 왼쪽으로 이동
            int tmp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = tmp;
          } else break;  //자기보다 작은 데이터를 만나면 그 위치에서 멈춤

        }
      }

      count++;
    } // while

    for (int i = 0; i < N; i++) {
      System.out.println(arr[i]);
    }

  }

}

 */
