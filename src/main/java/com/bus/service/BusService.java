package com.bus.service;

import java.util.List;

import com.bus.entity.Bus;

/**
 * BusService
 */

public interface BusService {

  public List<Bus> getDetail();
  public void insert(Bus bus);
}