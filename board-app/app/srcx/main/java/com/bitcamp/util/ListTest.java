package com.bitcamp.util;

import com.bitcamp.board.domain.Board;

public class ListTest {
  public static void main(String[] args) {
    ObjectList<String> list = new ObjectList<>();
    list.add("홍길동");
    list.add("임꺽정");
    list.add(null);
    // list.add(new Board());

    String s1 = list.get(0);
    System.out.println(s1);

    ObjectList<Board> list2 = new ObjectList<>();
    // list2.add("Hello");
    list2.add(new Board());


    Board b = list2.get(0);

    LinkedList list3 = new LinkedList<>();
  }
}
