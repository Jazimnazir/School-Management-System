package com.schoolmanagement.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.schoolmanagement.demo.entity.Student;
import com.schoolmanagement.demo.entity.Teacher;

public interface TeacherService {
	public Teacher saveTeacher (Teacher teacher);
	public List<Teacher> getAllteachers();
	public Teacher getTeacherById(Long id);
	public Teacher updateTeacher (Long id,Teacher updateTeacher);
	Boolean deleteTeacher(Long id);
	

}
