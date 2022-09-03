package com.eomcs.quiz.bjquiz;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RealQuickSortTest {

  static void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  static void quickSort(int[] arr, int start, int end) {
    int part2 = partition(arr, start, end);
    if (start < part2 - 1) {
      quickSort(arr, start, part2 - 1);
    }
    if (part2 < end) {
      quickSort(arr, part2, end);
    }
  }

  static int partition(int[] arr, int start, int end) {
    int pivot = arr[(start + end) / 2];
    while (start <= end) {
      while (arr[start] < pivot) start++;
      while (arr[end] > pivot) end--;
      if (start <= end) {
        swap(arr, start, end);
        start++;
        end--;
      }
    }
    return start;
  }

  static void swap(int[] arr, int start, int end) {
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
  }

  public static void main(String[] args) {

    int[] array = {3,9,4,7,5,0,1,6,8,2};
    int[] array2 = {3,9,4,7,5,0,1,6,8,2};




    // 직접 구현
    quickSort(array);

    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
    }
    System.out.println();


    // Collections.sort() 사용
    //    List<Integer> a2 = new Queue<>();
    List<Integer> a2 = new LinkedList<>();

    for (int i = 0; i < array2.length; i++) {
      a2.add(array2[i]);
    }

    // 정렬 전
    System.out.println(a2 + "ㅜㅜ");

    //    // 정렬 후
    Collections.sort(a2);

    System.out.print(a2 + "^^");

  }
}






















