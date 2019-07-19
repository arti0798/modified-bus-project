package com.bus.dao;

import java.util.List;
import java.util.Map;

import com.bus.entity.Bus;

/**
 * BusDao
 */
public interface BusDao {

  public List<Bus> getDetail();
  public void insert(Bus bus);
  public List<Bus> fetchByName(String bName);
  public Bus fetchBusById(int busNo);
  public void deleteBusById(String busNo);
  public void updateByBusNo(Map<String, Object> args);
}