package com.revature.dao;
import com.revature.beans.Event;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EventDAO extends GenericDAOImpl<Event> {

  public EventDAO() {
    super();
  }
  public EventDAO(String filename) {
    super(filename);
  }

  public int add(Event event) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "INSERT INTO EVENT VALUES(?, ?, ?, ?, ?)";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, event.getEventId());
      ps.setInt(2, event.getEventTypeId());
      ps.setInt(3, event.getAddressId());
      ps.setString(4, event.getDescription());
      ps.setTimestamp(5, event.getEventTimestamp());

      recordsAffected = ps.executeUpdate();
      ps.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      recordsAffected=0;
    }
    return recordsAffected;
  }

  public int update(int id, Event event) {
    PreparedStatement ps = null;
    int recordsAffected = 0;
    try {
      String sql = "UPDATE EVENT SET EVENT_ID = ?, EVENT_TYPE_ID = ?, ADDRESS_ID = ?, DESCRIPTION = ?, EVENT_TIME = ? WHERE EVENT_ID = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, event.getEventId());
      ps.setInt(2, event.getEventTypeId());
      ps.setInt(3, event.getAddressId());
      ps.setString(4, event.getDescription());
      ps.setTimestamp(5, event.getEventTimestamp());

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
    String sql = "DELETE FROM EVENT WHERE EVENT_ID = ?";
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

  public Event getById(int id) {
    PreparedStatement ps = null;
    Event event = null;

    try{
      String sql = "SELECT * FROM EVENT WHERE EVENT_ID = ?";
      ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int eventId = rs.getInt("EVENT_Id");
        int eventTypeId = rs.getInt("EVENT_TYPE_ID");
        int addressId = rs.getInt("ADDRESS_ID");
        String description = rs.getString("DESCRIPTION");
        Timestamp eventTimestamp = rs.getTimestamp("EVENT_TIME");
        event = new Event(eventId, eventTypeId, addressId, description, eventTimestamp);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return event;
  }

  public ArrayList<Event> getAll() {
    PreparedStatement ps = null;
    Event event= null;
    ArrayList<Event> events = new ArrayList<>();

    try{
      String sql = "SELECT * FROM EVENT";
      ps = conn.prepareStatement(sql);
      
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int eventId = rs.getInt("EVENT_Id");
        int eventTypeId = rs.getInt("EVENT_TYPE_ID");
        int addressId = rs.getInt("ADDRESS_ID");
        String description = rs.getString("DESCRIPTION");
        Timestamp eventTimestamp = rs.getTimestamp("EVENT_TIME");
        event = new Event(eventId, eventTypeId, addressId, description, eventTimestamp);
        events.add(event);
      }
      rs.close();
      ps.close();
    }
    catch (Exception ex) {
      ex.getMessage();
    }
    return events;
  }
}
