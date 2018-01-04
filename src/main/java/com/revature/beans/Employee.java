package com.revature.beans;

public class Employee implements Comparable<Employee> {

	private int employeeId;
  private int departmentId;
  private int employeeTypeId;
  private int supervisor;
	private String email;
	private String credential;
  private String firstname;
  private String lastname;

	public Employee() {
		super();
	}
	public Employee(int employeeId, int departmentId, int employeeTypeId, int supervisor, String email, String credential, String firstname, String lastname){
		super();
		this.employeeId = employeeId;
    this.departmentId = departmentId;
    this.employeeTypeId = employeeTypeId;
    this.supervisor = supervisor;
		this.email = email;
		this.credential = credential;
    this.firstname = firstname;
    this.lastname = lastname;
	}

  public int compareTo(Employee that) {
    final int BEFORE = -1;
    final int EQUAL = -0;
    final int AFTER = 1;
    
    if(this == that) return EQUAL;
    if(this.getEmployeeId() < that.getEmployeeId()) return BEFORE;
    if(this.getEmployeeId() > that.getEmployeeId()) return AFTER;
    
    return EQUAL;
  }
	@Override
	public String toString() {
		return "Employee [id=" + employeeId + ", email=" + email + ", credential=" + credential + ", supervisor" + supervisor + ", department ID=" + departmentId + ", employeeTypeId" + employeeTypeId + "]"; 
	}

	public String getCredential() {
					return credential;
	}
	public void setCredential(String credential) {
					this.credential = credential;
	}
	public void setEmployeeId(int employeeId) {
					this.employeeId = employeeId;
	}
	public int getEmployeeId() {
					return employeeId;
	}
	public String getEmail() {
					return email;
	}
	public void setEmail(String email) {
					this.email = email;
	}
  public void setSupervisor(int supervisor) {
    this.supervisor = supervisor;
  }
  public int getSupervisor() {
    return supervisor;
  }
  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }
  public int getDepartmentId() {
    return departmentId;
  }
  public void setEmployeeTypeId(int employeeTypeId) {
    this.employeeTypeId = employeeTypeId;
  }
  public int getEmployeeTypeId() {
    return employeeTypeId;
  }
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }
  public String getFirstname() {
    return firstname;
  }
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
  public String getLastname() {
    return lastname;
  }
}
