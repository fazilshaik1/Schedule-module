package com.dxctraining.schedulemodule.util;

import org.springframework.stereotype.Component;

import com.dxctraining.schedulemodule.dto.ScheduleDto;
import com.dxctraining.schedulemodule.entities.Schedule;

@Component
public class ScheduleUtil {
	
	public ScheduleDto scheduleDto(Schedule schedule,String airportCode, String airportName, String airportLocation) {
		ScheduleDto dto = new ScheduleDto(schedule.getScheduleId(),schedule.getArrivalTime(),schedule.getDepartureTime());
		schedule.setArrivalTime(schedule.getArrivalTime());
		schedule.setDepartureTime(schedule.getDepartureTime());
		dto.setAirportCode(airportCode);
		dto.setAirportName(airportName);
		dto.setAirportLocation(airportLocation);
		return dto;
	}

}
