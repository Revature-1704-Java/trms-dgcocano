package com.revature.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ResponseDAO;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.beans.Response;

import java.util.ArrayList;
import java.util.*;
import java.sql.Timestamp;
import java.io.*;
public class DenyReimbursementServlet extends HttpServlet {

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

    if(request.getParameter("reimbursementId") == null) {
      RequestDispatcher rs = request.getRequestDispatcher("index.html");
      rs.forward(request, response);
    }
    HttpSession session = request.getSession(true);

    if(request.getParameter("reimbursementId") == null) {
      RequestDispatcher rs = request.getRequestDispatcher("welcome.html");
      rs.forward(request, response);
    }
    Response responseToAdd;

    int reimId = Integer.parseInt(request.getParameter("reimbursementId"));

    Timestamp curTime = new Timestamp(System.currentTimeMillis());
    EmployeeDAO empD = new EmployeeDAO("/home/danny/Revature/trms-dgcocano/trms/test.properties");
    ResponseDAO responseD = new ResponseDAO("/home/danny/Revature/trms-dgcocano/trms/test.properties");
    ReimbursementDAO reimD = new ReimbursementDAO("/home/danny/Revature/trms-dgcocano/trms/test.properties");

    Reimbursement denied = reimD.getById(reimId);
    Employee viewer = empD.getById((int)session.getAttribute("employeeId"));
    Employee owner = empD.getById(denied.getEmployeeId());

    Employee supervisor = empD.getById(owner.getSupervisor());
    Employee depHead = empD.getDepartmentHead(owner.getDepartmentId());
    int depHeadId = depHead.getEmployeeId();
    empD.close();


    int employeeTypeId = (int)session.getAttribute("employeeTypeId");
    int employeeId = (int)session.getAttribute("employeeId");
    int maxId = 0;

    ArrayList<Response> responses = responseD.getByReimbursementId(reimId);

    if(responses.size()>0) {
      maxId = Collections.max(responses).getResponseId();
    }

    if(responses.size()==0) {
      if(employeeTypeId == 3) {
        responseToAdd = new Response(maxId+1, reimId, employeeId, 2, curTime);
        responseD.add(responseToAdd);
        responseToAdd = new Response(maxId+2, reimId, employeeId, 3, curTime);
        responseD.add(responseToAdd);
        denied.setAssignedTo(-1);
        int x = reimD.update(denied.getReimbursementId(), denied);
        responseD.close();
        reimD.close();
      }
      else if(employeeTypeId==2) {
        responseToAdd = new Response(maxId+1, reimId, employeeId, employeeTypeId, curTime);
        responseD.add(responseToAdd);
        denied.setAssignedTo(-1);
        int x = reimD.update(denied.getReimbursementId(), denied);
        responseD.close();
        reimD.close();
      }
      else if(employeeTypeId ==0) {
        RequestDispatcher rs = request.getRequestDispatcher("index.html");
        rs.forward(request, response);
      }
    }
    else if(responses.size()==1) {
      responseToAdd = new Response(maxId+1, reimId, employeeId, employeeTypeId, curTime);
      responseD.add(responseToAdd);
      denied.setAssignedTo(-1);
      reimD.update(denied.getReimbursementId(), denied);
        responseD.close();
        reimD.close();
    }
        
    RequestDispatcher rs = request.getRequestDispatcher("welcome.html");
    rs.forward(request, response);
  }
}
