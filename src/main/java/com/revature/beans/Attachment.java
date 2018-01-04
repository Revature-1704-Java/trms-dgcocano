package com.revature.beans;

public class Attachment implements Comparable<Attachment>{

	private int attachmentId;
  private int reimbursementId;
	private String description;
  private int approvalType;

	public Attachment() {
		super();
	}
	public Attachment(int attachmentId, int reimbursementId, int approvalType, String description){
		super();
		this.attachmentId = attachmentId;
		this.description = description;
    this.approvalType = approvalType;
    this.reimbursementId = reimbursementId;
	}

  public int compareTo(Attachment that) {
    final int BEFORE = -1;
    final int EQUAL = -0;
    final int AFTER = 1;
    
    if(this == that) return EQUAL;
    if(this.getAttachmentId() < that.getAttachmentId()) return BEFORE;
    if(this.getAttachmentId() > that.getAttachmentId()) return AFTER;
    
    return EQUAL;
  }
	@Override
	public String toString() {
		return "Attachment [id=" + attachmentId + ", reimbursementId=" + reimbursementId + ", description=" + description + ", approvalType=" + approvalType + "]"; 
	}

	public void setAttachmentId(int attachmentId) {
					this.attachmentId = attachmentId;
	}
	public int getAttachmentId() {
					return attachmentId;
	}
  public void setDescription(String description) {
    this.description = description;
  }
  public String getDescription() {
    return description;
  }
  public void setApprovalType(int approvalType) {
    this.approvalType = approvalType;
  }
  public int getApprovalType() {
    return approvalType;
  }
  public void setReimbursementId(int reimbursementId) {
    this.reimbursementId = reimbursementId;
  }
  public int getReimbursementId() {
    return reimbursementId;
  }
}
