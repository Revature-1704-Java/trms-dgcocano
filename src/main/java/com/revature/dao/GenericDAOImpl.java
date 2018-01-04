package com.revature.dao;
import com.revature.util.ConnectionUtil;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

  protected String type;
  protected Connection conn;
  private HashSet objects;

  public GenericDAOImpl(){
    try{
      conn = ConnectionUtil.getConnection();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  public GenericDAOImpl(String filename) {
    try{
      conn = ConnectionUtil.getConnection(filename);
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  public void close() {
    if(conn != null) {
      try {
        conn.close();
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  public void finalize() {
    this.close();
  }
  public abstract int add(T t);

  public abstract int update(int id, T t);

  public abstract int remove(int id);

  public abstract T getById(int id);

  public abstract List<T> getAll();

}
