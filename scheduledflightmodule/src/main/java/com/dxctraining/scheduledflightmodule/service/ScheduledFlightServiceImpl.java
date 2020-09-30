package com.dxctraining.scheduledflightmodule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.scheduledflightmodule.dao.IScheduledFlightDao;
import com.dxctraining.scheduledflightmodule.entities.ScheduledFlight;

@Transactional
@Service
public class ScheduledFlightServiceImpl implements IScheduledFlightService {
	
	@Autowired
	private IScheduledFlightDao dao;

	@Override
	public ScheduledFlight save(ScheduledFlight scheduledFlight) {
		validate(scheduledFlight);
		scheduledFlight = dao.save(scheduledFlight);
		return scheduledFlight;
	}

	private void validate(ScheduledFlight scheduledFlight) {
		if(scheduledFlight == null) {
			throw new NullPointerException("scheduledFlight should not be null");
		}
		
	}

	@Override
	public List<ScheduledFlight> allScheduledFlights() {
		List<ScheduledFlight> list = dao.findAll();
		return list;
	}

}
