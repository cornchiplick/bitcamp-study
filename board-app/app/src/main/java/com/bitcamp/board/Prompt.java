/*
 *  키보드 입력을 받는 도구를 구비하고 있다.
 */
package com.bitcamp.board;

public class Prompt {

  static java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

  // 메서드를 통해 특정 코드의 복잡함을 감출 수 있다. ==> encapsulation (캡슐화)
  /*
  String input = keyboardInput.nextLine();
  int menuNo = Integer.parseInt(input);
  return menuNo;
   */

  static int inputInt() {
    String str = keyboardInput.nextLine();
    return Integer.parseInt(str);
  }

  static int inputInt(String title) {
    System.out.print(title);
    String str = keyboardInput.nextLine();
    return Integer.parseInt(str);
  }

  static String inputString() {
    return keyboardInput.nextLine();
  }

  static String inputString(String title) {
    System.out.print(title);
    return keyboardInput.nextLine();
  }

  static void close() {
    keyboardInput.close();
  }

  static String inputTitleUpdate(String title) {
    System.out.printf("제목?(%s) ",title);
    return keyboardInput.nextLine();
  }

  static String inputContentUpdate(String content) {
    System.out.printf("내용?(%s) ",content);
    return keyboardInput.nextLine();
  }


}
