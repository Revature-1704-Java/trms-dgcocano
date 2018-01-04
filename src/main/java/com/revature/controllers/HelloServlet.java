package com.revature.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.dao.EmployeeDAO;
import com.revature.beans.Employee;
import javax.servlet.ServletException;
import java.io.*;
public class HelloServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    String jsonString = "{\"name\":\"Mehrab Rahman\"}";

    response.setContentType("text/html"); //Technically not needed, lets browser know exactly what its dealing with

    PrintWriter out = response.getWriter();
    out.println("<p>Hello</p>");
    
  }

}
