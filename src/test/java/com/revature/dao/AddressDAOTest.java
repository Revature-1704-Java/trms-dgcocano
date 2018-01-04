package com.revature.app;

import com.revature.dao.AddressDAO;
import com.revature.beans.Address;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import java.util.ArrayList;
/**
 * Unit test for simple AddressDAO.
 */
public class AddressDAOTest 
    extends TestCase
{
    static AddressDAO addressDAO = new AddressDAO("./test.properties");
    static Address addressTen = new Address(10, "line", "city", "state", "country", "postalCode"); 
    static Address addressEleven = new Address(11, "line", "city", "state", "country", "postalCode"); 
    static Address addressTwelve = new Address(12, "line", "city", "state", "country", "postalCode"); 
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public AddressDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @raddressurn the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AddressDAOTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    @BeforeClass public static void setup() {
      addressDAO = new AddressDAO("./test.properties");
    }
    @AfterClass public static void close() {
      addressDAO.close();
    }
    public static void testInsertTen() {
      int x = addressDAO.add(addressTen);
      addressDAO.remove(addressTen.getAddressId());
      assertEquals(1, x);
    }

    public static void testInsertEleven() {
      int x = addressDAO.add(addressEleven);
      addressDAO.remove(addressEleven.getAddressId());
      assertEquals(1, x);
    }

    public static void testDeleteTen() {
      addressDAO.add(addressTen);
      int x = addressDAO.remove(addressTen.getAddressId());
      assertEquals(1, x);
    }

    public static void testDeleteEleven() {
      addressDAO.add(addressEleven);
      int x = addressDAO.remove(addressEleven.getAddressId());
      assertEquals(1, x);
    }

    public static void testMultipleInsert() {
      int x = addressDAO.add(addressTen);
      x += addressDAO.add(addressEleven);
      x += addressDAO.add(addressTwelve);
      addressDAO.remove(addressTen.getAddressId());
      addressDAO.remove(addressEleven.getAddressId());
      addressDAO.remove(addressTwelve.getAddressId());
      assertEquals(3, x);
    }

    public static void testAddressMultiple() {
      addressDAO.add(addressTen);
      addressDAO.add(addressEleven);
      addressDAO.add(addressTwelve);
      int x = addressDAO.remove(addressTen.getAddressId());
      x += addressDAO.remove(addressEleven.getAddressId());
      x += addressDAO.remove(addressTwelve.getAddressId());
      assertEquals(3, x);
    }

    public static void testGetAll() {
      addressDAO.add(addressTen);
      addressDAO.add(addressEleven);
      addressDAO.add(addressTwelve);
      ArrayList<Address> list = addressDAO.getAll();
      addressDAO.remove(addressTen.getAddressId());
      addressDAO.remove(addressEleven.getAddressId());
      addressDAO.remove(addressTwelve.getAddressId());
      assertEquals(12, list.size());
    }
}
