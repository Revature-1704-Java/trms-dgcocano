package com.revature.dao;
import com.revature.beans.ResponseType;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResponseTypeDAO extends GenericDAOImpl<ResponseType> {

  public ResponseTypeDAO() {
    super();
  }
  public ResponseTypeDAO(String filename) {
    super(filename);
  }

  public int add(ResponseType responseType) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "INSERT INTO RESPONSE_TYPE VALUES(?, ?)";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, responseType.getResponseTypeId());
      ps.setString(2, responseType.getTitle());

      recordsAffected = ps.executeUpdate();
      ps.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      recordsAffected=0;
    }
    return recordsAffected;
  }

  public int update(int id, ResponseType responseType) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "UPDATE RESPONSE_TYPE SET RESPONSE_TYPE_ID = ?, TITLE = ? WHERE RESPONSE_TYPE_ID = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, responseType.getResponseTypeId());
      ps.setString(2, responseType.getTitle());
      ps.setInt(3, responseType.getResponseTypeId());

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
    String sql = "DELETE FROM RESPONSE_TYPE WHERE RESPONSE_TYPE_ID = ?";
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

  public ResponseType getById(int id) {
    PreparedStatement ps = null;
    ResponseType responseType = null;

    try{
      String sql = "SELECT * FROM RESPONSE_TYPE WHERE RESPONSE_TYPE_ID = ?";
      ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int responseTypeId = rs.getInt("RESPONSE_TYPE_Id");
        String title = rs.getString("Title");
        responseType = new ResponseType(responseTypeId, title);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return responseType;
  }

  public ArrayList<ResponseType> getAll() {
    PreparedStatement ps = null;
    ResponseType responseType= null;
    ArrayList<ResponseType> responseTypes = new ArrayList<>();

    try{
      String sql = "SELECT * FROM RESPONSE_TYPE";
      ps = conn.prepareStatement(sql);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int responseTypeId = rs.getInt("RESPONSE_TYPE_Id");
        String title = rs.getString("Title");
        responseType= new ResponseType(responseTypeId, title);
        responseTypes.add(responseType);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return responseTypes;
  }
}
