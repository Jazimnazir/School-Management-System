package com.schoolmanagement.demo.service;

import java.util.List;

import com.schoolmanagement.demo.entity.Attendence;
import com.schoolmanagement.demo.entity.Bus;


public interface AttendenceService {
	public Attendence saveAttendence (Attendence Attendence);
	public List<Attendence> getallAttendence();
	public Attendence getAttendenceById(Long id);
	public Attendence updateAttendence (Long id,Attendence updateAttendence);
	Boolean deleteAttendence(Long id);
}
