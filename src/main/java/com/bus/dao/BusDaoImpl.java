package com.bus.dao;

import java.util.List;

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
public class BusDaoImpl implements BusDao{

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
}