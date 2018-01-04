package com.revature.controllers;
// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
 
// Extend HttpServlet class
public class SessionTracking extends HttpServlet {
 
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
         
      // Create a session object if it is already not  created.
      HttpSession session = request.getSession(true);
         
      String title = "Welcome Back to my website";

      // Check if this is new comer on your web page.
      if (session.isNew()) {
        RequestDispatcher rs = request.getRequestDispatcher("index.html");
        rs.forward(request, response);
      } else {
      }

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";

      out.println(docType +
         "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            
            "<body bgcolor = \"#f0f0f0\">\n" +
               "<h1 align = \"center\">" + title + "</h1>\n" +
               "<h2 align = \"center\">Session Infomation</h2>\n" +
               "<table border = \"1\" align = \"center\">\n" +
                  
                  "<tr bgcolor = \"#949494\">\n" +
                     "  <th>Session info</th><th>value</th> </tr>\n" +
                     
                  "<tr>\n" +
                    "<td>email</td>\n" +
                    "<td>" + session.getAttribute("email") + "</td> </tr>\n" +
                    "<tr>\n" +
                    "<td>First Name</td>\n" +
                    "<td>" + session.getAttribute("firstname") + "</td> </tr>\n" +

                    "<tr>\n" +
                    "<td>Last Name</td>\n" +
                    "<td>" + session.getAttribute("lastname") + "</td> </tr>\n" +

                    "<tr>\n" +
                    "<td>DepartmentId</td>\n" +
                    "<td>" + session.getAttribute("departmentId") + "</td> </tr>\n" +
                    "<tr>\n" +
                    "<td>EmployeeTypeId</td>\n" +
                    "<td>" + session.getAttribute("employeeTypeId") + "</td> </tr>\n" +

               "</table>\n" +
            "</body>\n </html>"
      );
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
         
      // Create a session object if it is already not  created.
      HttpSession session = request.getSession(true);
         
      String title = "SessionDetails";

      // Check if this is new comer on your web page.
      if (session.getAttribute("email") == null) {
        RequestDispatcher rs = request.getRequestDispatcher("index.html");
        rs.forward(request, response);
      } else {
      }

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";

      out.write( "<h1 align = \"center\">" + title + "</h1>\n" +
               "<h2 align = \"center\">Session Infomation</h2>\n" +
               "<table border = \"1\" align = \"center\">\n" +
                  
                  "<tr bgcolor = \"#949494\">\n" +
                     "  <th>Session info</th><th>value</th> </tr>\n" +
               
                  "<tr>\n" +
                    "<td>employeeId</td>\n" +
                    "<td>" + session.getAttribute("employeeId") + "</td> </tr>\n" +
                    "<tr>\n" +
                    "<td>email</td>\n" +
                    "<td>" + session.getAttribute("email") + "</td> </tr>\n" +
                    "<tr>\n" +
                    "<td>First Name</td>\n" +
                    "<td>" + session.getAttribute("firstname") + "</td> </tr>\n" +

                    "<tr>\n" +
                    "<td>Last Name</td>\n" +
                    "<td>" + session.getAttribute("lastname") + "</td> </tr>\n" +

                    "<tr>\n" +
                    "<td>DepartmentId</td>\n" +
                    "<td>" + session.getAttribute("departmentId") + "</td> </tr>\n" +
                    "<tr>\n" +
                    "<td>EmployeeTypeId</td>\n" +
                    "<td>" + session.getAttribute("employeeTypeId") + "</td> </tr>\n" +
               "</table>\n" +
            "</body>\n </html>"
      );
   }
}
