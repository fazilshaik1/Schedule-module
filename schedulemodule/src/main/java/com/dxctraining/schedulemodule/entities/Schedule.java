package com.dxctraining.schedulemodule.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Schedule {
	
	@Id
	@GeneratedValue
	private Integer scheduleId;
	
	private Date arrivalTime;
	
	private Date departureTime;
	
	private String airportCode;
	
	public Schedule() {
		
	}
	
	public Schedule(Date arrivalTime, Date departureTime, String airportCode) {
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.airportCode = airportCode;
	}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

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

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass()!= o.getClass()) {
			return false;
		}
		Schedule schedule =(Schedule)o;
		return Objects.equals(scheduleId, schedule.getScheduleId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(scheduleId);
	}

}
