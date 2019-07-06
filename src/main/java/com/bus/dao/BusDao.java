package com.bus.dao;

import java.util.List;

import com.bus.entity.Bus;

/**
 * BusDao
 */
public interface BusDao {

  public List<Bus> getDetail();
  public void insert(Bus bus);
}