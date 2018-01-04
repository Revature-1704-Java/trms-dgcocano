package com.revature.beans;

public class EventType implements Comparable<EventType> {

	private int eventTypeId;
	private String title;
  private double coverage;

	public EventType() {
		super();
	}
	public EventType(int eventTypeId, String title, double coverage){
		super();
		this.eventTypeId = eventTypeId;
		this.title = title;
    this.coverage = coverage;
	}

  public int compareTo(EventType that) {
    final int BEFORE = -1;
    final int EQUAL = -0;
    final int AFTER = 1;
    
    if(this == that) return EQUAL;
    if(this.getEventTypeId() < that.getEventTypeId()) return BEFORE;
    if(this.getEventTypeId() > that.getEventTypeId()) return AFTER;
    
    return EQUAL;
  }
	@Override
	public String toString() {
		return "EventType [id=" + eventTypeId + ", title=" + title + ", coverage=" + coverage + "]"; 
	}

	public void setEventTypeId(int eventTypeId) {
					this.eventTypeId = eventTypeId;
	}
	public int getEventTypeId() {
					return eventTypeId;
	}
  public void setTitle(String title) {
    this.title = title;
  }
  public String getTitle() {
    return title;
  }
  public void setCoverage(double coverage) {
    this.coverage = coverage;
  }
  public double getCoverage() {
    return coverage;
  }
}
