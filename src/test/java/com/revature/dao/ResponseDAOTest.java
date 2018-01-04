package com.revature.app;

import com.revature.dao.ResponseDAO;
import com.revature.beans.Response;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.sql.Timestamp;
import org.junit.BeforeClass;
import org.junit.AfterClass;
/**
 * Unit test for simple ResponseDAO.
 */
public class ResponseDAOTest 
    extends TestCase
{
    static Timestamp timestamp = Timestamp.valueOf("2001-03-23 10:10:10.0");
    static ResponseDAO responseDAO = new ResponseDAO("./test.properties");
    static Response responseOne = new Response(1, 1, 1,1, timestamp); 
    static Response responseTwo = new Response(2, 2, 2, 2, timestamp); 
    static Response responseThree = new Response(3, 3, 3,  3, timestamp); 
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public ResponseDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @rresponseurn the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ResponseDAOTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    @BeforeClass public static void setup() {
      responseDAO = new ResponseDAO("./test.properties");
    }
    @AfterClass public static void close() {
      responseDAO.close();
    }
    public static void testInsertOne() {
      int x = responseDAO.add(responseOne);
      responseDAO.remove(responseOne.getResponseId());
      assertEquals(1, x);
    }

    public static void testInsertTwo() {
      int x = responseDAO.add(responseTwo);
      responseDAO.remove(responseTwo.getResponseId());
      assertEquals(1, x);
    }

    public static void testDeleteOne() {
      responseDAO.add(responseOne);
      int x = responseDAO.remove(responseOne.getResponseId());
      assertEquals(1, x);
    }

    public static void testDeleteTwo() {
      responseDAO.add(responseTwo);
      int x = responseDAO.remove(responseTwo.getResponseId());
      assertEquals(1, x);
    }

    public static void testMultipleInsert() {
      int x = responseDAO.add(responseOne);
      x += responseDAO.add(responseTwo);
      x += responseDAO.add(responseThree);
      responseDAO.remove(responseOne.getResponseId());
      responseDAO.remove(responseTwo.getResponseId());
      responseDAO.remove(responseThree.getResponseId());
      assertEquals(3, x);
    }

    public static void testResponseMultiple() {
      responseDAO.add(responseOne);
      responseDAO.add(responseTwo);
      responseDAO.add(responseThree);
      int x = responseDAO.remove(responseOne.getResponseId());
      x += responseDAO.remove(responseTwo.getResponseId());
      x += responseDAO.remove(responseThree.getResponseId());
      assertEquals(3, x);
    }

    public static void testGetAll() {
      responseDAO.add(responseOne);
      responseDAO.add(responseTwo);
      responseDAO.add(responseThree);
      ArrayList<Response> list = responseDAO.getAll();
      responseDAO.remove(responseOne.getResponseId());
      responseDAO.remove(responseTwo.getResponseId());
      responseDAO.remove(responseThree.getResponseId());
      assertEquals(3, list.size());
    }
}
