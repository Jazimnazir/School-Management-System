package com.schoolmanagement.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.demo.entity.Attendence;
import com.schoolmanagement.demo.entity.Bus;
import com.schoolmanagement.demo.repository.AttendenceRepository;

@Service
public class AttendenceServiceImpl implements AttendenceService{

	@Autowired
	private AttendenceRepository attendenceRepository;
	
	
	@Override
	
	public Attendence saveAttendence (Attendence attendence) {
	
		return attendenceRepository.save(attendence);
	}


	@Override
	public List<Attendence> getallAttendence() {
		
		return attendenceRepository.findAll();
	}


	@Override
	public Attendence getAttendenceById(Long id) {
		Attendence attendence = attendenceRepository.findById(id).get();
		return null;
	}


	@Override
	public Attendence updateAttendence(Long id, Attendence updateAttendence) {
		// TODO Auto-generated method stub
		return attendenceRepository.save(updateAttendence);
	}


	@Override
	public Boolean deleteAttendence(Long id) {

		Optional<Attendence>attendence=attendenceRepository.findById(id);
		if(attendence.isPresent()) {
			attendenceRepository.deleteById(id);
			return true;
		}
		return false;

	}
	

}
