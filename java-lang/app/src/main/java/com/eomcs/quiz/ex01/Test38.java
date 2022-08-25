package com.eomcs.quiz.ex01;
// copyright by codefights.com
// 
// 10진수의 자릿수의 길이가 주어질 때 
// 해당 자릿수의 숫자들 중에서 가장 작은 수를 알아내라!
// 
//
// 형식:
//   smallestNumber(자릿수의 길이)
// 예) 
//   smallestNumber(1) ==> 1
//   smallestNumber(2) ==> 10
//   smallestNumber(3) ==> 100
//
/*
The algorithm should return the smallest non-negative integer of N digits length.

Example

smallestNumber(2) = 10

[input] integer n
integer's length, positive integer

[output] integer
 */
//
// [시간 복잡도]
// - ?
//
public class Test38 {

  public static void main(String[] args) {
    System.out.println(smallestNumber(1) == 0);
    System.out.println(smallestNumber(2) == 10);
    System.out.println(smallestNumber(3) == 100);
  }

  // 이 메서드를 완성하시오!
  static int smallestNumber(int n) {

    //    if (n == 1) {
    //      return 0;
    //    }
    //
    //    int ans = 1;
    //
    //    for (int i = 1; i < n; i++) {
    //      ans *= 10;
    //    }
    //
    //    return ans;
    //    

    return (int) (n == 1 ? 0 : Math.pow(10, n-1));

  }
}














