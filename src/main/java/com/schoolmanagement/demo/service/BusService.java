package com.schoolmanagement.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.schoolmanagement.demo.entity.Bus;
import com.schoolmanagement.demo.entity.ClassName;

@Service
public interface BusService {
	public Bus saveBus (Bus bus);
	public List<Bus> getallBuses();
	public Bus getBusById(Long id);
	public Bus updateBus (Long id,Bus updateBus);
	Boolean deleteBus(Long id);
}
