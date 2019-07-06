package com.bus.entity;

/**
 * bus
 */
public class Bus {

  int busNo;
  String busName;
  int noOfSeat;
  
	public int getBusNo() {
		return busNo;
	}
	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	
	public int getNoOfSeat() {
		return noOfSeat;
	}
	public void setNoOfSeat(int noOfSeat) {
		this.noOfSeat = noOfSeat;
	}

	public void display() {
		System.out.println("Bus No "+ busNo);
		System.out.println("Bus Name "+ busName);
		System.out.println("No Of Seat "+ noOfSeat);
	}

}