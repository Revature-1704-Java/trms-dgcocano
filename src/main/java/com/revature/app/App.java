package com.revature.app;
import com.revature.dao.*;

import com.revature.beans.*;
import java.util.*;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      EmployeeTypeDAO emtD = new EmployeeTypeDAO();
      DepartmentDAO dD = new DepartmentDAO();
      GradingFormatDAO gfD = new GradingFormatDAO();
      EventTypeDAO etD = new EventTypeDAO();
      EventDAO evD = new EventDAO();
      EmployeeDAO emD = new EmployeeDAO();
      ResponseTypeDAO rtD = new ResponseTypeDAO();
      ResponseDAO rD = new ResponseDAO();
      AttachmentDAO atD = new AttachmentDAO();
      ReimbursementDAO reimD = new ReimbursementDAO("/home/danny/Revature/trms-dgcocano/trms/test.properties");


      ArrayList<Reimbursement> reims = reimD.getByEmployeeId(1);
      System.out.println("reims from main" + reims);
    }
}
