package com.revature.beans;

public class EmployeeType implements Comparable<EmployeeType> {

	private int employeeTypeId;
	private String title;

	public EmployeeType() {
		super();
	}
	public EmployeeType(int employeeTypeId, String title){
		super();
		this.employeeTypeId = employeeTypeId;
		this.title = title;
	}

  public int compareTo(EmployeeType that) {
    final int BEFORE = -1;
    final int EQUAL = -0;
    final int AFTER = 1;
    
    if(this == that) return EQUAL;
    if(this.getEmployeeTypeId() < that.getEmployeeTypeId()) return BEFORE;
    if(this.getEmployeeTypeId() > that.getEmployeeTypeId()) return AFTER;
    
    return EQUAL;
  }
	@Override
	public String toString() {
		return "EmployeeType [id=" + employeeTypeId + ", title=" + title + "]"; 
	}

	public void setEmployeeTypeId(int employeeTypeId) {
					this.employeeTypeId = employeeTypeId;
	}
	public int getEmployeeTypeId() {
					return employeeTypeId;
	}
  public void setTitle(String title) {
    this.title = title;
  }
  public String getTitle() {
    return title;
  }
}
