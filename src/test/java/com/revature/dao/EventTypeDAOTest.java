package com.revature.app;

import com.revature.dao.EventTypeDAO;
import com.revature.beans.EventType;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.AfterClass;
/**
 * Unit test for simple EventTypeDAO.
 */
public class EventTypeDAOTest 
    extends TestCase
{
    static EventTypeDAO eventTypeDAO = new EventTypeDAO("./test.properties");
    static EventType eventTypeFour = new EventType(10, "title", .80); 
    static EventType eventTypeFive = new EventType(11, "title", .700); 
    static EventType eventTypeSix = new EventType(12, "title", .700); 
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public EventTypeDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @reventTypeurn the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( EventTypeDAOTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    @BeforeClass public static void setup() {
      eventTypeDAO = new EventTypeDAO("./test.properties");
    }
    @AfterClass public static void close() {
      eventTypeDAO.close();
    }
    public static void testInsertFour() {
      int x = eventTypeDAO.add(eventTypeFour);
      eventTypeDAO.remove(eventTypeFour.getEventTypeId());
      assertEquals(1, x);
    }

    public static void testInsertFive() {
      int x = eventTypeDAO.add(eventTypeFive);
      eventTypeDAO.remove(eventTypeFive.getEventTypeId());
      assertEquals(1, x);
    }

    public static void testDeleteFour() {
      eventTypeDAO.add(eventTypeFour);
      int x = eventTypeDAO.remove(eventTypeFour.getEventTypeId());
      assertEquals(1, x);
    }

    public static void testDeleteFive() {
      eventTypeDAO.add(eventTypeFive);
      int x = eventTypeDAO.remove(eventTypeFive.getEventTypeId());
      assertEquals(1, x);
    }

    public static void testMultipleInsert() {
      int x = eventTypeDAO.add(eventTypeFour);
      x += eventTypeDAO.add(eventTypeFive);
      x += eventTypeDAO.add(eventTypeSix);
      eventTypeDAO.remove(eventTypeFour.getEventTypeId());
      eventTypeDAO.remove(eventTypeFive.getEventTypeId());
      eventTypeDAO.remove(eventTypeSix.getEventTypeId());
      assertEquals(3, x);
    }

    public static void testEventTypeMultiple() {
      eventTypeDAO.add(eventTypeFour);
      eventTypeDAO.add(eventTypeFive);
      eventTypeDAO.add(eventTypeSix);
      int x = eventTypeDAO.remove(eventTypeFour.getEventTypeId());
      x += eventTypeDAO.remove(eventTypeFive.getEventTypeId());
      x += eventTypeDAO.remove(eventTypeSix.getEventTypeId());
      assertEquals(3, x);
    }

    public static void testGetAll() {
      eventTypeDAO.add(eventTypeFour);
      eventTypeDAO.add(eventTypeFive);
      eventTypeDAO.add(eventTypeSix);
      ArrayList<EventType> list = eventTypeDAO.getAll();
      eventTypeDAO.remove(eventTypeFour.getEventTypeId());
      eventTypeDAO.remove(eventTypeFive.getEventTypeId());
      eventTypeDAO.remove(eventTypeSix.getEventTypeId());
      assertEquals(12, list.size());
    }
}
