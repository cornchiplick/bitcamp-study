package com.bitcamp.board.handler;

import java.io.PrintWriter;
import java.util.Map;
import com.bitcamp.servlet.Servlet;
import com.bitcamp.servlet.annotation.WebServlet;

@WebServlet(value="/calc")
public class CalculatorHandler implements Servlet {

  @Override
  public void service(Map<String,String> paramMap, PrintWriter out) {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("</head>");
    out.println("<body>");

    int a = Integer.parseInt(paramMap.get("a"));
    int b = Integer.parseInt(paramMap.get("b"));

    switch () {



    }

    out.println("<h1>ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ임가오프ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ</h1>");
    out.println("</body>");
    out.println("</html>");
  }
}
