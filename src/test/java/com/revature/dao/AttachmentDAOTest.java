package com.revature.app;

import com.revature.dao.AttachmentDAO;
import com.revature.beans.Attachment;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.AfterClass;
/**
 * Unit test for simple AttachmentDAO.
 */
public class AttachmentDAOTest 
    extends TestCase
{
    static AttachmentDAO attachmentDAO = new AttachmentDAO("./test.properties");
    static Attachment attachmentOne = new Attachment(1, 1, 1, "File1"); 
    static Attachment attachmentTwo = new Attachment(2, 2, 2, "File2"); 
    static Attachment attachmentThree = new Attachment(3, 3, 3, "File3"); 
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public AttachmentDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @rattachmenturn the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AttachmentDAOTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    @BeforeClass public static void setup() {
      attachmentDAO = new AttachmentDAO("./test.properties");
    }
    @AfterClass public static void close() {
      attachmentDAO.close();
    }
    public static void testInsertOne() {
      int x = attachmentDAO.add(attachmentOne);
      attachmentDAO.remove(attachmentOne.getAttachmentId());
      assertEquals(1, x);
    }

    public static void testInsertTwo() {
      int x = attachmentDAO.add(attachmentTwo);
      attachmentDAO.remove(attachmentTwo.getAttachmentId());
      assertEquals(1, x);
    }

    public static void testDeleteOne() {
      attachmentDAO.add(attachmentOne);
      int x = attachmentDAO.remove(attachmentOne.getAttachmentId());
      assertEquals(1, x);
    }

    public static void testDeleteTwo() {
      attachmentDAO.add(attachmentTwo);
      int x = attachmentDAO.remove(attachmentTwo.getAttachmentId());
      assertEquals(1, x);
    }

    public static void testMultipleInsert() {
      int x = attachmentDAO.add(attachmentOne);
      x += attachmentDAO.add(attachmentTwo);
      x += attachmentDAO.add(attachmentThree);
      attachmentDAO.remove(attachmentOne.getAttachmentId());
      attachmentDAO.remove(attachmentTwo.getAttachmentId());
      attachmentDAO.remove(attachmentThree.getAttachmentId());
      assertEquals(3, x);
    }

    public static void testAttachmentMultiple() {
      attachmentDAO.add(attachmentOne);
      attachmentDAO.add(attachmentTwo);
      attachmentDAO.add(attachmentThree);
      int x = attachmentDAO.remove(attachmentOne.getAttachmentId());
      x += attachmentDAO.remove(attachmentTwo.getAttachmentId());
      x += attachmentDAO.remove(attachmentThree.getAttachmentId());
      assertEquals(3, x);
    }

    public static void testGetAll() {
      attachmentDAO.add(attachmentOne);
      attachmentDAO.add(attachmentTwo);
      attachmentDAO.add(attachmentThree);
      ArrayList<Attachment> list = attachmentDAO.getAll();
      attachmentDAO.remove(attachmentOne.getAttachmentId());
      attachmentDAO.remove(attachmentTwo.getAttachmentId());
      attachmentDAO.remove(attachmentThree.getAttachmentId());
      assertEquals(3, list.size());
    }
}
