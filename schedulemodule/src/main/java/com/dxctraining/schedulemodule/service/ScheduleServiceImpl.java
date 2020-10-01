package com.dxctraining.schedulemodule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.schedulemodule.dao.IScheduleDao;
import com.dxctraining.schedulemodule.entities.Schedule;
import com.dxctraining.schedulemodule.exceptions.InvalidArgumentException;

@Transactional
@Service
public class ScheduleServiceImpl implements IScheduleService {
	
	@Autowired
	private IScheduleDao dao;

	@Override
	public Schedule save(Schedule schedule) {
		validate(schedule);
		schedule = dao.save(schedule);
		return schedule;
	}

	private void validate(Schedule schedule) {
		if(schedule == null) {
			throw new NullPointerException("schedule should not be null");
		}
		
	}

	@Override
	public List<Schedule> allSchedules() {
		List<Schedule> list =dao.findAll();
		return list;
	}

	@Override
	public Schedule findByScheduleId(Integer scheduleId) {
		Optional<Schedule> optional = dao.findById(scheduleId);
		if(!optional.isPresent()) {
			throw new InvalidArgumentException("Schedule Not found for entered Id,Enter valid scheduleId");
		}
		Schedule schedule =optional.get();
		return schedule;
	}

	@Override
	public void deleteSchedule(Integer scheduleId) {
		if(dao.existsById(scheduleId)) {
			dao.deleteById(scheduleId);
		}else {
			throw new InvalidArgumentException("there is no such schedule, enter valid scheduleId");
		}
		
	}

}
