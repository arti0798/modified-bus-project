package com.bus.dao;

import java.util.List;
import java.util.Map;

import com.bus.entity.Bus;
import com.bus.mapping.BusRowMapper;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * BusDaoImp
 */
@Repository
public class BusDaoImpl implements BusDao {

  NamedParameterJdbcTemplate template;

  public BusDaoImpl(NamedParameterJdbcTemplate template) {
    this.template = template;
  }

  @Override
  public List<Bus> getDetail() {

    String sql = "select * from bus";

    List<Bus> listOfBus = template.query(sql, new BusRowMapper());
    System.out.println("List of bus are "+ listOfBus);

    return listOfBus;
  }


  @Override
  public void insert(Bus bus) {

    String insertSql = "insert into bus (busNo,busName,noOfSeat) values(:busNo, :busName, :noOfSeat)";
    SqlParameterSource param = new MapSqlParameterSource()
    .addValue("busNo", bus.getBusNo())
    .addValue("busName", bus.getBusName())
    .addValue("noOfSeat", bus.getNoOfSeat());

    template.update(insertSql, param);
    bus.display();

  }
  public List<Bus> fetchByName(String value) {

    System.out.println("dao bName"+ value);
    String sql = "select * from bus where busName = :bName";
    SqlParameterSource param = new MapSqlParameterSource().addValue("bName", value);

    List<Bus> listOfBus = template.query(sql, param, new BusRowMapper());
    System.out.println("bus list in dao "+ listOfBus);
    return listOfBus;
  }

  @Override
  public Bus fetchBusById(int busNo) {

    System.out.println("busNo "+ busNo);
    String fetchStr = "select * from bus where busNo = :bNo";
    SqlParameterSource param = new MapSqlParameterSource().addValue("bNo", busNo);

    List<Bus> busList = template.query(fetchStr, param, new BusRowMapper());
    System.out.println("bus list "+ busList);

    if(busList.size() == 1) {

      return busList.get(0);
    }
    return null;
  }

  @Override
  public void updateByBusNo(Map<String, Object> args) {

    System.out.println("value in dao "+args);

    String updateQuery = "update bus set ";
    
    MapSqlParameterSource source = new MapSqlParameterSource();
    for (String fieldName : args.keySet()) {

      if (!fieldName.equals("busNo")) {        
        updateQuery += fieldName +" = :"+fieldName + ", ";
      }
      source.addValue(fieldName, args.get(fieldName));
    }

    // REGEX, 
    updateQuery = updateQuery.replaceAll(", $", " ");
    updateQuery += "where" + " busNo = :busNo";

    SqlParameterSource param = source;
    template.update(updateQuery, param);
  }

} 
