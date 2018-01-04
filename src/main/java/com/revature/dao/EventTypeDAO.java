package com.revature.dao;
import com.revature.beans.EventType;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventTypeDAO extends GenericDAOImpl<EventType> {

  public EventTypeDAO() {
    super();
  }
  public EventTypeDAO(String filename) {
    super(filename);
  }

  public int add(EventType eventType) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "INSERT INTO EVENT_TYPE VALUES(?, ?, ?)";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, eventType.getEventTypeId());
      ps.setString(2, eventType.getTitle());
      ps.setDouble(3, eventType.getCoverage());

      recordsAffected = ps.executeUpdate();
      ps.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      recordsAffected=0;
    }
    return recordsAffected;
  }

  public int update(int id, EventType eventType) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "UPDATE EVENT_TYPE SET EVENT_TYPE_ID = ?, TITLE = ?, COVERAGE = ? WHERE EVENT_TYPE_ID = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, eventType.getEventTypeId());
      ps.setString(2, eventType.getTitle());
      ps.setDouble(3, eventType.getCoverage());
      ps.setInt(4, eventType.getEventTypeId());

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
    String sql = "DELETE FROM EVENT_TYPE WHERE EVENT_TYPE_ID = ?";
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

  public EventType getById(int id) {
    PreparedStatement ps = null;
    EventType eventType = null;

    try{
      String sql = "SELECT * FROM EVENT_TYPE WHERE EVENT_TYPE_ID = ?";
      ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int eventTypeId = rs.getInt("EVENT_TYPE_Id");
        String title = rs.getString("Title");
        double coverage = rs.getDouble("Coverage");
        eventType = new EventType(eventTypeId, title, coverage);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return eventType;
  }

  public ArrayList<EventType> getAll() {
    PreparedStatement ps = null;
    EventType eventType = null;
    ArrayList<EventType> eventTypes = new ArrayList<>();

    try{
      String sql = "SELECT * FROM EVENT_TYPE";
      ps = conn.prepareStatement(sql);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int eventTypeId = rs.getInt("EVENT_TYPE_Id");
        String title = rs.getString("Title");
        double coverage = rs.getDouble("Coverage");
        eventType = new EventType(eventTypeId, title, coverage);
        eventTypes.add(eventType);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return eventTypes;
  }
}
