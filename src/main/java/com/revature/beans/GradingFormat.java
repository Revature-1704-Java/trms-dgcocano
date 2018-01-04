package com.revature.beans;

public class GradingFormat implements Comparable<GradingFormat> {

	private int gradingFormatId;
	private String title;
  private double passing;

	public GradingFormat() {
		super();
	}
	public GradingFormat(int gradingFormatId, String title, double passing){
		super();
		this.gradingFormatId = gradingFormatId;
		this.title = title;
    this.passing = passing;
	}

  public int compareTo(GradingFormat that) {
    final int BEFORE = -1;
    final int EQUAL = -0;
    final int AFTER = 1;
    
    if(this == that) return EQUAL;
    if(this.getGradingFormatId() < that.getGradingFormatId()) return BEFORE;
    if(this.getGradingFormatId() > that.getGradingFormatId()) return AFTER;
    
    return EQUAL;
  }
	@Override
	public String toString() {
		return "GradingFormat [id=" + gradingFormatId + ", title=" + title + ", passing=" + passing + "]"; 
	}

	public void setGradingFormatId(int gradingFormatId) {
					this.gradingFormatId = gradingFormatId;
	}
	public int getGradingFormatId() {
					return gradingFormatId;
	}
  public void setTitle(String title) {
    this.title = title;
  }
  public String getTitle() {
    return title;
  }
  public void setPassing(double passing) {
    this.passing = passing;
  }
  public double getPassing() {
    return passing;
  }
}
