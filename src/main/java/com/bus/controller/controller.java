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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping(value = "/{busNo}")
  public Bus fetchBusById(@PathVariable int busNo) {

    System.out.println("Bus no is " + busNo);
    return busService.fetchBusById(busNo);
  }

  @PostMapping(path = "/create")
  public String insert(@RequestBody Bus bus) {
   
    busService.insert(bus);
    return "Inserted Successfully";
  }

}