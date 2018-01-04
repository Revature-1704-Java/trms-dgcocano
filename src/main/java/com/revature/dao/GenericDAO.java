package com.revature.dao;
import java.util.List;

public interface GenericDAO<T> {
    public int add(T t);
    public int update(int id, T t);
    public int remove(int id);
    public T getById(int id);
    public List<T> getAll();

    // I want to add search method here if it's possible to search by any multiple object specs
}
