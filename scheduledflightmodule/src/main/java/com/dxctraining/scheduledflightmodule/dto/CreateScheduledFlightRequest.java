package com.dxctraining.scheduledflightmodule.dto;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

public class CreateScheduledFlightRequest {
	
	@NotNull
	private Integer availableSeats;
	
	@NotNull
	private Integer scheduleId;
	
	@NotNull
	private BigInteger flightNumber;
	
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
