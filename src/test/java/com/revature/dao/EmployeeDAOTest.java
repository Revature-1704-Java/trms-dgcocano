package com.revature.app;

import com.revature.dao.EmployeeDAO;
import com.revature.beans.Employee;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import java.util.ArrayList;
/**
 * Unit test for simple EmployeeDAO.
 */
public class EmployeeDAOTest 
    extends TestCase
{
    static EmployeeDAO employeeDAO = new EmployeeDAO("/home/danny/Revature/trms-dgcocano/trms/test.properties");
    static Employee employeeSeven = new Employee(7,7,7,7, "email7@test.com", "password7", "firstname7", "lastname7");
    static Employee employeeEight = new Employee(8,8,8,8, "email8@test.com", "password8", "firstname8", "lastname8");
    static Employee employeeNine = new Employee(9,9,9,9, "email9@test.com", "password9", "firstname9", "lastname9");
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public EmployeeDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @remployeeurn the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( EmployeeDAOTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    @BeforeClass public static void setup() {
      employeeDAO = new EmployeeDAO("/home/danny/Revature/trms-dgcocano/trms/test.properties");
    }
    @AfterClass public static void close() {
      employeeDAO.close();
    }

    public static void testGetById() {
      Employee emp = employeeDAO.getById(1);
      assertEquals(1, emp.getEmployeeId());
    }
    public static void testInsertSeven() {
      int x = employeeDAO.add(employeeSeven);
      employeeDAO.remove(employeeSeven.getEmployeeId());
      assertEquals(1, x);
    }

    public static void testInsertEight() {
      int x = employeeDAO.add(employeeEight);
      employeeDAO.remove(employeeEight.getEmployeeId());
      assertEquals(1, x);
    }

    public static void testDeleteSeven() {
      employeeDAO.add(employeeSeven);
      int x = employeeDAO.remove(employeeSeven.getEmployeeId());
      assertEquals(1, x);
    }

    public static void testDeleteEight() {
      employeeDAO.add(employeeEight);
      int x = employeeDAO.remove(employeeEight.getEmployeeId());
      assertEquals(1, x);
    }

    public static void testGetByLogin() {
      employeeDAO.add(employeeSeven);
      Employee empSevenRequested = employeeDAO.getByLogin(employeeSeven.getEmail(), employeeSeven.getCredential());
      employeeDAO.remove(employeeSeven.getEmployeeId());
      assertEquals(employeeSeven.getEmployeeId(), empSevenRequested.getEmployeeId());
    }
      
    public static void testMultipleInsert() {
      int x = employeeDAO.add(employeeSeven);
      x += employeeDAO.add(employeeEight);
      x += employeeDAO.add(employeeNine);
      employeeDAO.remove(employeeSeven.getEmployeeId());
      employeeDAO.remove(employeeEight.getEmployeeId());
      employeeDAO.remove(employeeNine.getEmployeeId());
      assertEquals(3, x);
    }

    public static void testEmployeeMultiple() {
      employeeDAO.add(employeeSeven);
      employeeDAO.add(employeeEight);
      employeeDAO.add(employeeNine);
      int x = employeeDAO.remove(employeeSeven.getEmployeeId());
      x += employeeDAO.remove(employeeEight.getEmployeeId());
      x += employeeDAO.remove(employeeNine.getEmployeeId());
      assertEquals(3, x);
    }

    public static void testGetAll() {
      employeeDAO.add(employeeSeven);
      employeeDAO.add(employeeEight);
      employeeDAO.add(employeeNine);
      ArrayList<Employee> list = employeeDAO.getAll();
      employeeDAO.remove(employeeSeven.getEmployeeId());
      employeeDAO.remove(employeeEight.getEmployeeId());
      employeeDAO.remove(employeeNine.getEmployeeId());
      assertEquals(9, list.size());
    }
}
