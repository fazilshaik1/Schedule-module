package com.dxctraining.schedulemodule.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxctraining.schedulemodule.entities.Schedule;

public interface IScheduleDao extends JpaRepository<Schedule,Integer> {

}
