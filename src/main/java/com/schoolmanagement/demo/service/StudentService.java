package com.schoolmanagement.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.schoolmanagement.demo.entity.ClassName;
import com.schoolmanagement.demo.entity.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	public List<Student> getAllStudents();
	public Student getStudentById(Long id);
	public Student updateStudent (Long id,Student updateStudent);
	Boolean deleteStudent(Long id);
	Page<Student> findPaginated(Integer pageNo,Integer pageSize);
}
