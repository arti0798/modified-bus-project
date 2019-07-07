package com.bus.controller;

import java.util.List;

import javax.annotation.Resource;

import com.bus.entity.Bus;
import com.bus.service.BusService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller
 */
@RestController
@RequestMapping(path = "/bus")
public class controller {

  @Resource BusService busService;

  @GetMapping(value = "/get")
  public List<Bus> fetchBuses() {

    List<Bus> listOfBus = busService.getDetail();    
    return listOfBus;
  }

  @PostMapping(path = "/create")
  public String insert(@RequestBody Bus bus) {

    
    busService.insert(bus);
    return "Inserted Successfully";
  }
  @GetMapping(value = "/get/{bName}")
  public List<Bus> fetchName(@PathVariable String bName) {

    List<Bus> listOfBus = busService.fetchByName(bName);
    System.out.println("Controller bus list "+ listOfBus);    

    return listOfBus;
  }

}