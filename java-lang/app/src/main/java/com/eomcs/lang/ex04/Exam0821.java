package com.eomcs.lang.ex04;

//# 로컬 변수와 블록 II
//
public class Exam0821 {
  public static void main(String[] args) {

    int a = 100;

    for (int i = 0; i < 10; i++) {
      // 바깥 블록에 선언된 변수와 같은 이름으로 변수를 만들 수 없다.
      //      int a; // 컴파일 오류!
      int b; // OK! >>>>>>>>>>>>>>>>>>>>>>>>>>>> 컴파일러님이 알아서 b변수를 계에에속 유지한다! 오히려 int a 바로밑에 선언하면 for문 끝난 후에도 유지되어서 더 손해다!
    }

    // 블록 안에 선언된 변수는 블록 실행을 마치면 제거된다.
    // 따라서 사용할 수 없다.
    //    System.out.println(i); // 컴파일 오류!
    //    System.out.println(b); // 컴파일 오류!

  }
}
