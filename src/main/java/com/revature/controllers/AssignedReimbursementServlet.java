package com.revature.controllers;
// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.GradingFormatDAO;
import com.revature.beans.GradingFormat;
import com.revature.beans.Reimbursement;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.*;
 
// Extend HttpServlet class
public class AssignedReimbursementServlet extends HttpServlet {
 
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
         
      // Create a session object if it is already not  created.
      HttpSession session = request.getSession(true);
         
      String title = "Reimbursements";

      // Check if this is new comer on your web page.
      if (session.getAttribute("email") == null) {
        RequestDispatcher rs = request.getRequestDispatcher("index.html");
        rs.forward(request, response);
      }
    

      ReimbursementDAO reimbursementDAO = new ReimbursementDAO("/home/danny/Revature/trms-dgcocano/trms/test.properties");

      ArrayList<Reimbursement> reimbursements = reimbursementDAO.getAssignedReimbursements((int)session.getAttribute("employeeId"));

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      String html =  "<h1 align = \"center\">" + title + "</h1>\n" +
               "<h2 align = \"center\">" + title + "</h2>\n" +
               "<table class=\"table table-hover table-striped table-bordered table-condensed\" border = \"1\" align = \"center\">\n" +
                  "<tr bgcolor = \"#949494\">\n" +
                     "  <th>" + title + "</th><th>value</th>";
      for(Reimbursement reim : reimbursements) {
        html+=("<tr>\n" + "<td>Reimbursement " + reim.getReimbursementId() + "</td>\n</tr>\n");
      }
      html += "</table>\n</body>\n</html>";
      out.println(html);
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
         
      // Create a session object if it is already not  created.
      HttpSession session = request.getSession(true);
         
      String title = "Reimbursements Assigned To You";

      // Check if this is new comer on your web page.
      if (session.getAttribute("email") == null) {
        RequestDispatcher rs = request.getRequestDispatcher("index.html");
        rs.forward(request, response);
      }
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      if((int)session.getAttribute("employeeTypeId") == 1) {
        out.println();
      }
      else if((int)session.getAttribute("employeeTypeId") > 1) {

  
      ReimbursementDAO reimbursementDAO = new ReimbursementDAO("/home/danny/Revature/trms-dgcocano/trms/test.properties");
  
      ArrayList<Reimbursement> reimbursements = reimbursementDAO.getAssignedReimbursements((int)session.getAttribute("employeeId"));
        reimbursementDAO.close();
        // Set response content type
  
      String html =  "<h1 align = \"center\">" + title + "</h1>\n" +
               "<table class=\"table table-hover table-striped table-bordered table-condensed\" border = \"1\" align = \"center\">\n" +
                    "<tr bgcolor = \"#949494\">\n"; 
        html+="<tr>\n<td>ReimbursementId</td><td>EmployeeId</td><td>GradingFormatId</td><td>Cost</td><td>SubmissionTime</td><td>TimeMissed</td><td>Justification</td><td>Urgent</td><td>Exceeding</td></tr>";
        for(Reimbursement reim : reimbursements) {
                html+=("<tr>\n" + "<td>"+reim.getReimbursementId()+"</td><td>"+reim.getEmployeeId()+"</td><td>"+reim.getGradingFormatId()+"</td><td>"+ reim.getCost()+"</td><td>"+reim.getSubmissionTime()+"</td><td>"+reim.getTimeMissed()+"</td><td>"+reim.getJustification()+
              "</td><td>" + reim.getUrgent() + "</td><td>" + reim.getExceeding() + "</td><td><form action=\"approveReimbursement\" method=\"post\"><input type=\"hidden\"name=\"reimbursementId\" value=\"" + reim.getReimbursementId() + "\"><button class=\"btn btn-success\">APPROVE</button></form></td><td><form action=\"denyReimbursement\" method=\"post\"><input type=\"hidden\"name=\"reimbursementId\" value=\"" + reim.getReimbursementId() + "\"><button class=\"btn btn-danger\">DENY</button></form></td><td><button class=\"btn btn-info disabled\">Info</button></td>\n</tr>\n");
        
        }
        html += "</table>\n</body>\n</html>";
        out.println(html);
      }
   }
}
