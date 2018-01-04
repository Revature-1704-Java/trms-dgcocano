package com.revature.beans;

public class ResponseType implements Comparable<ResponseType> {

	private int responseTypeId;
	private String title;

	public ResponseType() {
		super();
	}
	public ResponseType(int responseTypeId, String title){
		super();
		this.responseTypeId = responseTypeId;
		this.title = title;
	}

  public int compareTo(ResponseType that) {
    final int BEFORE = -1;
    final int EQUAL = -0;
    final int AFTER = 1;
    
    if(this == that) return EQUAL;
    if(this.getResponseTypeId() < that.getResponseTypeId()) return BEFORE;
    if(this.getResponseTypeId() > that.getResponseTypeId()) return AFTER;
    
    return EQUAL;
  }
	@Override
	public String toString() {
		return "ResponseType [id=" + responseTypeId + ", title=" + title + "]"; 
	}

	public void setResponseTypeId(int responseTypeId) {
					this.responseTypeId = responseTypeId;
	}
	public int getResponseTypeId() {
					return responseTypeId;
	}
  public void setTitle(String title) {
    this.title = title;
  }
  public String getTitle() {
    return title;
  }
}
