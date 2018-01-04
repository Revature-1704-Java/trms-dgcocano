package com.revature.beans;

import java.sql.Timestamp;

public class Response implements Comparable<Response> {

	private int responseId;
  private int reimbursementId;
  private int employeeId;
  private int responseTypeId;
  private Timestamp responseTimestamp;

	public Response() {
		super();
	}
	public Response(int responseId, int reimbursementId, int employeeId, int responseTypeId, Timestamp responseTimestamp){
		super();
		this.responseId = responseId;
    this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.responseTypeId = responseTypeId;
    this.responseTimestamp = responseTimestamp;
	}

  public int compareTo(Response that) {
    final int BEFORE = -1;
    final int EQUAL = -0;
    final int AFTER = 1;
    
    if(this == that) return EQUAL;
    if(this.getResponseId() < that.getResponseId()) return BEFORE;
    if(this.getResponseId() > that.getResponseId()) return AFTER;
    
    return EQUAL;
  }
	@Override
	public String toString() {
		return "Response [id=" + responseId + ", reimbursementId=" + reimbursementId + ", employeeId=" + employeeId + ", responseTypeId=" + responseTypeId + ", responseTimeStamp=" + responseTimestamp + "]"; 
	}

  public void setResponseId(int responseId) {
    this.responseId = responseId;
  }
  public int getResponseId() {
    return responseId;
  }
  public void setReimbursementId(int reimbursementId) {
    this.reimbursementId = reimbursementId;
  }
  public int getReimbursementId() {
    return reimbursementId;
  }
  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }
  public int getEmployeeId() {
    return employeeId;
  }
  public void setResponseTypeId(int responseTypeId) {
    this.responseTypeId = responseTypeId;
  }
  public int getResponseTypeId() {
    return responseTypeId;
  }
  public void setResponseTimestamp(Timestamp responseTimestamp) {
    this.responseTimestamp = responseTimestamp;
  }
  public Timestamp getResponseTimestamp() {
    return responseTimestamp;
  }
}
