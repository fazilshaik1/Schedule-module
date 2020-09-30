package com.dxctraining.scheduledflightmodule.service;

import java.util.List;

import com.dxctraining.scheduledflightmodule.entities.ScheduledFlight;

public interface IScheduledFlightService {
	
	ScheduledFlight save(ScheduledFlight scheduledFlight);
	
	List<ScheduledFlight> allScheduledFlights();
	

}
