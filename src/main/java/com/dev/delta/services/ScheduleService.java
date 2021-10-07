package com.dev.delta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Schedule;
import com.dev.delta.exceptions.ScheduleNotFound;
import com.dev.delta.repositories.ScheduleRepository;


@Service
public class ScheduleService {
	@Autowired
	ScheduleRepository  scheduleRepository;
	
	public Schedule saveOrUpdate(Schedule schedule)
	{
		
		return scheduleRepository.save(schedule);
	}
	
	public Iterable<Schedule> findAll()
	{
		return scheduleRepository.findAll();
	}
	
	public Schedule findById(Long id)
	{
		return scheduleRepository.findById(id).orElseThrow(()->new ScheduleNotFound("Schedule Not found."));
	}
	
	public void delete(Long id)
	{
		Schedule schedule=findById(id);
		scheduleRepository.delete(schedule);
	}
}
