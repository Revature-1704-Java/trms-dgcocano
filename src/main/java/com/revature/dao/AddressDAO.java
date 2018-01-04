package com.revature.dao;
import com.revature.beans.Address;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO extends GenericDAOImpl<Address> {

  public AddressDAO() {
    super();
  }
  public AddressDAO(String filename) {
    super(filename);
  }

  public int add(Address address) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "INSERT INTO ADDRESS VALUES(?, ?, ?, ?, ?, ?)";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, address.getAddressId());
      ps.setString(2, address.getLine());
      ps.setString(3, address.getCity());
      ps.setString(4, address.getState());
      ps.setString(5, address.getCountry());
      ps.setString(6, address.getPostalCode());
      recordsAffected = ps.executeUpdate();
      ps.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      recordsAffected=0;
    }
    return recordsAffected;
  }

  public int update(int id, Address address) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "UPDATE ADDRESS SET ADDRESS_ID = ?, LINE = ?, CITY = ?, STATE = ?, COUNTRY = ?, POSTALCODE = ? WHERE ADDRESS_ID = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, address.getAddressId());
      ps.setString(2, address.getLine());
      ps.setString(3, address.getCity());
      ps.setString(4, address.getState());
      ps.setString(5, address.getCountry());
      ps.setString(6, address.getPostalCode());
      ps.setInt(7, address.getAddressId());
      recordsAffected = ps.executeUpdate();
      ps.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      recordsAffected=0;
    }
    return recordsAffected;
  }

  public int remove(int id) {
		PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
    String sql = "DELETE FROM ADDRESS WHERE ADDRESS_ID = ?";
    ps = conn.prepareStatement(sql);
		ps.setInt(1, id);

    recordsAffected = ps.executeUpdate();
    ps.close();
    }
    catch(Exception ex) {
      ex.printStackTrace();
      recordsAffected = 0;
    }
    return recordsAffected;
  }

  public Address getById(int id) {
    PreparedStatement ps = null;
    Address address = null;

    try{
      String sql = "SELECT * FROM ADDRESS WHERE ADDRESS_ID = ?";
      ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int addressId = rs.getInt("ADDRESS_Id");
        String line = rs.getString("LINE");
        String city = rs.getString("CITY");
        String state = rs.getString("STATE");
        String country = rs.getString("COUNTRY");
        String postalCode = rs.getString("POSTALCODE");
	      address = new Address(addressId, line, city, state, country, postalCode);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return address;
  }

  public ArrayList<Address> getAll() {
    PreparedStatement ps = null;
    Address address= null;
    ArrayList<Address> addresses = new ArrayList<>();

    try{
      String sql = "SELECT * FROM ADDRESS";
      ps = conn.prepareStatement(sql);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int addressId = rs.getInt("ADDRESS_ID");
        String line = rs.getString("LINE");
        String city = rs.getString("CITY");
        String state = rs.getString("STATE");
        String country = rs.getString("COUNTRY");
        String postalCode = rs.getString("POSTALCODE");
	      address = new Address(addressId, line, city, state, country, postalCode);
        addresses.add(address);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return addresses;
  }
}
