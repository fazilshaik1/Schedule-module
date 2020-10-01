package com.dxctraining.scheduledflightmodule.service;

import java.math.BigInteger;
import java.util.List;

import com.dxctraining.scheduledflightmodule.entities.ScheduledFlight;

public interface IScheduledFlightService {
	
	ScheduledFlight save(ScheduledFlight scheduledFlight);
	
	ScheduledFlight findBySfId(BigInteger sfId);
	
	List<ScheduledFlight> allScheduledFlights();
	
	void deleteScheduledFlight(BigInteger sfId);
	

}
