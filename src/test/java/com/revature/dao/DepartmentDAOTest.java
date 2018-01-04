package com.revature.app;

import com.revature.dao.DepartmentDAO;
import com.revature.beans.Department;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import java.util.ArrayList;
/**
 * Unit test for simple DepartmentDAO.
 */
public class DepartmentDAOTest 
    extends TestCase
{
    static DepartmentDAO departmentDAO = new DepartmentDAO("./test.properties");
    static Department departmentFour = new Department(10, "title"); 
    static Department departmentFive = new Department(11, "title"); 
    static Department departmentSix = new Department(12, "title"); 
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public DepartmentDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @rdepartmenturn the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DepartmentDAOTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    @BeforeClass public static void setup() {
      departmentDAO = new DepartmentDAO("./test.properties");
    }
    @AfterClass public static void close() {
      departmentDAO.close();
    }
    public static void testInsertFour() {
      int x = departmentDAO.add(departmentFour);
      departmentDAO.remove(departmentFour.getDepartmentId());
      assertEquals(1, x);
    }

    public static void testInsertFive() {
      int x = departmentDAO.add(departmentFive);
      departmentDAO.remove(departmentFive.getDepartmentId());
      assertEquals(1, x);
    }

    public static void testDeleteFour() {
      departmentDAO.add(departmentFour);
      int x = departmentDAO.remove(departmentFour.getDepartmentId());
      assertEquals(1, x);
    }

    public static void testDeleteFive() {
      departmentDAO.add(departmentFive);
      int x = departmentDAO.remove(departmentFive.getDepartmentId());
      assertEquals(1, x);
    }

    public static void testMultipleInsert() {
      int x = departmentDAO.add(departmentFour);
      x += departmentDAO.add(departmentFive);
      x += departmentDAO.add(departmentSix);
      departmentDAO.remove(departmentFour.getDepartmentId());
      departmentDAO.remove(departmentFive.getDepartmentId());
      departmentDAO.remove(departmentSix.getDepartmentId());
      assertEquals(3, x);
    }

    public static void testDepartmentMultiple() {
      departmentDAO.add(departmentFour);
      departmentDAO.add(departmentFive);
      departmentDAO.add(departmentSix);
      int x = departmentDAO.remove(departmentFour.getDepartmentId());
      x += departmentDAO.remove(departmentFive.getDepartmentId());
      x += departmentDAO.remove(departmentSix.getDepartmentId());
      assertEquals(3, x);
    }

    public static void testGetAll() {
      departmentDAO.add(departmentFour);
      departmentDAO.add(departmentFive);
      departmentDAO.add(departmentSix);
      ArrayList<Department> list = departmentDAO.getAll();
      departmentDAO.remove(departmentFour.getDepartmentId());
      departmentDAO.remove(departmentFive.getDepartmentId());
      departmentDAO.remove(departmentSix.getDepartmentId());
      assertEquals(12, list.size());
    }
}
