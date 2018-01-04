package com.revature.beans;

public class Department implements Comparable<Department> {

	private int departmentId;
	private String title;

	public Department() {
		super();
	}
	public Department(int departmentId, String title){
		super();
		this.departmentId = departmentId;
		this.title = title;
	}

  public int compareTo(Department that) {
    final int BEFORE = -1;
    final int EQUAL = -0;
    final int AFTER = 1;
    
    if(this == that) return EQUAL;
    if(this.getDepartmentId() < that.getDepartmentId()) return BEFORE;
    if(this.getDepartmentId() > that.getDepartmentId()) return AFTER;
    
    return EQUAL;
  }
	@Override
	public String toString() {
		return "Department [id=" + departmentId + ", title=" + title + "]"; 
	}

	public void setDepartmentId(int departmentId) {
					this.departmentId = departmentId;
	}
	public int getDepartmentId() {
					return departmentId;
	}
  public void setTitle(String title) {
    this.title = title;
  }
  public String getTitle() {
    return title;
  }
}
