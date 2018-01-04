package com.revature.app;

import com.revature.dao.GradingFormatDAO;
import com.revature.beans.GradingFormat;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.AfterClass;
/**
 * Unit test for simple GradingFormatDAO.
 */
public class GradingFormatDAOTest 
    extends TestCase
{
    static GradingFormatDAO gradingFormatDAO = new GradingFormatDAO("./test.properties");
    static GradingFormat gradingFormatFour = new GradingFormat(7, "title", .80); 
    static GradingFormat gradingFormatFive = new GradingFormat(8, "title", .700); 
    static GradingFormat gradingFormatSix = new GradingFormat(9, "title", .700); 
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public GradingFormatDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @rgradingFormaturn the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GradingFormatDAOTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    @BeforeClass public static void setup() {
      gradingFormatDAO = new GradingFormatDAO("./test.properties");
    }
    @AfterClass public static void close() {
      gradingFormatDAO.close();
    }
    public static void testInsertFour() {
      int x = gradingFormatDAO.add(gradingFormatFour);
      gradingFormatDAO.remove(gradingFormatFour.getGradingFormatId());
      assertEquals(1, x);
    }

    public static void testInsertFive() {
      int x = gradingFormatDAO.add(gradingFormatFive);
      gradingFormatDAO.remove(gradingFormatFive.getGradingFormatId());
      assertEquals(1, x);
    }

    public static void testDeleteFour() {
      gradingFormatDAO.add(gradingFormatFour);
      int x = gradingFormatDAO.remove(gradingFormatFour.getGradingFormatId());
      assertEquals(1, x);
    }

    public static void testDeleteFive() {
      gradingFormatDAO.add(gradingFormatFive);
      int x = gradingFormatDAO.remove(gradingFormatFive.getGradingFormatId());
      assertEquals(1, x);
    }

    public static void testMultipleInsert() {
      int x = gradingFormatDAO.add(gradingFormatFour);
      x += gradingFormatDAO.add(gradingFormatFive);
      x += gradingFormatDAO.add(gradingFormatSix);
      gradingFormatDAO.remove(gradingFormatFour.getGradingFormatId());
      gradingFormatDAO.remove(gradingFormatFive.getGradingFormatId());
      gradingFormatDAO.remove(gradingFormatSix.getGradingFormatId());
      assertEquals(3, x);
    }

    public static void testGradingFormatMultiple() {
      gradingFormatDAO.add(gradingFormatFour);
      gradingFormatDAO.add(gradingFormatFive);
      gradingFormatDAO.add(gradingFormatSix);
      int x = gradingFormatDAO.remove(gradingFormatFour.getGradingFormatId());
      x += gradingFormatDAO.remove(gradingFormatFive.getGradingFormatId());
      x += gradingFormatDAO.remove(gradingFormatSix.getGradingFormatId());
      assertEquals(3, x);
    }

    public static void testGetAll() {
      gradingFormatDAO.add(gradingFormatFour);
      gradingFormatDAO.add(gradingFormatFive);
      gradingFormatDAO.add(gradingFormatSix);
      ArrayList<GradingFormat> list = gradingFormatDAO.getAll();
      gradingFormatDAO.remove(gradingFormatFour.getGradingFormatId());
      gradingFormatDAO.remove(gradingFormatFive.getGradingFormatId());
      gradingFormatDAO.remove(gradingFormatSix.getGradingFormatId());
      assertEquals(9, list.size());
    }
}
