package com.schoolmanagement.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.demo.entity.Student;
import com.schoolmanagement.demo.entity.Teacher;
import com.schoolmanagement.demo.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public Teacher saveTeacher(Teacher teacher) {
		
		return teacherRepository.save(teacher);
	}

	@Override
	public List<Teacher> getAllteachers() {
		
		return teacherRepository.findAll();
	}

	@Override
	public Teacher getTeacherById(Long id) {
		Teacher teacher=teacherRepository.findById(id).get();
		return teacher;
	}

	@Override
	public Teacher updateTeacher(Long id, Teacher updateTeacher) {
		
		return teacherRepository.save(updateTeacher);
	}

	@Override
	public Boolean deleteTeacher(Long id) {
		Optional<Teacher>teacher=teacherRepository.findById(id);
		if(teacher.isPresent()) {
			teacherRepository.deleteById(id);
			return true;
		}
		return null;
	}
	

}
