package com.dxctraining.schedulemodule.service;

import java.util.List;

import com.dxctraining.schedulemodule.entities.Schedule;

public interface IScheduleService {
	
	Schedule save(Schedule schedule);
	
	Schedule findByScheduleId(Integer scheduleId);
	
	List<Schedule> allSchedules();
	
	void deleteSchedule(Integer scheduleId);

}
