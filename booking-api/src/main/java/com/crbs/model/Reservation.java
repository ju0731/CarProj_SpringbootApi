package com.crbs.model;

import java.util.Date;

public class Reservation {
	String customerId;
	String carCode;
	Date startDate;
	Date endDate;
	
	public Reservation() {}

	public Reservation(String customerId, String carCode, Date startDate, Date endDate) {
		this.customerId = customerId;
		this.carCode = carCode;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCarCode() {
		return carCode;
	}

	public void setCarCode(String carCode) {
		this.carCode = carCode;
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
