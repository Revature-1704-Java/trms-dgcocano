package com.revature.dao;
import com.revature.beans.GradingFormat;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradingFormatDAO extends GenericDAOImpl<GradingFormat> {

  public GradingFormatDAO() {
    super();
  }
  public GradingFormatDAO(String filename) {
    super(filename);
  }

  public int add(GradingFormat gradingFormat) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "INSERT INTO GRADING_FORMAT VALUES(?, ?, ?)";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, gradingFormat.getGradingFormatId());
      ps.setString(2, gradingFormat.getTitle());
      ps.setDouble(3, gradingFormat.getPassing());

      recordsAffected = ps.executeUpdate();
      ps.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      recordsAffected=0;
    }
    return recordsAffected;
  }

  public int update(int id, GradingFormat gradingFormat) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "UPDATE GRADING_FORMAT SET GRADING_FORMAT_ID = ?, TITLE = ?, COVERAGE = ? WHERE GRADING_FORMAT_ID = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, gradingFormat.getGradingFormatId());
      ps.setString(2, gradingFormat.getTitle());
      ps.setDouble(3, gradingFormat.getPassing());
      ps.setInt(4, gradingFormat.getGradingFormatId());

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
    String sql = "DELETE FROM GRADING_FORMAT WHERE GRADING_FORMAT_ID = ?";
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

  public GradingFormat getById(int id) {
    PreparedStatement ps = null;
    GradingFormat gradingFormat = null;

    try{
      String sql = "SELECT * FROM GRADING_FORMAT WHERE GRADING_FORMAT_ID = ?";
      ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int gradingFormatId = rs.getInt("GRADING_FORMAT_Id");
        String title = rs.getString("Title");
        double passing = rs.getDouble("Passing");
        gradingFormat = new GradingFormat(gradingFormatId, title, passing);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return gradingFormat;
  }

  public ArrayList<GradingFormat> getAll() {
    PreparedStatement ps = null;
    GradingFormat gradingFormat = null;
    ArrayList<GradingFormat> gradingFormats = new ArrayList<>();

    try{
      String sql = "SELECT * FROM GRADING_FORMAT";
      ps = conn.prepareStatement(sql);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int gradingFormatId = rs.getInt("GRADING_FORMAT_Id");
        String title = rs.getString("Title");
        double passing = rs.getDouble("Passing");
        gradingFormat = new GradingFormat(gradingFormatId, title, passing);
        gradingFormats.add(gradingFormat);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return gradingFormats;
  }
}
