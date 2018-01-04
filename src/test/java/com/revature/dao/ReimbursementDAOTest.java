package com.revature.app;

import com.revature.dao.ReimbursementDAO;
import com.revature.beans.Reimbursement;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import java.util.ArrayList;
import java.sql.Timestamp;
/**
 * Unit test for simple ReimbursementDAO.
 */
public class ReimbursementDAOTest 
    extends TestCase
{
    static Timestamp timestamp = Timestamp.valueOf("2004-06-23 10:10:10.0");
    static ReimbursementDAO reimbursementDAO = new ReimbursementDAO("/home/danny/Revature/trms-dgcocano/trms/test.properties");
    static Reimbursement reimbursementFour = new Reimbursement(4,4,4,4,4, 100.10, timestamp, 40, "justification4", 0, 0);
    static Reimbursement reimbursementFive = new Reimbursement(5,5,5,5,5, 100.10, timestamp, 50, "justification5", 0, 0);
    static Reimbursement reimbursementSix = new Reimbursement(6,6,6,6,6, 100.10, timestamp, 60, "justification6", 0, 0);
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public ReimbursementDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @rreimbursementurn the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ReimbursementDAOTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    @BeforeClass public static void setup() {
      reimbursementDAO = new ReimbursementDAO("/home/danny/Revature/trms-dgcocano/trms/test.properties");
    }
    @AfterClass public static void close() {
      reimbursementDAO.close();
    }
    public static void testUpdateTwo() {
      int x = reimbursementDAO.update(2, new Reimbursement(2,1,2,2,3,1000, timestamp, 20, "Justification", 0,0));
      x = reimbursementDAO.getById(2).getEmployeeId();
      assertEquals(1, x);
    }
    public static void testGetOne() {
      Reimbursement reim = reimbursementDAO.getById(1);
      assertEquals(1, reim.getEmployeeId());
    }
    public static void testGetByEmployeeId() {
      reimbursementDAO.add(reimbursementFour);
      ArrayList<Reimbursement> reim = reimbursementDAO.getByEmployeeId(reimbursementFour.getEmployeeId());
      reimbursementDAO.remove(reimbursementFour.getReimbursementId());
      assertEquals(1, reim.size());
    }

    public static void testGetByUrgent() {
      ArrayList<Reimbursement> reim = reimbursementDAO.getByUrgent(0);
      assertEquals(3, reim.size());
    }
      
    public static void testInsertFour() { int x = reimbursementDAO.add(reimbursementFour);
      reimbursementDAO.remove(reimbursementFour.getReimbursementId());
      assertEquals(1, x);
    }

    public static void testInsertFive() {
      int x = reimbursementDAO.add(reimbursementFive);
      reimbursementDAO.remove(reimbursementFive.getReimbursementId());
      assertEquals(1, x);
    }

    public static void testDeleteFour() {
      reimbursementDAO.add(reimbursementFour);
      int x = reimbursementDAO.remove(reimbursementFour.getReimbursementId());
      assertEquals(1, x);
    }

    public static void testDeleteFive() {
      reimbursementDAO.add(reimbursementFive);
      int x = reimbursementDAO.remove(reimbursementFive.getReimbursementId());
      assertEquals(1, x);
    }

    public static void testMultipleInsert() {
      int x = reimbursementDAO.add(reimbursementFour);
      x += reimbursementDAO.add(reimbursementFive);
      x += reimbursementDAO.add(reimbursementSix);
      reimbursementDAO.remove(reimbursementFour.getReimbursementId());
      reimbursementDAO.remove(reimbursementFive.getReimbursementId());
      reimbursementDAO.remove(reimbursementSix.getReimbursementId());
      assertEquals(3, x);
    }

    public static void testReimbursementMultiple() {
      reimbursementDAO.add(reimbursementFour);
      reimbursementDAO.add(reimbursementFive);
      reimbursementDAO.add(reimbursementSix);
      int x = reimbursementDAO.remove(reimbursementFour.getReimbursementId());
      x += reimbursementDAO.remove(reimbursementFive.getReimbursementId());
      x += reimbursementDAO.remove(reimbursementSix.getReimbursementId());
      assertEquals(3, x);
    }

    public static void testGetAll() {
      reimbursementDAO.add(reimbursementFour);
      reimbursementDAO.add(reimbursementFive);
      reimbursementDAO.add(reimbursementSix);
      ArrayList<Reimbursement> list = reimbursementDAO.getAll();
      reimbursementDAO.remove(reimbursementFour.getReimbursementId());
      reimbursementDAO.remove(reimbursementFive.getReimbursementId());
      reimbursementDAO.remove(reimbursementSix.getReimbursementId());
      assertEquals(6, list.size());
    }
}
