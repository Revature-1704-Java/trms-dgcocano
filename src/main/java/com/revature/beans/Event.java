package com.revature.beans;

import java.sql.Timestamp;

public class Event {

	private int eventId;
  private int eventTypeId;
  private int addressId;
  private String description;
  private Timestamp eventTimestamp;
  
	public Event() {
		super();
	}
	public Event(int eventId, int eventTypeId, int addressId, String description, Timestamp eventTimestamp){
		super();
		this.eventId = eventId;
    this.eventTypeId = eventTypeId;
    this.addressId = addressId;
		this.description = description;
		this.eventTimestamp = eventTimestamp;
	}

  public int compareTo(Event that) {
    final int BEFORE = -1;
    final int EQUAL = -0;
    final int AFTER = 1;
    
    if(this == that) return EQUAL;
    if(this.getEventId() < that.getEventId()) return BEFORE;
    if(this.getEventId() > that.getEventId()) return AFTER;
    
    return EQUAL;
  }
	@Override
	public String toString() {
		return "Event [id=" + eventId + ", eventTypeId=" + eventTypeId + "addressId=" + addressId + ", description=" + description + ", eventTimestamp=" + eventTimestamp + "]"; 
	}

  public void setEventId(int eventId) {
    this.eventId = eventId;
  }
  public int getEventId() {
    return eventId;
  }
  public void setEventTypeId(int eventTypeId) {
    this.eventTypeId = eventTypeId;
  }
  public int getEventTypeId() {
    return eventTypeId;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getDescription() {
    return description;
  }
  public void setAddressId(int addressId) {
    this.addressId = addressId;
  }
  public int getAddressId() {
    return addressId;
  }
  public void setEventTimestamp(Timestamp eventTimestamp) {
    this.eventTimestamp = eventTimestamp;
  }
  public Timestamp getEventTimestamp() {
    return eventTimestamp;
  }
}
