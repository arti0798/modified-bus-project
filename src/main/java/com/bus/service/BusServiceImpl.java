package com.bus.service;

import java.util.List;

import javax.annotation.Resource;

import com.bus.dao.BusDao;
import com.bus.entity.Bus;

import org.springframework.stereotype.Component;

/**
 * BusServiceImpl
 */
@Component
public class BusServiceImpl implements BusService {

  @Resource BusDao busDao;

  @Override
  public List<Bus> getDetail() {
    List<Bus> listOfBus =  busDao.getDetail();
    return listOfBus;
  }

  @Override
  public void insert(Bus bus) {

    bus.display();
    busDao.insert(bus);
  }
  public Bus fetchBusById(int busNo) {

    System.out.println("bus id in BS "+ busNo);
    return busDao.fetchBusById(busNo);

  }

}