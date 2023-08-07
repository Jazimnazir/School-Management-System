package com.schoolmanagement.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.demo.repository.ClassNameRepositery;
import com.schoolmanagement.demo.repository.StudentRepository;
@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ClassNameRepositery classNameRepositery;
	
	@GetMapping("/")
	public  ResponseEntity<HashMap<String, Integer>> getStudentById(){
//		System.err.println("total Student"+ studentRepository.findAll().size());
//		System.err.println("total Classes"+ classNameRepositery.findAll().size());
		HashMap<String, Integer> response = new HashMap<>();
		response.put("totalStudents", studentRepository.findAll().size());
		response.put("totalClasses", classNameRepositery.findAll().size());
        return ResponseEntity.ok(response);
  }

}

