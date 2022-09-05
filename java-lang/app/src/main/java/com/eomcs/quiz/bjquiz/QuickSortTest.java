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

    if (start >= end) {
      return;
    }

    int pivot = partition(arr, start, end);

    quickSort(arr, start, pivot);
    quickSort(arr, pivot+1, end);

  }

  static void partition(int[] arr, int start, int end) {
    int pivot = arr[(start + end) / 2];

    while (true) {

      while (arr[start] <= pivot) {
        start++;
      }

      while (arr[end] >= pivot) {
        end--;
      }

    }

  }



}
