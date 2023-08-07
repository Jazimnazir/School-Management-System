package com.schoolmanagement.demo.service;

import java.util.List;

import com.schoolmanagement.demo.entity.Bus;
import com.schoolmanagement.demo.entity.Fee;
import com.schoolmanagement.demo.entity.Subject;

public interface SubjectService {
	public Subject saveSubject (Subject subject);
	public List<Subject> getAllSubjects();
	public Subject getSubjectById(Long id);
	public Subject updateSubject (Long id,Subject updateSubject);
	Boolean deleteSubject(Long id);
}
