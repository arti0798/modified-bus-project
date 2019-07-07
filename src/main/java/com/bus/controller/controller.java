package com.bus.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bus.entity.Bus;
import com.bus.service.BusService;

import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
//import org.jboss.logging.Param;
//import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
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
  //@RequestMapping(path = "/get", method = RequestMethod.GET)
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

  @GetMapping(value = "/get/{bName}")
  public List<Bus> fetchName(@PathVariable String bName) {

    List<Bus> listOfBus = busService.fetchByName(bName);
    System.out.println("Controller bus list "+ listOfBus);    

    return listOfBus;
  }
  @DeleteMapping(value = "deleteId")
  public String deleteByBusNo(@RequestBody String args) {

    try {

      JsonParser jsonParser = new BasicJsonParser();
      Map<String, Object> jsonMap = jsonParser.parseMap(args);

      String busNo = (String.valueOf(jsonMap.get("busNo")));
      busService.deleteBusById(busNo);
    } catch (Exception e) {
      System.out.println("Error is " + e);
    }
    return "deleted successfully";
  }
  
}