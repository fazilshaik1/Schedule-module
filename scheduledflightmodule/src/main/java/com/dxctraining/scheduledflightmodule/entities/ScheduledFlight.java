package com.dxctraining.scheduledflightmodule.entities;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ScheduledFlight {
	
	@Id
	@GeneratedValue
	private BigInteger sfId;
	
	private Integer availableSeats;
	
	private Integer scheduleId;
	
	private BigInteger flightNumber;
	
	public ScheduledFlight() {
		
	}
	
	public ScheduledFlight(Integer availableSeats, Integer scheduleId, BigInteger flightNumber) {
		this.availableSeats = availableSeats;
		this.scheduleId = scheduleId;
		this.flightNumber = flightNumber;
	}

	public BigInteger getSfId() {
		return sfId;
	}

	public void setSfId(BigInteger sfId) {
		this.sfId = sfId;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public BigInteger getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(BigInteger flightNumber) {
		this.flightNumber = flightNumber;
	}

}
