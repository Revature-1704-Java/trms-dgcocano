package com.revature.controllers;
// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.Timestamp;
 
import com.revature.dao.ReimbursementDAO;
import com.revature.beans.Reimbursement;
// Extend HttpServlet class
public class SubmissionFormServlet extends HttpServlet {
 
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
         
      // Create a session object if it is already not  created.
      HttpSession session = request.getSession(true);

      // Check if this is new comer on your web page.
      if (session.isNew()) {
        RequestDispatcher rs = request.getRequestDispatcher("index.html");
        rs.forward(request, response);
      }
      ReimbursementDAO reimD = new ReimbursementDAO("/home/danny/Revature/trms-dgcocano/trms/test.properties");
      ArrayList<Reimbursement> reims = reimD.getAll();
      int x = 0;
      int reimbursementId = 1;
      if(reims.size() > 0) {
        reimbursementId = Collections.max(reims).getReimbursementId() + 1;
      }
      if(request.getParameter("eventId") == null) {
        RequestDispatcher rs = request.getRequestDispatcher("submit.html");
        rs.forward(request, response);
      }
        int employeeId = (int)session.getAttribute("employeeId");
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        int gradingFormatId = Integer.parseInt(request.getParameter("gradingFormat"));
        int assignedTo = Integer.parseInt(request.getParameter("assignedTo"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        Timestamp submissiontime = new Timestamp(2);
        Timestamp curTime =  new Timestamp(System.currentTimeMillis());
        int timemissed = Integer.parseInt(request.getParameter("timemissed"));
        String justification = request.getParameter("justification");
        int urgent = 0;
        int exceeding = 0;
        Reimbursement toAdd = new Reimbursement(reimbursementId, employeeId, eventId, assignedTo, gradingFormatId, cost, curTime, timemissed, justification, urgent, exceeding);
        x = reimD.add(toAdd);
      response.setContentType("text/html");
      if(x == 0) {
        RequestDispatcher rs = request.getRequestDispatcher("submit.html");
        rs.forward(request, response);
      }
      else if(x == 1) {
        RequestDispatcher rs = request.getRequestDispatcher("welcome.html");
        rs.forward(request, response);
      }
      else {
        RequestDispatcher rs = request.getRequestDispatcher("index.html");
        rs.forward(request, response);
      }

   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
         
      // Create a session object if it is already not  created.
      HttpSession session = request.getSession(true);

      // Check if this is new comer on your web page.
      if (session.getAttribute("email") == null) {
        RequestDispatcher rs = request.getRequestDispatcher("index.html");
        rs.forward(request, response);
      }

      // Set response content type
      response.setContentType("text/html");
      RequestDispatcher rs = request.getRequestDispatcher("submit.html");
      rs.forward(request, response);

   }
}
