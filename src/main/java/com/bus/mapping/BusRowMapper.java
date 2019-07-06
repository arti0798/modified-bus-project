package com.bus.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bus.entity.Bus;

import org.springframework.jdbc.core.RowMapper;


/**
 * BusRowMapper
 */
public class BusRowMapper implements RowMapper<Bus>{

  @Override
  public Bus mapRow(ResultSet rs,int arg1) throws SQLException {

    Bus bus = new Bus();
    bus.setBusName(rs.getString("busName"));
    bus.setBusNo(rs.getInt("busNo"));
    bus.setNoOfSeat(rs.getInt("noOfSeat"));
    return bus;
  }
}