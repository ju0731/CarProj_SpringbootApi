package com.crbs.model;

import java.util.Date;

public class MyBooking {
	String code;
	String name;
	int price;
	Date startDate;
	Date endDate;
	
	public MyBooking() {}
	
	public MyBooking(String code, String name, int price, Date startDate, Date endDate) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
