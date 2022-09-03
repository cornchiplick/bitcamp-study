package com.eomcs.quiz.bjquiz;

public class QuickSortTest {

  public static void main(String[] args) {

    int[] array = new int[] {7,2,1,0,5,4,8,6,3,9};
    quickSort(array);

    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }

  }

  static void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  static void quickSort(int[] arr, int start, int end) {
    int pivot = arr[(start + end) / 2];

    while (start <= end) {

      while (arr[start] < pivot) {start++;}
      while (pivot < arr[end]) {end--;}

      if (start <= end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
      }
    }

    int temp2 = start;
    start = end;
    end = temp2;

    while (pivot - 1 != 0) {
      quickSort(arr, 0, pivot - 1);
    }

    while (arr.length - pivot - 2 != 0) {
      quickSort(arr, pivot, arr.length - 1);
    }
  }



}
