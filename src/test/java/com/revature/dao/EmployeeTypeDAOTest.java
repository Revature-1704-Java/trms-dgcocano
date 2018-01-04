package com.revature.app;

import com.revature.dao.EmployeeTypeDAO;
import com.revature.beans.EmployeeType;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import java.util.ArrayList;
/**
 * Unit test for simple EmployeeTypeDAO.
 */
public class EmployeeTypeDAOTest 
    extends TestCase
{
    static EmployeeTypeDAO employeeTypeDAO = new EmployeeTypeDAO("./test.properties");
    static EmployeeType employeeTypeFour = new EmployeeType(10, "title"); 
    static EmployeeType employeeTypeFive = new EmployeeType(11, "title"); 
    static EmployeeType employeeTypeSix = new EmployeeType(12, "title"); 
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public EmployeeTypeDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @remployeeTypeurn the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( EmployeeTypeDAOTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    @BeforeClass public static void setup() {
      employeeTypeDAO = new EmployeeTypeDAO("./test.properties");
    }
    @AfterClass public static void close() {
      employeeTypeDAO.close();
    }
    public static void testInsertFour() {
      int x = employeeTypeDAO.add(employeeTypeFour);
      employeeTypeDAO.remove(employeeTypeFour.getEmployeeTypeId());
      assertEquals(1, x);
    }

    public static void testInsertFive() {
      int x = employeeTypeDAO.add(employeeTypeFive);
      employeeTypeDAO.remove(employeeTypeFive.getEmployeeTypeId());
      assertEquals(1, x);
    }

    public static void testDeleteFour() {
      employeeTypeDAO.add(employeeTypeFour);
      int x = employeeTypeDAO.remove(employeeTypeFour.getEmployeeTypeId());
      assertEquals(1, x);
    }

    public static void testDeleteFive() {
      employeeTypeDAO.add(employeeTypeFive);
      int x = employeeTypeDAO.remove(employeeTypeFive.getEmployeeTypeId());
      assertEquals(1, x);
    }

    public static void testMultipleInsert() {
      int x = employeeTypeDAO.add(employeeTypeFour);
      x += employeeTypeDAO.add(employeeTypeFive);
      x += employeeTypeDAO.add(employeeTypeSix);
      employeeTypeDAO.remove(employeeTypeFour.getEmployeeTypeId());
      employeeTypeDAO.remove(employeeTypeFive.getEmployeeTypeId());
      employeeTypeDAO.remove(employeeTypeSix.getEmployeeTypeId());
      assertEquals(3, x);
    }

    public static void testEmployeeTypeMultiple() {
      employeeTypeDAO.add(employeeTypeFour);
      employeeTypeDAO.add(employeeTypeFive);
      employeeTypeDAO.add(employeeTypeSix);
      int x = employeeTypeDAO.remove(employeeTypeFour.getEmployeeTypeId());
      x += employeeTypeDAO.remove(employeeTypeFive.getEmployeeTypeId());
      x += employeeTypeDAO.remove(employeeTypeSix.getEmployeeTypeId());
      assertEquals(3, x);
    }

    public static void testGetAll() {
      employeeTypeDAO.add(employeeTypeFour);
      employeeTypeDAO.add(employeeTypeFive);
      employeeTypeDAO.add(employeeTypeSix);
      ArrayList<EmployeeType> list = employeeTypeDAO.getAll();
      employeeTypeDAO.remove(employeeTypeFour.getEmployeeTypeId());
      employeeTypeDAO.remove(employeeTypeFive.getEmployeeTypeId());
      employeeTypeDAO.remove(employeeTypeSix.getEmployeeTypeId());
      assertEquals(12, list.size());
    }
}
