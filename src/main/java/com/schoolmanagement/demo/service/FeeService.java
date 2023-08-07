package com.schoolmanagement.demo.service;

import java.util.List;

import com.schoolmanagement.demo.entity.Fee;
import com.schoolmanagement.demo.entity.Student;

public interface FeeService {
	public Fee saveFee(Fee fee);
	public List<Fee> getAllFees();
	public Fee getFeeById(Long id);
	public Fee updateFee(Long id,Fee updateFee);
	Boolean deleteFee(Long id);
}
