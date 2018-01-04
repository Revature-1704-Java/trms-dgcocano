package com.revature.dao;
import com.revature.beans.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import java.nio.file.Path;
import java.nio.file.Paths;
public class EmployeeDAO extends GenericDAOImpl<Employee> {

  public EmployeeDAO() {
    super();
  }
  public EmployeeDAO(String filename) {
    super(filename);
  }

  public String test() {
    Path cur = Paths.get("");
    String s = cur.toAbsolutePath().toString();
    return s;
  }
  public int add(Employee employee) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "INSERT INTO EMPLOYEE VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, employee.getEmployeeId());
      ps.setInt(2, employee.getDepartmentId());
      ps.setInt(3, employee.getEmployeeTypeId());
      ps.setInt(4, employee.getSupervisor());
      ps.setString(5, employee.getEmail());
      ps.setString(6, employee.getCredential());
      ps.setString(7, employee.getFirstname());
      ps.setString(8, employee.getLastname());

      recordsAffected = ps.executeUpdate();
      ps.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      recordsAffected=0;
    }
    return recordsAffected;
  }

  public int update(int id, Employee employee) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "UPDATE EMPLOYEE SET EMPLOYEE_ID = ?, DEPARTMENT_ID = ?, EMPLOYEE_TYPE_ID = ?, SUPERVISOR = ?, EMAIL = ?, CREDENTIAL = ?, FIRSTNAME = ?, LASTNAME = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, employee.getEmployeeId());
      ps.setInt(2, employee.getDepartmentId());
      ps.setInt(3, employee.getEmployeeTypeId());
      ps.setInt(4, employee.getSupervisor());
      ps.setString(5, employee.getEmail());
      ps.setString(6, employee.getCredential());
      ps.setString(7, employee.getFirstname());
      ps.setString(8, employee.getLastname());
      ps.setInt(9, employee.getEmployeeId());

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
    String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
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

  public Employee getByLogin(String em, String cred) {
    PreparedStatement ps = null;
    Employee employee = null;

    try{
      String sql = "SELECT * FROM EMPLOYEE WHERE EMAIL = ? AND CREDENTIAL = ?";
      ps = conn.prepareStatement(sql);
			ps.setString(1, em);
      ps.setString(2, cred);

      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int employeeId = rs.getInt("EMPLOYEE_ID");
        int departmentId = rs.getInt("DEPARTMENT_ID");
        int employeeTypeId = rs.getInt("EMPLOYEE_TYPE_ID");
        int supervisor = rs.getInt("SUPERVISOR");
        String email = rs.getString("EMAIL");
        String credential = rs.getString("CREDENTIAL");
        String firstname = rs.getString("FIRSTNAME");
        String lastname = rs.getString("LASTNAME");
        employee = new Employee(employeeId, departmentId, employeeTypeId, supervisor, email, credential, firstname, lastname);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return employee;
  }
  public Employee getDepartmentHead(int selector) {
    PreparedStatement ps = null;
    Employee employee = null;

    try{
      String sql = "SELECT * FROM EMPLOYEE WHERE DEPARTMENT = ? AND EMPLOYEE_TYPE = 3";
      ps = conn.prepareStatement(sql);
			ps.setInt(1, selector);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int employeeId = rs.getInt("EMPLOYEE_ID");
        int departmentId = rs.getInt("DEPARTMENT_ID");
        int employeeTypeId = rs.getInt("EMPLOYEE_TYPE_ID");
        int supervisor = rs.getInt("SUPERVISOR");
        String email = rs.getString("EMAIL");
        String credential = rs.getString("CREDENTIAL");
        String firstname = rs.getString("FIRSTNAME");
        String lastname = rs.getString("LASTNAME");
        employee = new Employee(employeeId, departmentId, employeeTypeId, supervisor, email, credential, firstname, lastname);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return employee;
  }
  public Employee getById(int id) {
    PreparedStatement ps = null;
    Employee employee = null;

    try{
      String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
      ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int employeeId = rs.getInt("EMPLOYEE_ID");
        int departmentId = rs.getInt("DEPARTMENT_ID");
        int employeeTypeId = rs.getInt("EMPLOYEE_TYPE_ID");
        int supervisor = rs.getInt("SUPERVISOR");
        String email = rs.getString("EMAIL");
        String credential = rs.getString("CREDENTIAL");
        String firstname = rs.getString("FIRSTNAME");
        String lastname = rs.getString("LASTNAME");
        employee = new Employee(employeeId, departmentId, employeeTypeId, supervisor, email, credential, firstname, lastname);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return employee;
  }

  public ArrayList<Employee> getByDepartment(int dep) {
    PreparedStatement ps = null;
    Employee employee= null;
    ArrayList<Employee> employees = new ArrayList<>();

    try{
      String sql = "SELECT * FROM EMPLOYEE WHERE DEPARTMENT_ID = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, dep);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int employeeId = rs.getInt("EMPLOYEE_ID");
        int departmentId = rs.getInt("DEPARTMENT_ID");
        int employeeTypeId = rs.getInt("EMPLOYEE_TYPE_ID");
        int supervisor = rs.getInt("SUPERVISOR");
        String email = rs.getString("EMAIL");
        String credential = rs.getString("CREDENTIAL");
        String firstname = rs.getString("FIRSTNAME");
        String lastname = rs.getString("LASTNAME");
        employee = new Employee(employeeId, departmentId, employeeTypeId, supervisor, email, credential, firstname, lastname);
        employees.add(employee);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return employees;
  }
  public ArrayList<Employee> getAll() {
    PreparedStatement ps = null;
    Employee employee= null;
    ArrayList<Employee> employees = new ArrayList<>();

    try{
      String sql = "SELECT * FROM EMPLOYEE";
      ps = conn.prepareStatement(sql);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int employeeId = rs.getInt("EMPLOYEE_ID");
        int departmentId = rs.getInt("DEPARTMENT_ID");
        int employeeTypeId = rs.getInt("EMPLOYEE_TYPE_ID");
        int supervisor = rs.getInt("SUPERVISOR");
        String email = rs.getString("EMAIL");
        String credential = rs.getString("CREDENTIAL");
        String firstname = rs.getString("FIRSTNAME");
        String lastname = rs.getString("LASTNAME");
        employee = new Employee(employeeId, departmentId, employeeTypeId, supervisor, email, credential, firstname, lastname);
        employees.add(employee);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return employees;
  }
}
