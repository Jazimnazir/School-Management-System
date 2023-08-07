 package com.schoolmanagement.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import com.schoolmanagement.demo.repository.ClassNameRepositery;
import com.schoolmanagement.demo.service.ClassNameService;

@RestController
@RequestMapping("/className")
@CrossOrigin(origins= "*")
public class ClassNameController {
	
	 
	@Autowired
	ClassNameService classNameService;
	
	 @PostMapping(value="/add")
	    public String add(@RequestBody ClassName className){
	        classNameService.saveClassName(className);
	        return "Your class is Added";
	    }
	 
	 @GetMapping("/getAll")
	 public List<ClassName> getAllClassNames(){
		 return classNameService.getAllClassNames();
	 }
	 
	 @GetMapping("/ClassNames")
	 public String ListClassNames() {
		 List<ClassName> classNameList = classNameService.getAllClassNames();
				 return "ViewClass";
	 }
	 @GetMapping("/get-className/{id}")
	 public ResponseEntity getClassName (@PathVariable Long id) {
		 return ResponseEntity.status(HttpStatus.OK).body(classNameService.getClassNameById(id));
	 }
	 
	 @PutMapping ("/update-className/{id}")
	    public ResponseEntity save(@RequestBody ClassName updateClassName , @PathVariable Long id ) {
	        return ResponseEntity.status(HttpStatus.OK).body(classNameService.updateClassName(id, updateClassName));
	    }
	 @DeleteMapping("/delete-className/{id}")
	 public ResponseEntity deleteClassName (@PathVariable Long id) {
		 return ResponseEntity.status(HttpStatus.OK).body(classNameService.deleteClassName(id));
	 }
	 
	 
	
	
	

	

}