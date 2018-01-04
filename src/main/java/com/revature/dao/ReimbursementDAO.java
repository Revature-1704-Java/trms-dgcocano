package com.revature.dao;
import com.revature.beans.Reimbursement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAO extends GenericDAOImpl<Reimbursement> {

  public ReimbursementDAO() {
    super();
  }
  public ReimbursementDAO(String filename) {
    super(filename);
  }

  public int add(Reimbursement reimbursement) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "INSERT INTO REIMBURSEMENT VALUES(?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, reimbursement.getReimbursementId());
      ps.setInt(2, reimbursement.getEmployeeId());
      ps.setInt(3, reimbursement.getEventId());
      ps.setInt(4, reimbursement.getGradingFormatId());
      ps.setInt(5, reimbursement.getAssignedTo());
      ps.setDouble(6, reimbursement.getCost());
      ps.setTimestamp(7, reimbursement.getSubmissionTime());
      ps.setInt(8, reimbursement.getTimeMissed());
      ps.setString(9, reimbursement.getJustification());
      ps.setInt(10, reimbursement.getUrgent());
      ps.setInt(11, reimbursement.getExceeding());

      recordsAffected = ps.executeUpdate();
      ps.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      recordsAffected=0;
    }
    return recordsAffected;
  }

  public int update(int id, Reimbursement reimbursement) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "UPDATE REIMBURSEMENT SET REIMBURSEMENT_ID = ?, EMPLOYEE_ID = ?, EVENT_ID = ?, GRADING_FORMAT_ID = ?, ASSIGNED_TO = ?, COST = ?, SUBMISSION_TIME = ?, TIME_MISSED = ?, JUSTIFICATION = ?, URGENT = ?, EXCEEDING = ? WHERE REIMBURSEMENT_ID = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, reimbursement.getReimbursementId());
      ps.setInt(2, reimbursement.getEmployeeId());
      ps.setInt(3, reimbursement.getEventId());
      ps.setInt(4, reimbursement.getGradingFormatId());
      ps.setInt(5, reimbursement.getAssignedTo());
      ps.setDouble(6, reimbursement.getCost());
      ps.setTimestamp(7, reimbursement.getSubmissionTime());
      ps.setInt(8, reimbursement.getTimeMissed());
      ps.setString(9, reimbursement.getJustification());
      ps.setInt(10, reimbursement.getUrgent());
      ps.setInt(11, reimbursement.getExceeding());
      ps.setInt(12, reimbursement.getReimbursementId());

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
    String sql = "DELETE FROM REIMBURSEMENT WHERE REIMBURSEMENT_ID = ?";
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

  public Reimbursement getById(int id) {
    PreparedStatement ps = null;
    Reimbursement reimbursement = null;

    try{
      String sql = "SELECT * FROM REIMBURSEMENT WHERE REIMBURSEMENT_ID = ?";
      ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
        int employeeId = rs.getInt("EMPLOYEE_ID");
        int eventId = rs.getInt("EVENT_ID");
        int gradingFormatId = rs.getInt("GRADING_FORMAT_ID");
        int assignedTo = rs.getInt("ASSIGNED_TO");
        double cost = rs.getDouble("COST");
        Timestamp submissionTime = rs.getTimestamp("SUBMISSION_TIME");
        int timeMissed = rs.getInt("TIME_MISSED");
        String justification = rs.getString("JUSTIFICATION");
        int urgent = rs.getInt("URGENT");
        int exceeding = rs.getInt("EXCEEDING");
	      reimbursement = new Reimbursement(reimbursementId, employeeId, eventId, gradingFormatId, assignedTo, cost, submissionTime, timeMissed, justification, urgent, exceeding);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return reimbursement;
  }

  public ArrayList<Reimbursement> getAll() {
    PreparedStatement ps = null;
    Reimbursement reimbursement= null;
    ArrayList<Reimbursement> reimbursements = new ArrayList<>();

    try{
      String sql = "SELECT * FROM REIMBURSEMENT ORDER BY SUBMISSION_TIME ASC";
      ps = conn.prepareStatement(sql);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
        int employeeId = rs.getInt("EMPLOYEE_ID");
        int eventId = rs.getInt("EVENT_ID");
        int gradingFormatId = rs.getInt("GRADING_FORMAT_ID");
        int assignedTo = rs.getInt("ASSIGNED_TO");
        double cost = rs.getDouble("COST");
        Timestamp submissionTime = rs.getTimestamp("SUBMISSION_TIME");
        int timeMissed = rs.getInt("TIME_MISSED");
        String justification = rs.getString("JUSTIFICATION");
        int urgent = rs.getInt("URGENT");
        int exceeding = rs.getInt("EXCEEDING");
	      reimbursement = new Reimbursement(reimbursementId, employeeId, eventId, gradingFormatId, assignedTo, cost, submissionTime, timeMissed, justification, urgent, exceeding);
        reimbursements.add(reimbursement);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return reimbursements;
  }

  public ArrayList<Reimbursement> getAssignedReimbursements(int selector) {
    PreparedStatement ps = null;
    Reimbursement reimbursement= null;
    ArrayList<Reimbursement> reimbursements = new ArrayList<>();

    try{
      String sql = "SELECT * FROM REIMBURSEMENT WHERE ASSIGNED_TO = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, selector);
      
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
        int employeeId = rs.getInt("EMPLOYEE_ID");
        int eventId = rs.getInt("EVENT_ID");
        int gradingFormatId = rs.getInt("GRADING_FORMAT_ID");
        int assignedTo = rs.getInt("ASSIGNED_TO");
        double cost = rs.getDouble("COST");
        Timestamp submissionTime = rs.getTimestamp("SUBMISSION_TIME");
        int timeMissed = rs.getInt("TIME_MISSED");
        String justification = rs.getString("JUSTIFICATION");
        int urgent = rs.getInt("URGENT");
        int exceeding = rs.getInt("EXCEEDING");
	      reimbursement = new Reimbursement(reimbursementId, employeeId, eventId, gradingFormatId, assignedTo, cost, submissionTime, timeMissed, justification, urgent, exceeding);
        reimbursements.add(reimbursement);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return reimbursements;
  }
  public ArrayList<Reimbursement> getByExceeding(int selector) {
    PreparedStatement ps = null;
    Reimbursement reimbursement= null;
    ArrayList<Reimbursement> reimbursements = new ArrayList<>();

    try{
      String sql = "SELECT * FROM REIMBURSEMENT WHERE EXCEEDING = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, selector);
      
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
        int employeeId = rs.getInt("EMPLOYEE_ID");
        int eventId = rs.getInt("EVENT_ID");
        int gradingFormatId = rs.getInt("GRADING_FORMAT_ID");
        int assignedTo = rs.getInt("ASSIGNED_TO");
        double cost = rs.getDouble("COST");
        Timestamp submissionTime = rs.getTimestamp("SUBMISSION_TIME");
        int timeMissed = rs.getInt("TIME_MISSED");
        String justification = rs.getString("JUSTIFICATION");
        int urgent = rs.getInt("URGENT");
        int exceeding = rs.getInt("EXCEEDING");
	      reimbursement = new Reimbursement(reimbursementId, employeeId, eventId, gradingFormatId, assignedTo, cost, submissionTime, timeMissed, justification, urgent, exceeding);
        reimbursements.add(reimbursement);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return reimbursements;
  }

  public ArrayList<Reimbursement> getByUrgent(int selector) {
    PreparedStatement ps = null;
    Reimbursement reimbursement= null;
    ArrayList<Reimbursement> reimbursements = new ArrayList<>();

    try{
      String sql = "SELECT * FROM REIMBURSEMENT WHERE URGENT = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, selector);
      
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
        int employeeId = rs.getInt("EMPLOYEE_ID");
        int eventId = rs.getInt("EVENT_ID");
        int gradingFormatId = rs.getInt("GRADING_FORMAT_ID");
        int assignedTo = rs.getInt("ASSIGNED_TO");
        double cost = rs.getDouble("COST");
        Timestamp submissionTime = rs.getTimestamp("SUBMISSION_TIME");
        int timeMissed = rs.getInt("TIME_MISSED");
        String justification = rs.getString("JUSTIFICATION");
        int urgent = rs.getInt("URGENT");
        int exceeding = rs.getInt("EXCEEDING");
	      reimbursement = new Reimbursement(reimbursementId, employeeId, eventId, gradingFormatId, assignedTo, cost, submissionTime, timeMissed, justification, urgent, exceeding);
        reimbursements.add(reimbursement);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return reimbursements;
  }
  public ArrayList<Reimbursement> getByEmployeeId(int empId) {
    PreparedStatement ps = null;
    Reimbursement reimbursement= null;
    ArrayList<Reimbursement> reimbursements = new ArrayList<>();

    try{
      String sql = "SELECT * FROM REIMBURSEMENT WHERE EMPLOYEE_ID = ? ORDER BY SUBMISSION_TIME ASC";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, empId);
      
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
        int employeeId = rs.getInt("EMPLOYEE_ID");
        int eventId = rs.getInt("EVENT_ID");
        int gradingFormatId = rs.getInt("GRADING_FORMAT_ID");
        int assignedTo = rs.getInt("ASSIGNED_TO");
        double cost = rs.getDouble("COST");
        Timestamp submissionTime = rs.getTimestamp("SUBMISSION_TIME");
        int timeMissed = rs.getInt("TIME_MISSED");
        String justification = rs.getString("JUSTIFICATION");
        int urgent = rs.getInt("URGENT");
        int exceeding = rs.getInt("EXCEEDING");
	      reimbursement = new Reimbursement(reimbursementId, employeeId, eventId, gradingFormatId, assignedTo, cost, submissionTime, timeMissed, justification, urgent, exceeding);
        reimbursements.add(reimbursement);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return reimbursements;
  }
}
