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
import com.schoolmanagement.demo.entity.Subject;
import com.schoolmanagement.demo.service.SubjectService;

@RestController
@RequestMapping("/subject")
@CrossOrigin(origins= "*")

public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	 @PostMapping(value="/add")
	    public String add(@RequestBody Subject subject){
	        subjectService.saveSubject(subject);
	        return "Your Subject is Added";
	    }
	 @GetMapping("/getAll")
	 public List<Subject> getAllSubjects(){
		 return subjectService.getAllSubjects();
	 }
	 @GetMapping("/getSubject/{id}")
	 public ResponseEntity getSubject (@PathVariable Long id) {
		 return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSubjectById(id));
	 }
	 @PutMapping ("/updateSubject/{id}")
	    public ResponseEntity save(@RequestBody Subject updateSubject , @PathVariable Long id ) {
	        return ResponseEntity.status(HttpStatus.OK).body(subjectService.updateSubject(id, updateSubject));
	    }
	 
	 @DeleteMapping("/deleteSubject/{id}")
	 public ResponseEntity deleteSubject (@PathVariable Long id) {
		 return ResponseEntity.status(HttpStatus.OK).body(subjectService.deleteSubject(id));
	 }


}
