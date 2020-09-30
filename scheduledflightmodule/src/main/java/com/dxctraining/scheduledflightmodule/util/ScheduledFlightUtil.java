package com.dxctraining.scheduledflightmodule.util;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.dxctraining.scheduledflightmodule.dto.ScheduledFlightDto;
import com.dxctraining.scheduledflightmodule.entities.ScheduledFlight;

@Component
public class ScheduledFlightUtil {
	
	public ScheduledFlightDto sfDto(ScheduledFlight scheduledFlight,Integer scheduleId,Date arrivalTime,Date departureTime,String airportCode, BigInteger flightNumber, String flightModel, String carrierName, Integer seatCapacity){
		ScheduledFlightDto dto = new ScheduledFlightDto(scheduledFlight.getSfId(),scheduledFlight.getAvailableSeats());
		dto.setScheduleId(scheduleId);
		dto.setArrivalTime(arrivalTime);
		dto.setDepartureTime(departureTime);
		dto.setAirportCode(airportCode);
		dto.setFlightNumber(flightNumber);
		dto.setFlightModel(flightModel);
		dto.setCarrierName(carrierName);
		dto.setSeatCapacity(seatCapacity);
		return dto;
	}

}
