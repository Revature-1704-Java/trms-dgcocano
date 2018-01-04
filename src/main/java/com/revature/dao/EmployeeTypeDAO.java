package com.revature.dao;
import com.revature.beans.EmployeeType;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTypeDAO extends GenericDAOImpl<EmployeeType> {
  public EmployeeTypeDAO() {
    super();
  }
  public EmployeeTypeDAO(String filename) {
    super(filename);
  }

  public int add(EmployeeType employeeType) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "INSERT INTO EMPLOYEE_TYPE VALUES(?, ?)";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, employeeType.getEmployeeTypeId());
      ps.setString(2, employeeType.getTitle());

      recordsAffected = ps.executeUpdate();
      ps.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      recordsAffected=0;
    }
    return recordsAffected;
  }

  public int update(int id, EmployeeType employeeType) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "UPDATE EMPLOYEE_TYPE SET EMPLOYEE_TYPE_ID = ?, TITLE = ? WHERE EMPLOYEE_TYPE_ID = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, employeeType.getEmployeeTypeId());
      ps.setString(2, employeeType.getTitle());
      ps.setInt(3, employeeType.getEmployeeTypeId());

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
    String sql = "DELETE FROM EMPLOYEE_TYPE WHERE EMPLOYEE_TYPE_ID = ?";
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

  public EmployeeType getById(int id) {
    PreparedStatement ps = null;
    EmployeeType employeeType = null;

    try{
      String sql = "SELECT * FROM EMPLOYEE_TYPE WHERE EMPLOYEE_TYPE_ID = ?";
      ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int employeeTypeId = rs.getInt("Employee_Type_Id");
        String title = rs.getString("Title");
        employeeType = new EmployeeType(employeeTypeId, title);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return employeeType;
  }

  public ArrayList<EmployeeType> getAll() {
    PreparedStatement ps = null;
    EmployeeType employeeType= null;
    ArrayList<EmployeeType> employeeTypes = new ArrayList<>();

    try{
      String sql = "SELECT * FROM EMPLOYEE_TYPE";
      ps = conn.prepareStatement(sql);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int employeeTypeId = rs.getInt("Employee_Type_Id");
        String title = rs.getString("Title");
        employeeType= new EmployeeType(employeeTypeId, title);
        employeeTypes.add(employeeType);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return employeeTypes;
  }
}
