package com.dxctraining.schedulemodule.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CreateScheduleDto {
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/mm/yyyy")
	private Date arrivalTime;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/mm/yyyy")
	private Date departureTime;
	
	private String airportCode;

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportId(String airportCode) {
		this.airportCode = airportCode;
	}

}
