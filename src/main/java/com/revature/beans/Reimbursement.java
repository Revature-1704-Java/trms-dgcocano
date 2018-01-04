package com.revature.beans;

import java.util.Date;
import java.sql.Timestamp;

public class Reimbursement implements Comparable<Reimbursement> {

	private int reimbursementId;
  private int employeeId;
  private int eventId;
  private int gradingFormatId;
  private int assignedTo;
  private double cost;
  private Timestamp submissionTime;
  private int timeMissed;
  private String justification;
  private int urgent;
  private int exceeding;

	public Reimbursement() {
		super();
    submissionTime = new Timestamp(1);
    justification = new String();
	}
  public Reimbursement(int reimbursementId) {
    this.reimbursementId = reimbursementId;
  }
	public Reimbursement(int reimbursementId, int employeeId, int eventId, int gradingFormatId, int assignedTo,  double cost, Timestamp submissionTime, int timeMissed, String justification, int urgent, int exceeding){
    this();
		this.reimbursementId = reimbursementId;
    this.employeeId = employeeId;
		this.eventId = eventId;
    this.gradingFormatId = gradingFormatId;
    this.assignedTo = assignedTo;
    this.cost = cost;
    this.submissionTime = submissionTime;
    this.timeMissed = timeMissed;
    this.justification = justification;
    this.urgent = urgent;
    this.exceeding = exceeding;
	}

  public int compareTo(Reimbursement that) {
    final int BEFORE = -1;
    final int EQUAL = -0;
    final int AFTER = 1;
    
    if(this == that) return EQUAL;
    if(this.getReimbursementId() < that.getReimbursementId()) return BEFORE;
    if(this.getReimbursementId() > that.getReimbursementId()) return AFTER;
    
    return EQUAL;
  }
	@Override
	public String toString() {
		return "Reimbursement [id=" + reimbursementId + ", employeeId=" + employeeId + ", eventId=" + eventId + ", gradingFormatId=" + gradingFormatId + ", assignedTo=" + assignedTo + ", cost=" + cost + ", submissionTime=" + submissionTime + ", timeMissed=" + timeMissed + ", justification=" + justification + ", urgent=" + urgent + ", exceeding=" + exceeding + "]"; 
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
  public void setEventId(int eventId) {
    this.eventId = eventId;
  }
  public int getEventId() {
    return eventId;
  }
  public void setCost(double cost) {
    this.cost = cost;
  }
  public double getCost() {
    return cost;
  }
  public void setSubmissionTime(Timestamp submissionTime) {
    this.submissionTime = submissionTime;
  }
  public Timestamp getSubmissionTime() {
    return submissionTime;
  }
  public void setTimeMissed(int timeMissed) {
    this.timeMissed = timeMissed;
  }
  public int getTimeMissed() {
    return timeMissed;
  }
  public void setJustification(String justification) {
    this.justification = justification;
  }
  public String getJustification() {
    return justification;
  }
  public void setUrgent(int urgent) {
    this.urgent = urgent;
  }
  public int getUrgent() {
    return urgent;
  }
  public void setExceeding(int exceeding) {
    this.exceeding = exceeding;
  }
  public int getExceeding() {
    return exceeding;
  }
  public void setGradingFormatId(int gradingFormatId) {
    this.gradingFormatId = gradingFormatId;
  }
  public int getGradingFormatId() {
    return gradingFormatId;
  }
  public void setAssignedTo(int assignedTo) {
    this.assignedTo = assignedTo;
  }
  public int getAssignedTo() {
    return assignedTo;
  }
}
