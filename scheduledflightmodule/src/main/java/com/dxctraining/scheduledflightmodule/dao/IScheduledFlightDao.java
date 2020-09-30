package com.dxctraining.scheduledflightmodule.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxctraining.scheduledflightmodule.entities.ScheduledFlight;

public interface IScheduledFlightDao extends JpaRepository<ScheduledFlight,BigInteger> {

}
