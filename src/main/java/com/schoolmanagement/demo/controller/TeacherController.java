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
import com.schoolmanagement.demo.entity.Student;
import com.schoolmanagement.demo.entity.Teacher;
import com.schoolmanagement.demo.service.TeacherService;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins= "*")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@PostMapping(value="/add")
	 public String add(@RequestBody Teacher  teacher) {
		 teacherService.saveTeacher(teacher);
		 return "Teacher Added";
	}
	 @GetMapping("/getAll")
	 public List<Teacher> getAllTeachers(){
		 return teacherService.getAllteachers();
	 }
	 @GetMapping("/getTeacher/{id}")
	 public ResponseEntity getTeacher (@PathVariable Long id) {
		 return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeacherById(id));
	 }
	 @PutMapping ("/updateTeacher/{id}")
	    public ResponseEntity save(@RequestBody Teacher updateTeacher , @PathVariable Long id ) {
	        return ResponseEntity.status(HttpStatus.OK).body(teacherService.updateTeacher(id, updateTeacher));
	    }
	 
	
	 @DeleteMapping("/deleteTeacher/{id}")
	 public ResponseEntity deleteteacher (@PathVariable Long id) {
		 return ResponseEntity.status(HttpStatus.OK).body(teacherService.deleteTeacher(id));
	 }
	
}
