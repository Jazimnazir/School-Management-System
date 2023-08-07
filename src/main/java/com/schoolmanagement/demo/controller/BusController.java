package com.schoolmanagement.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.demo.entity.Bus;
import com.schoolmanagement.demo.entity.ClassName;
import com.schoolmanagement.demo.entity.Student;
import com.schoolmanagement.demo.repository.BusRepository;
import com.schoolmanagement.demo.service.BusService;
@RestController
@RequestMapping("/bus")
@CrossOrigin(origins= "*")
public class BusController {
	
	
	
	@Autowired
	private BusService busService;
	
	@Autowired
	private BusRepository busRepository;
	
	
	 @PostMapping(value="/add")
	    public String add(@RequestBody Bus bus){
		 Bus existingBus =busRepository.findByBusNumber(bus.getBusNumber());
		 

			if (existingBus == null) {
				busRepository.save(bus);
				return "Bus added successfully";
			}
	        busService.saveBus(bus);
	        return "Already exists";
	    }
	 
	 
	
	 @GetMapping("/getAll")
	 public List<Bus> getAllBuses(){
		 return busService.getallBuses();
	 }
	 
	 @GetMapping("/get-bus/{id}")
	 public ResponseEntity getBus (@PathVariable Long id) {
		 return ResponseEntity.status(HttpStatus.OK).body(busService.getBusById(id));
	 }
	 @PutMapping ("/update-bus/{id}")
	    public ResponseEntity save(@RequestBody Bus updateBus , @PathVariable Long id ) {
	        return ResponseEntity.status(HttpStatus.OK).body(busService.updateBus(id, updateBus));
	    }
	 
	 @DeleteMapping("/delete-bus/{id}")
	 public ResponseEntity deleteBus (@PathVariable Long id) {
		 return ResponseEntity.status(HttpStatus.OK).body(busService.deleteBus(id));
	 }

}
