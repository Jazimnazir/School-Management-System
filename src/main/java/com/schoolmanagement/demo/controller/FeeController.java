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

import com.schoolmanagement.demo.entity.ClassName;
import com.schoolmanagement.demo.entity.Fee;
import com.schoolmanagement.demo.entity.Student;
import com.schoolmanagement.demo.repository.FeeRepository;
import com.schoolmanagement.demo.service.FeeService;
@RestController
@RequestMapping("/fee")
@CrossOrigin

public class FeeController {
	
	@Autowired
	private FeeService feeService;
	
	@Autowired
	private FeeRepository feeRepository;

	
	@PostMapping(value="/add")
	public ResponseEntity<String> add(@RequestBody Fee fee){
		int month = (int) fee.getPaymentDate().getMonthValue();
		System.err.println(month);
		int year = fee.getPaymentDate().getYear();
		System.err.println(year);
		List<Fee> existingFee = feeRepository.existsByPaymentDate(month, year);
		System.err.println(existingFee.toString());
		if (existingFee.isEmpty()) {
			feeRepository.save(fee);
			System.err.println("successfully");
			return ResponseEntity.ok("Fee saved with Id" + fee.getPaymentDate() );
		}
		System.err.println("already exists"); 
		return ResponseEntity.ok("Fee already exists");  
	}

	
	
	@GetMapping("/getAll")
	public List<Fee> getAllFees(){
		return feeService.getAllFees();
		
	}
	 @GetMapping("/getFee/{id}")
	 public ResponseEntity getFee (@PathVariable Long id) {
		 return ResponseEntity.status(HttpStatus.OK).body(feeService.getFeeById(id));
	 }
	 
	 @PutMapping ("/updateFee/{id}")
	    public ResponseEntity save(@RequestBody Fee updateFee , @PathVariable Long id ) {
	        return ResponseEntity.status(HttpStatus.OK).body(feeService.updateFee(id, updateFee));
	    }
	 @DeleteMapping("/deleteFee/{id}")
	 public ResponseEntity deleteFee (@PathVariable Long id) {
		 return ResponseEntity.status(HttpStatus.OK).body(feeService.deleteFee(id));
	 }
	
}
