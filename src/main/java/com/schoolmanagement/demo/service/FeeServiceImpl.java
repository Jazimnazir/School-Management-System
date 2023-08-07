package com.schoolmanagement.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.demo.entity.Fee;
import com.schoolmanagement.demo.entity.Student;
import com.schoolmanagement.demo.repository.FeeRepository;

@Service
public class FeeServiceImpl implements FeeService {
	
	@Autowired
	private FeeRepository feeRepository;

	@Override
	public Fee saveFee(Fee fee) {
		
		return feeRepository.save(fee);
	}

	@Override
	public List<Fee> getAllFees() {
		
		return feeRepository.findAll();
	}

	@Override
	public Fee getFeeById(Long id) {
		Fee fee=feeRepository.findById(id).get();
		return fee;
	}

	@Override
	public Fee updateFee(Long id, Fee updateFee) {
		
		return feeRepository.save(updateFee);
	}

	@Override
	public Boolean deleteFee(Long id) {
		Optional<Fee>fee=feeRepository.findById(id);
		if(fee.isPresent()) {
			feeRepository.deleteById(id);
			return true;
		}
		
		return false;
	}
	

}
