// FileInputStream: read() 사용법
package com.bitcamp.study;

import java.io.FileInputStream;

public class Test01_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("test.data");

    // 1바이트 읽기

    int b = in.read();
    System.out.printf("%08x\n", b); // 최대 8칸을 표기하는데 빈자리가 있으면 0으로 채워라

    in.close();

    System.out.println("실행 완료!");
  }

}
