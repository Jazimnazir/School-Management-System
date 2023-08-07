package com.schoolmanagement.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.demo.entity.Bus;
import com.schoolmanagement.demo.entity.Fee;
import com.schoolmanagement.demo.entity.Subject;
import com.schoolmanagement.demo.repository.SubjectRepository;
@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public Subject saveSubject(Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepository.save(subject);
	}

	@Override
	public List<Subject> getAllSubjects() {
		// TODO Auto-generated method stub
		return subjectRepository.findAll();
	}

	@Override
	public Subject getSubjectById(Long id) {
		// TODO Auto-generated method stub
		Subject subject=subjectRepository.findById(id).get();
		return subject;
	}

	@Override
	public Subject updateSubject(Long id, Subject updateSubject) {
		// TODO Auto-generated method stub
		return subjectRepository.save(updateSubject);
	}

	@Override
	public Boolean deleteSubject(Long id) {
		// TODO Auto-generated method stub
		Optional<Subject>student=subjectRepository.findById(id);
		if(student.isPresent()) {
			subjectRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
