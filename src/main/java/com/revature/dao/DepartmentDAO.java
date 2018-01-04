package com.revature.dao;
import com.revature.beans.Department;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO extends GenericDAOImpl<Department> {

  public DepartmentDAO() {
    super();
  }
  public DepartmentDAO(String filename) {
    super(filename);
  }

  public int add(Department department) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "INSERT INTO DEPARTMENT VALUES(?, ?)"; 
      ps = conn.prepareStatement(sql);
      ps.setInt(1, department.getDepartmentId());
      ps.setString(2, department.getTitle());

      recordsAffected = ps.executeUpdate();
      ps.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      recordsAffected=0;
    }
    return recordsAffected;
  }

  public int update(int id, Department department) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "UPDATE DEPARTMENT SET DEPARTMENT_ID = ?, TITLE = ? WHERE DEPARTMENT_ID = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, department.getDepartmentId());
      ps.setString(2, department.getTitle());
      ps.setInt(3, department.getDepartmentId());

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
    String sql = "DELETE FROM DEPARTMENT WHERE DEPARTMENT_ID = ?";
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

  public Department getById(int id) {
    PreparedStatement ps = null;
    Department department = null;

    try{
      String sql = "SELECT * FROM DEPARTMENT WHERE DEPARTMENT_ID = ?";
      ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int departmentId = rs.getInt("Department_Id");
        String title = rs.getString("Title");
        department = new Department(departmentId, title);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return department;
  }

  public ArrayList<Department> getAll() {
    PreparedStatement ps = null;
    Department department= null;
    ArrayList<Department> departments = new ArrayList<>();

    try{
      String sql = "SELECT * FROM DEPARTMENT";
      ps = conn.prepareStatement(sql);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int departmentId = rs.getInt("Department_Id");
        String title = rs.getString("Title");
        department= new Department(departmentId, title);
        departments.add(department);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return departments;
  }
}
