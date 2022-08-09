// FileInputStream: read() 사용법
package com.bitcamp.study;

import java.io.FileInputStream;

public class Test02_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("test2.data");

    // 4바이트 읽기
    int result = 0;
    int b = in.read();
    result += b << 24;
    System.out.printf("%08x\n", b); // 최대 8칸을 표기하는데 빈자리가 있으면 0으로 채워라

    b = in.read();
    result += b << 16;
    System.out.printf("%08x\n", b);

    b = in.read();
    result += b << 8;
    System.out.printf("%08x\n", b);

    b = in.read();
    result += b;
    System.out.printf("%08x\n", b);
    System.out.printf("%08x\n", result);

    // 읽을 바이트가 없다면 -1을 리턴한다.
    b = in.read();
    System.out.printf("%08x, %d\n", b, b);

    in.close();

    System.out.println("실행 완료!");
  }

}
