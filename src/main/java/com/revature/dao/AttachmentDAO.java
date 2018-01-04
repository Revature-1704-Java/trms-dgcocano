package com.revature.dao;
import com.revature.beans.Attachment;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachmentDAO extends GenericDAOImpl<Attachment> {

  public AttachmentDAO() {
    super();
  }
  public AttachmentDAO(String filename) {
    super(filename);
  }

  public int add(Attachment attachment) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "INSERT INTO ATTACHMENT VALUES(?, ?, ?, ?)";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, attachment.getAttachmentId());
      ps.setInt(2, attachment.getReimbursementId());
      ps.setInt(3, attachment.getApprovalType());
      ps.setString(4, attachment.getDescription());

      recordsAffected = ps.executeUpdate();
      ps.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      recordsAffected=0;
    }
    return recordsAffected;
  }

  public int update(int id, Attachment attachment) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "UPDATE ATTACHMENT SET ATTACHMENT_ID = ?, REIMBURSEMENT_ID = ? , APPROVAL_TYPE = ?, DESCRIPTION = ? WHERE ATTACHMENT_ID = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, attachment.getAttachmentId());
      ps.setInt(2, attachment.getReimbursementId());
      ps.setInt(3, attachment.getApprovalType());
      ps.setString(4, attachment.getDescription());
      ps.setInt(5, attachment.getAttachmentId());

      recordsAffected = ps.executeUpdate();
      ps.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      recordsAffected=0;
    }
    return recordsAffected;
  }

  public int remove(int id) {
		PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
    String sql = "DELETE FROM ATTACHMENT WHERE ATTACHMENT_ID = ?";
    ps = conn.prepareStatement(sql);
		ps.setInt(1, id);

    recordsAffected = ps.executeUpdate();
    ps.close();
    }
    catch(Exception ex) {
      ex.printStackTrace();
      recordsAffected = 0;
    }
    return recordsAffected;
  }

  public Attachment getById(int id) {
    PreparedStatement ps = null;
    Attachment attachment = null;

    try{
      String sql = "SELECT * FROM ATTACHMENT WHERE ATTACHMENT_ID = ?";
      ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int attachmentId = rs.getInt("ATTACHMENT_Id");
        int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
        int approvalType = rs.getInt("ApprovalType");
        String description = rs.getString("Description");
        attachment = new Attachment(attachmentId, reimbursementId, approvalType, description);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return attachment;
  }

  public ArrayList<Attachment> getAll() {
    PreparedStatement ps = null;
    Attachment attachment = null;
    ArrayList<Attachment> attachments = new ArrayList<>();

    try{
      String sql = "SELECT * FROM ATTACHMENT";
      ps = conn.prepareStatement(sql);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int attachmentId = rs.getInt("ATTACHMENT_Id");
        int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
        int approvalType = rs.getInt("Approval_Type");
        String description = rs.getString("Description");
        attachment = new Attachment(attachmentId, reimbursementId, approvalType, description);
        attachments.add(attachment);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return attachments;
  }
}
