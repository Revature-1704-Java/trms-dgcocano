package com.revature.app;

import com.revature.dao.ResponseTypeDAO;
import com.revature.beans.ResponseType;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import java.util.ArrayList;
/**
 * Unit test for simple ResponseTypeDAO.
 */
public class ResponseTypeDAOTest 
    extends TestCase
{
    static ResponseTypeDAO responseTypeDAO = new ResponseTypeDAO("./test.properties");
    static ResponseType responseTypeFour = new ResponseType(4, "title"); 
    static ResponseType responseTypeFive = new ResponseType(5, "title"); 
    static ResponseType responseTypeSix = new ResponseType(6, "title"); 
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public ResponseTypeDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @rresponseTypeurn the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ResponseTypeDAOTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    @BeforeClass public static void setup() {
      responseTypeDAO = new ResponseTypeDAO("./test.properties");
    }
    @AfterClass public static void close() {
      responseTypeDAO.close();
    }
    public static void testInsertFour() {
      int x = responseTypeDAO.add(responseTypeFour);
      responseTypeDAO.remove(responseTypeFour.getResponseTypeId());
      assertEquals(1, x);
    }

    public static void testInsertFive() {
      int x = responseTypeDAO.add(responseTypeFive);
      responseTypeDAO.remove(responseTypeFive.getResponseTypeId());
      assertEquals(1, x);
    }

    public static void testDeleteFour() {
      responseTypeDAO.add(responseTypeFour);
      int x = responseTypeDAO.remove(responseTypeFour.getResponseTypeId());
      assertEquals(1, x);
    }

    public static void testDeleteFive() {
      responseTypeDAO.add(responseTypeFive);
      int x = responseTypeDAO.remove(responseTypeFive.getResponseTypeId());
      assertEquals(1, x);
    }

    public static void testMultipleInsert() {
      int x = responseTypeDAO.add(responseTypeFour);
      x += responseTypeDAO.add(responseTypeFive);
      x += responseTypeDAO.add(responseTypeSix);
      responseTypeDAO.remove(responseTypeFour.getResponseTypeId());
      responseTypeDAO.remove(responseTypeFive.getResponseTypeId());
      responseTypeDAO.remove(responseTypeSix.getResponseTypeId());
      assertEquals(3, x);
    }

    public static void testResponseTypeMultiple() {
      responseTypeDAO.add(responseTypeFour);
      responseTypeDAO.add(responseTypeFive);
      responseTypeDAO.add(responseTypeSix);
      int x = responseTypeDAO.remove(responseTypeFour.getResponseTypeId());
      x += responseTypeDAO.remove(responseTypeFive.getResponseTypeId());
      x += responseTypeDAO.remove(responseTypeSix.getResponseTypeId());
      assertEquals(3, x);
    }

    public static void testGetAll() {
      responseTypeDAO.add(responseTypeFour);
      responseTypeDAO.add(responseTypeFive);
      responseTypeDAO.add(responseTypeSix);
      ArrayList<ResponseType> list = responseTypeDAO.getAll();
      responseTypeDAO.remove(responseTypeFour.getResponseTypeId());
      responseTypeDAO.remove(responseTypeFive.getResponseTypeId());
      responseTypeDAO.remove(responseTypeSix.getResponseTypeId());
      assertEquals(6, list.size());
    }
}
