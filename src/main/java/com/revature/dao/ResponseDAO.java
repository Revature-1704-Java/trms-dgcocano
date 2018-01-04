package com.revature.dao;
import com.revature.beans.Response;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ResponseDAO extends GenericDAOImpl<Response> {

  public ResponseDAO() {
    super();
  }
  public ResponseDAO(String filename) {
    super(filename);
  }

  public int add(Response response) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "INSERT INTO RESPONSE VALUES(?, ?, ?, ?, ?)";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, response.getResponseId());
      ps.setInt(2, response.getReimbursementId());
      ps.setInt(3, response.getEmployeeId());
      ps.setInt(4, response.getResponseTypeId());
      ps.setTimestamp(5, response.getResponseTimestamp());

      recordsAffected = ps.executeUpdate();
      ps.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      recordsAffected=0;
    }
    return recordsAffected;
  }

  public int update(int id, Response response) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "UPDATE RESPONSE SET RESPONSE_ID = ?, REIMBURSEMENT_ID = ?, EMPLOYEE_ID = ?, RESPONSE_ID = ?, RESPONSE_TIMESTAMP = ? WHERE RESPONSE__ID = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, response.getResponseId());
      ps.setInt(2, response.getReimbursementId());
      ps.setInt(3, response.getEmployeeId());
      ps.setInt(4, response.getResponseTypeId());
      ps.setTimestamp(5, response.getResponseTimestamp());
      ps.setInt(6, response.getResponseId());

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
    String sql = "DELETE FROM RESPONSE WHERE RESPONSE_ID = ?";
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

  public ArrayList<Response> getByReimbursementId(int id) {
    PreparedStatement ps = null;
    Response response = null;
    ArrayList<Response> responses = new ArrayList<Response>();

    try{
      String sql = "SELECT * FROM RESPONSE WHERE REIMBURSEMENT_ID = ?";
      ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int responseId = rs.getInt("RESPONSE_Id");
        int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
        int employeeId = rs.getInt("EMPLOYEE_ID");
        int responseTypeId = rs.getInt("RESPONSE_ID");
        Timestamp responseTimestamp = rs.getTimestamp("RESPONSE_TIMESTAMP");

        response = new Response(responseId, reimbursementId, employeeId, responseTypeId, responseTimestamp);
        responses.add(response);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return responses;
  }
  public Response getById(int id) {
    PreparedStatement ps = null;
    Response response = null;

    try{
      String sql = "SELECT * FROM RESPONSE WHERE RESPONSE_ID = ?";
      ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int responseId = rs.getInt("RESPONSE_Id");
        int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
        int employeeId = rs.getInt("EMPLOYEE_ID");
        int responseTypeId = rs.getInt("RESPONSE_ID");
        Timestamp responseTimestamp = rs.getTimestamp("RESPONSE_TIMESTAMP");

        response = new Response(responseId, reimbursementId, employeeId, responseTypeId, responseTimestamp);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return response;
  }

  public ArrayList<Response> getAll() {
    PreparedStatement ps = null;
    Response response= null;
    ArrayList<Response> responses = new ArrayList<>();

    try{
      String sql = "SELECT * FROM RESPONSE";
      ps = conn.prepareStatement(sql);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int responseId = rs.getInt("RESPONSE_Id");
        int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
        int responseTypeId = rs.getInt("RESPONSE_ID");
        int employeeId = rs.getInt("EMPLOYEE_ID");
        Timestamp responseTimestamp = rs.getTimestamp("RESPONSE_TIMESTAMP");

        response = new Response(responseId, reimbursementId, employeeId, responseTypeId, responseTimestamp);
        responses.add(response);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return responses;
  }
}
