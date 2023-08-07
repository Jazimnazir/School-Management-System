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

import com.schoolmanagement.demo.entity.Attendence;
import com.schoolmanagement.demo.entity.Bus;
import com.schoolmanagement.demo.entity.ClassName;
import com.schoolmanagement.demo.service.AttendenceService;

@RestController
@RequestMapping("/attendence")
@CrossOrigin(origins= "*")
public class AttendenceController {
	
	@Autowired
	private AttendenceService attendenceService;
	
	 @PostMapping(value="/add")
	    public String add(@RequestBody Attendence attendence){
		 attendenceService.saveAttendence(attendence);
	        return "Your class is Added";
	    }
	 @GetMapping("/getAll")
	 public List<Attendence> getAllAttendence(){
		 return attendenceService.getallAttendence();
	 }
	 
//	 @GetMapping("/getAttendence/{id}")
//	 public ResponseEntity getAttendence (@PathVariable Long id) {
//		 Attendence attendance = attendenceService.getAttendenceById(id);
//		 System.err.println(attendance.getStatus());
//		 return ResponseEntity.status(HttpStatus.OK).body(attendenceService.getAttendenceById(id));
//	 }
	 @PutMapping ("/updateAttendence/{id}")
	    public ResponseEntity save(@RequestBody Attendence updateAttendence , @PathVariable Long id ) {
	        return ResponseEntity.status(HttpStatus.OK).body(attendenceService.updateAttendence(id, updateAttendence));
	    }
	 
	 @DeleteMapping("/deleteAttendence/{id}")
	 public ResponseEntity deleteAttendence (@PathVariable Long id) {
		 return ResponseEntity.status(HttpStatus.OK).body(attendenceService.deleteAttendence(id));
	 }


}
