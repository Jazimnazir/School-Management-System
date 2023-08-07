package com.schoolmanagement.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.demo.entity.ClassName;
import com.schoolmanagement.demo.entity.Student;
import com.schoolmanagement.demo.repository.StudentRepository;
import com.schoolmanagement.demo.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
	
	@Autowired 
	StudentService studentService;
	
	@Autowired
	StudentRepository studentRepository;

	
	@PostMapping(value="/add")
    public ResponseEntity<String> add(@RequestBody Student student){
		Student existingStudent = studentRepository.findByRollNumber(student.getRollNumber());
		if (existingStudent == null) {
			studentRepository.save(student);
			return ResponseEntity.ok("Student saved with Id" + student.getRollNumber() );
		}
	//	System.err.println(student.getClassName().toString());
	//	ClassName clas = student.getClassName();
	//	System.err.println("class==="+clas.getClassName());
        studentService.saveStudent(student);
        return ResponseEntity.badRequest().body("Already exists");
    }
	
	
	 @GetMapping("/getAll")
	 public List<Student> getAllStudents(){
		 return studentService.getAllStudents();
	 }
	 
	 @GetMapping("/get-Student/{id}")
	 public ResponseEntity getStudent (@PathVariable Long id) {
		 return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
	 }
	 
	 
	 @PutMapping ("/update-student/{id}")
	    public ResponseEntity save(@RequestBody Student updateStudent , @PathVariable Long id ) {
	        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(id, updateStudent));
	    }
	
	
	 @DeleteMapping("/delete-student/{id}")
	 public ResponseEntity deleteStudent (@PathVariable Long id) {
		 return ResponseEntity.status(HttpStatus.OK).body(studentService.deleteStudent(id));
	 }
	 
	 
	 
	 @GetMapping("/page")
	   public ResponseEntity<Map<String, Object>> findPaginated(
	            @RequestParam(value = "page", defaultValue = "1") int pageNo,
	            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize
	    ) {
	        Page<Student> page = studentService.findPaginated(pageNo, pageSize);
	        List<Student> studentList = page.getContent();
	        long totalItems = page.getTotalElements();
	        int totalPages = page.getTotalPages();

	        Map<String, Object> response = new HashMap<>();
	        response.put("data", studentList);
	        response.put("totalPages", totalPages);
	        response.put("totalItems", totalItems);

	        return ResponseEntity.ok(response);
	    }
}



