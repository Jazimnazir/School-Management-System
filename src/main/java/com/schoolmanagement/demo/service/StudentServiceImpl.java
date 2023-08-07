package com.schoolmanagement.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.schoolmanagement.demo.entity.ClassName;
import com.schoolmanagement.demo.entity.Student;
import com.schoolmanagement.demo.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	
	

	@Override
	public Student getStudentById(Long id) {
		Student student=studentRepository.findById(id).get();
		return student;
	}

	@Override
	public Student updateStudent(Long id, Student updateStudent) {
		return studentRepository.save(updateStudent);
	}

	@Override
	public Boolean deleteStudent(Long id) {
		Optional<Student>student=studentRepository.findById(id);
		if(student.isPresent()) {
			studentRepository.deleteById(id);
			return true;
		}
	
		return false;
	}


	

	@Override
	public Page<Student> findPaginated(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
				
		return studentRepository.findAll(pageable);
	}





	
	
	
	

}
