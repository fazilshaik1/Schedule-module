package com.dxctraining.scheduledflightmodule.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.scheduledflightmodule.dto.CreateScheduledFlightRequest;
import com.dxctraining.scheduledflightmodule.dto.FlightDto;
import com.dxctraining.scheduledflightmodule.dto.ScheduleDto;
import com.dxctraining.scheduledflightmodule.dto.ScheduledFlightDto;
import com.dxctraining.scheduledflightmodule.entities.ScheduledFlight;
import com.dxctraining.scheduledflightmodule.service.IScheduledFlightService;
import com.dxctraining.scheduledflightmodule.util.ScheduledFlightUtil;

@RestController
@RequestMapping("/scheduledflights")
public class ScheduledFlightRestController {
	
	@Autowired
	private IScheduledFlightService service;
	
	@Autowired
	private ScheduledFlightUtil util;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
	public ScheduledFlightDto addScheduledFlight(@RequestBody CreateScheduledFlightRequest req) {
		ScheduledFlight scheduledFlight = new ScheduledFlight(req.getAvailableSeats(),req.getScheduleId(),req.getFlightNumber());
		scheduledFlight = service.save(scheduledFlight);
		ScheduleDto scheduleDto = findScheduleByScheduleId(req.getScheduleId());
		FlightDto flightDto = findFlightByFlightNumber(req.getFlightNumber());
		ScheduledFlightDto response = util.sfDto(scheduledFlight,scheduleDto.getScheduleId(),scheduleDto.getArrivalTime(),scheduleDto.getDepartureTime(),scheduleDto.getSourceAirport(),scheduleDto.getDestinationAirport(),scheduleDto.getAirportCode(),flightDto.getFlightNumber(),flightDto.getFlightModel(),flightDto.getCarrierName(),flightDto.getSeatCapacity());
		return response;
	}
	
	@GetMapping("/get/{sfId}")
	public ScheduledFlightDto findScheduledFlightBySfId(@PathVariable("sfId")BigInteger sfId) {
		ScheduledFlight scheduledFlight = service.findBySfId(sfId);
		Integer scheduleId = scheduledFlight.getScheduleId();
		ScheduleDto scheduleDto = findScheduleByScheduleId(scheduleId);
		BigInteger flightNumber = scheduledFlight.getFlightNumber();
		FlightDto flightDto = findFlightByFlightNumber(flightNumber);
		ScheduledFlightDto response = util.sfDto(scheduledFlight,scheduleId,scheduleDto.getArrivalTime(),scheduleDto.getDepartureTime(),scheduleDto.getSourceAirport(),scheduleDto.getDestinationAirport(),scheduleDto.getAirportCode(),flightNumber, flightDto.getFlightModel(), flightDto.getCarrierName(), flightDto.getSeatCapacity());
		return response;
	}
	
	@GetMapping("/all")
	public List<ScheduledFlightDto> allScheduledFlights(){
		List<ScheduledFlight>list = service.allScheduledFlights();
		List<ScheduledFlightDto> response = new ArrayList<>();
		for(ScheduledFlight scheduledFlight:list) {
			Integer scheduleId = scheduledFlight.getScheduleId();
			ScheduleDto scheduleDto = findScheduleByScheduleId(scheduleId);
			BigInteger flightNumber = scheduledFlight.getFlightNumber();
			FlightDto flightDto = findFlightByFlightNumber(flightNumber);
			ScheduledFlightDto dto = util.sfDto(scheduledFlight,scheduleId,scheduleDto.getArrivalTime(),scheduleDto.getDepartureTime(),scheduleDto.getSourceAirport(),scheduleDto.getDestinationAirport(),scheduleDto.getAirportCode(),flightNumber, flightDto.getFlightModel(), flightDto.getCarrierName(), flightDto.getSeatCapacity());
			response.add(dto);
		}
		return response;
	}
	
	@DeleteMapping("/delete/{sfId}")
	public void deleteScheduledFlight(@PathVariable("sfId")BigInteger sfId) {
		service.deleteScheduledFlight(sfId);
	}

	private FlightDto findFlightByFlightNumber(BigInteger flightNumber) {
		String url = "http://localhost:8787/flights/get/"+flightNumber;
		FlightDto dto = restTemplate.getForObject(url, FlightDto.class);
		return dto;
	}

	private ScheduleDto findScheduleByScheduleId(Integer scheduleId) {
		String url = "http://localhost:8585/schedules/get/"+scheduleId;
		ScheduleDto dto = restTemplate.getForObject(url, ScheduleDto.class);
		return dto;
	}

}
