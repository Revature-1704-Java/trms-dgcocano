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
public class LoginServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
    HttpSession session = request.getSession(true);
    RequestDispatcher rs;
    rs = request.getRequestDispatcher("index.html");
    rs.forward(request,response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {

    response.setContentType("application/json"); //Technically not needed, lets browser know exactly what its dealing with

    ObjectMapper mapper = new ObjectMapper();
    ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();

    String email = request.getParameter("email");
    String password = request.getParameter("pass");

    EmployeeDAO empD = new EmployeeDAO("/home/danny/Revature/trms-dgcocano/trms/test.properties");
    
    Employee selected = empD.getByLogin(email, password);
    empD.close();
    if(selected == null) {
      RequestDispatcher rs = request.getRequestDispatcher("index.html");
      rs.forward(request, response);
    }
    else {
      HttpSession session = request.getSession(true);
      String employeeIdKey = "employeeId";
      int employeeId = selected.getEmployeeId();
      String employeeTypeIdKey = "employeeTypeId";
      int employeeTypeId = selected.getEmployeeTypeId();
      String emailKey = "email";
      String emailSession = selected.getEmail();
      String firstNameKey = "firstname";
      String firstNameSession = selected.getFirstname();
      String lastNameKey = "lastname";
      String lastNameSession = selected.getLastname();
      String departmentKey = "departmentId";
      int department = selected.getDepartmentId();
      session.setAttribute(employeeIdKey, employeeId);
      session.setAttribute(emailKey, emailSession);
      session.setAttribute(firstNameKey, firstNameSession);
      session.setAttribute(lastNameKey, lastNameSession);
      session.setAttribute(departmentKey, department);
      session.setAttribute(employeeTypeIdKey, employeeTypeId);
      RequestDispatcher rs = request.getRequestDispatcher("welcome.html");
      response.setContentType("text/html");
      rs.forward(request, response);
      //mapper.writeValue(response.getOutputStream(), writer.writeValueAsString(reimbursements));

    }
  }

}
