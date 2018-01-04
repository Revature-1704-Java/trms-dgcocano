package com.revature.app;

import com.revature.dao.EventDAO;
import com.revature.beans.Event;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.sql.Timestamp;
import org.junit.BeforeClass;
import org.junit.AfterClass;
/**
 * Unit test for simple EventDAO.
 */
public class EventDAOTest 
    extends TestCase
{
    static Timestamp timestamp = Timestamp.valueOf("2007-09-23 10:10:10.0");
    static EventDAO eventDAO = new EventDAO("./test.properties");
    static Event eventSeven = new Event(7, 7, 7,"title", timestamp); 
    static Event eventEight = new Event(8, 8, 8, "title", timestamp); 
    static Event eventNine = new Event(9, 9, 9,  "title", timestamp); 
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public EventDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @reventurn the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( EventDAOTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    @BeforeClass public static void setup() {
      eventDAO = new EventDAO("./test.properties");
    }
    @AfterClass public static void close() {
      eventDAO.close();
    }
    public static void testInsertSeven() {
      int x = eventDAO.add(eventSeven);
      eventDAO.remove(eventSeven.getEventId());
      assertEquals(1, x);
    }

    public static void testInsertEight() {
      int x = eventDAO.add(eventEight);
      eventDAO.remove(eventEight.getEventId());
      assertEquals(1, x);
    }

    public static void testDeleteSeven() {
      eventDAO.add(eventSeven);
      int x = eventDAO.remove(eventSeven.getEventId());
      assertEquals(1, x);
    }

    public static void testDeleteEight() {
      eventDAO.add(eventEight);
      int x = eventDAO.remove(eventEight.getEventId());
      assertEquals(1, x);
    }

    public static void testMultipleInsert() {
      int x = eventDAO.add(eventSeven);
      x += eventDAO.add(eventEight);
      x += eventDAO.add(eventNine);
      eventDAO.remove(eventSeven.getEventId());
      eventDAO.remove(eventEight.getEventId());
      eventDAO.remove(eventNine.getEventId());
      assertEquals(3, x);
    }

    public static void testEventMultiple() {
      eventDAO.add(eventSeven);
      eventDAO.add(eventEight);
      eventDAO.add(eventNine);
      int x = eventDAO.remove(eventSeven.getEventId());
      x += eventDAO.remove(eventEight.getEventId());
      x += eventDAO.remove(eventNine.getEventId());
      assertEquals(3, x);
    }

    public static void testGetAll() {
      eventDAO.add(eventSeven);
      eventDAO.add(eventEight);
      eventDAO.add(eventNine);
      ArrayList<Event> list = eventDAO.getAll();
      eventDAO.remove(eventSeven.getEventId());
      eventDAO.remove(eventEight.getEventId());
      eventDAO.remove(eventNine.getEventId());
      assertEquals(9, list.size());
    }
}
