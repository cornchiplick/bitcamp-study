package com.bitcamp.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.BoardService;

// CRUD 요청을 처리하는 페이지 컨트롤러들을 한 개의 클래스로 합친다. 
@Controller // 페이지 컨트롤러에 붙이는 애노테이션
@RequestMapping("/board/")
public class BoardController {

  BoardService boardService;

  public BoardController(BoardService boardService) {
    this.boardService = boardService;
  }

  @GetMapping("form")
  public String form(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return "/board/form.jsp";
  }

  @PostMapping("add")
  public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Board board = new Board();
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    board.setAttachedFiles(saveAttachedFiles(request));
    board.setWriter((Member) request.getSession().getAttribute("loginMember"));

    boardService.add(board);

    return "redirect:list";
  }

  private List<AttachedFile> saveAttachedFiles(HttpServletRequest request)
      throws IOException, ServletException {
    List<AttachedFile> attachedFiles = new ArrayList<>();
    String dirPath = request.getServletContext().getRealPath("/board/files");
    Collection<Part> parts = request.getParts();

    for (Part part : parts) {
      if (!part.getName().equals("files") || part.getSize() == 0) {
        continue;
      }

      String filename = UUID.randomUUID().toString();
      part.write(dirPath + "/" + filename);
      attachedFiles.add(new AttachedFile(filename));
    }
    return attachedFiles;
  }

  @GetMapping("list")
  public String list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    req.setAttribute("boards",  boardService.list());
    return "/board/list.jsp";
  }

  @GetMapping("detail")
  public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int boardNo = Integer.parseInt(request.getParameter("no"));

    Board board = boardService.get(boardNo);

    if (board == null) {
      throw new Exception("해당 번호의 게시글이 없습니다!");
    }

    request.setAttribute("board",  board);

    return "/board/detail.jsp";
  }

  @PostMapping("update")
  public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    board.setAttachedFiles(saveAttachedFiles(request));

    checkOwner(board.getNo(), request.getSession());

    if (!boardService.update(board)) {
      throw new Exception("게시글을 변경할 수 없습니다!");
    }

    return "redirect:list";
  }

  private void checkOwner(int boardNo, HttpSession session) throws Exception {
    Member loginMember = (Member) session.getAttribute("loginMember");
    if (boardService.get(boardNo).getWriter().getNo() != loginMember.getNo()) {
      throw new Exception("게시글 작성자가 아닙니다.");
    }
  }

  @GetMapping("delete") // 요청이 들어 왔을 때 호출될 메서드에 붙이는 애노테이션
  public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    checkOwner(no, request.getSession());

    if (!boardService.delete(no)) {
      throw new Exception("게시글 삭제할 수 없습니다.");
    }

    return "redirect:list";
  }

  @GetMapping("fileDelete")
  public String fileDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    // 첨부파일 정보를 가져온다.
    AttachedFile attachedFile = boardService.getAttachedFile(no);

    // 게시글의 작성자가 로그인 사용자인지 검사한다.
    Member loginMember = (Member) request.getSession().getAttribute("loginMember");
    Board board = boardService.get(attachedFile.getBoardNo());

    if (board.getWriter().getNo() != loginMember.getNo()) {
      throw new Exception("게시글 작성자가 아닙니다.");
    }

    // 첨부파일을 삭제한다.
    if (!boardService.deleteAttachedFile(no)) {
      throw new Exception("게시글 첨부파일을 삭제할 수 없습니다.");
    }

    return "redirect:detail?no=" + board.getNo();
  }
}

















