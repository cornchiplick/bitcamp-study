package com.bitcamp.board.dao;

import java.util.List;
import com.bitcamp.board.domain.Board;

public class BoardDaoTest {

  public static void main(String[] args) throws Exception {
    MariaDBBoardDao dao = new MariaDBBoardDao();
    List<Board> list = dao.findAll();
    for (Board b : list) {
      System.out.println(b);
    }
    System.out.println("-------------------------------");

    //    Board board = new Board();
    //    board.title = "aaaaaa";
    //    board.content = "bbbbb";
    //    board.memberNo = 2;
    //    dao.insert(board);

    dao.delete(2);
    //
    //    Member member = new Member();
    //    member.no = 1;
    //    member.name = "xxxx";
    //    member.email = "xxxx@test.com";
    //    member.password = "2222";
    //    dao.update(member);
    //
    //    Member member2 = dao.findByNo(1);
    //    System.out.println(member2);
    //
    list = dao.findAll();
    for (Board b : list) {
      System.out.println(b);
    }
    System.out.println("-------------------------------");

  }

}
