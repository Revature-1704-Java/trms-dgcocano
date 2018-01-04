package com.revature.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.dao.EmployeeDAO;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAO;
import java.util.ArrayList;
import java.io.*;
public class WelcomeServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
    HttpSession session = request.getSession(true);
    RequestDispatcher rs;
    if(session.getAttribute("email") == null) {
      rs = request.getRequestDispatcher("index.html");
      rs.forward(request,response);
    }
    else {
      rs = request.getRequestDispatcher("welcome.html");
      rs.forward(request,response);
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {

    HttpSession session = request.getSession(true);
    RequestDispatcher rs;
    if(session.getAttribute("email") == null) {
      rs = request.getRequestDispatcher("index.html");
      rs.forward(request,response);
    }
    else {
      response.setContentType("text/html");
      rs = request.getRequestDispatcher("welcome.html");
      rs.include(request,response);
    }
  }
}
