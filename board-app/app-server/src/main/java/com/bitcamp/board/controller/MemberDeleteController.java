package com.bitcamp.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.bitcamp.board.service.MemberService;

@Controller
public class MemberDeleteController {

  MemberService memberService;

  public MemberDeleteController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/member/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    if (!memberService.delete(no)) {
      throw new Exception("회원 삭제 실패!");
    }

    return "redirect:list";
  }
}

















