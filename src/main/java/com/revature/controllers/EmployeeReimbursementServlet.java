package com.revature.controllers;
// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.revature.dao.ReimbursementDAO;
import com.revature.beans.Reimbursement;
import java.util.ArrayList;
 
// Extend HttpServlet class
public class EmployeeReimbursementServlet extends HttpServlet {
 
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
         
      // Create a session object if it is already not  created.
      HttpSession session = request.getSession(true);
         
        RequestDispatcher rs = request.getRequestDispatcher("index.html");
        rs.forward(request, response);
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
         
      // Create a session object if it is already not  created.
      HttpSession session = request.getSession(true);
         
      String title = "Your Reimbursements";
      String titleApproved = "Approved Reimbursements";
      String titlePending = "Pending Reimbursements";
      String titleDenied = "Denied Reimbursements";

      // Check if this is new comer on your web page.
      if (session.getAttribute("email") == null) {
        RequestDispatcher rs = request.getRequestDispatcher("index.html");
        rs.forward(request, response);
      }

      ReimbursementDAO reimbursementDAO = new ReimbursementDAO("/home/danny/Revature/trms-dgcocano/trms/test.properties");

      ArrayList<Reimbursement> reimbursements = reimbursementDAO.getByEmployeeId((int)session.getAttribute("employeeId"));
      reimbursementDAO.close();

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      String html = "";
      String htmlGenericHeader =  "<h1 align = \"center\">" + title + "</h1>\n" +
               "<table class=\"table table-hover table-striped table-bordered table-condensed\" border = \"1\" align = \"center\">\n" +
                  "<tr bgcolor = \"#949494\">\n"; 
      String htmlApprovedHeader =  "<h1 align = \"center\">" + titleApproved + "</h1>\n" +
               "<table class=\"table table-hover table-striped table-bordered table-condensed\" border = \"1\" align = \"center\">\n" +
                  "<tr bgcolor = \"#949494\">\n"; 
      String htmlPendingHeader =  "<h1 align = \"center\">" + titlePending + "</h1>\n" +
               "<table class=\"table table-hover table-striped table-bordered table-condensed\" border = \"1\" align = \"center\">\n" +
                  "<tr bgcolor = \"#949494\">\n"; 
      String htmlDeniedHeader =  "<h1 align = \"center\">" + titleDenied + "</h1>\n" +
               "<table class=\"table table-hover table-striped table-bordered table-condensed\" border = \"1\" align = \"center\">\n" +
                  "<tr bgcolor = \"#949494\">\n"; 
      String htmlTableFooter = "</table>\n";
      String htmlTableHeader ="<tr>\n<td>ReimbursementId</td><td>GradingFormatId</td><td>Cost</td><td>SubmissionTime</td><td>TimeMissed</td><td>Justification</td><td>Urgent</td><td>Exceeding</td></tr>";
      String htmlPendingTableHeader ="<tr>\n<td>ReimbursementId</td><td>GradingFormatId</td><td>AssignedTo</td><td>Cost</td><td>SubmissionTime</td><td>TimeMissed</td><td>Justification</td><td>Urgent</td><td>Exceeding</td></tr>";
      
      html += htmlApprovedHeader;
      html += htmlTableHeader;

      for(Reimbursement reim : reimbursements) {
        if(reim.getAssignedTo() == 0) {
          String htmlTableRow = ("<tr>\n" + "<td>"+reim.getReimbursementId()+"</td><td>"+reim.getGradingFormatId()+"</td><td>" + reim.getCost()+"</td><td>"+reim.getSubmissionTime()+"</td><td>"+reim.getTimeMissed()+"</td><td>"+reim.getJustification()+
              "</td><td>" + reim.getUrgent() + "</td><td>" + reim.getExceeding() + "</td>\n</tr>\n");
          html+= htmlTableRow;
        }
      }
      html+= htmlTableFooter;
      html+= htmlPendingHeader;
      html+= htmlPendingTableHeader;

      for(Reimbursement reim : reimbursements) {
        if(reim.getAssignedTo() > 0) {
          String htmlTableRow = ("<tr>\n" + "<td>"+reim.getReimbursementId()+"</td><td>"+reim.getGradingFormatId()+"</td><td>"+ reim.getAssignedTo() + "</td><td>" + reim.getCost()+"</td><td>"+reim.getSubmissionTime()+"</td><td>"+reim.getTimeMissed()+"</td><td>"+reim.getJustification()+
              "</td><td>" + reim.getUrgent() + "</td><td>" + reim.getExceeding() + "</td>\n</tr>\n");
          html+= htmlTableRow;
        }
      }
      html+= htmlTableFooter;
      html+= htmlDeniedHeader;
      html+= htmlTableHeader;

      for(Reimbursement reim : reimbursements) {
        if(reim.getAssignedTo() < 0) {
          String htmlTableRow = ("<tr>\n" + "<td>"+reim.getReimbursementId()+"</td><td>"+reim.getGradingFormatId()+"</td><td>" + reim.getCost()+"</td><td>"+reim.getSubmissionTime()+"</td><td>"+reim.getTimeMissed()+"</td><td>"+reim.getJustification()+
              "</td><td>" + reim.getUrgent() + "</td><td>" + reim.getExceeding() + "</td>\n</tr>\n");
          html+= htmlTableRow;
        }
      }
      html+=htmlTableFooter;
      out.println(html);
   }
}
