package com.schoolmanagement.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.demo.entity.Bus;
import com.schoolmanagement.demo.entity.ClassName;
import com.schoolmanagement.demo.repository.BusRepository;

@Service
public class BusServiceImpl implements BusService {
	
	@Autowired
	private BusRepository busRepository;

	@Override
	public Bus saveBus(Bus bus) {
		
		return busRepository.save(bus);
	}

	@Override
	public List<Bus> getallBuses() {
		
		return busRepository.findAll();
	}

	@Override
	public Bus getBusById(Long id) {
		// TODO Auto-generated method stub
		Bus bus=busRepository.findById(id).get();
		return bus;
	}
	@Override
	public Bus updateBus(Long id, Bus updateBus) {
		return busRepository.save(updateBus);
	}

	@Override
	public Boolean deleteBus(Long id) {
		// TODO Auto-generated method stub
		Optional<Bus>bus=busRepository.findById(id);
		if(bus.isPresent()) {
			busRepository.deleteById(id);
			return true;
		}
		return false;
	}
	

	
}
