package com.schoolmanagement.demo.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.demo.entity.ClassName;
import com.schoolmanagement.demo.repository.ClassNameRepositery;
@Service
public class ClassNameServiceImpl implements ClassNameService {

	@Autowired
	private ClassNameRepositery classNameRepositery;
	
	
	
	
	@Override
	public ClassName saveClassName(ClassName className) {
		
		return classNameRepositery.save(className) ;
	}




	@Override
	public List<ClassName> getAllClassNames() {
		
		return classNameRepositery.findAll();
	}




	@Override
	public ClassName getClassNameById(Long id) {
		ClassName className=classNameRepositery.findById(id).get();
		return className;
	}




	@Override
	public ClassName updateClassName(Long id, ClassName updateClassname) {
		return classNameRepositery.save(updateClassname);
	}




	@Override
	public Boolean deleteClassName(Long id) {
		Optional<ClassName>className=classNameRepositery.findById(id);
		if(className.isPresent()) {
			classNameRepositery.deleteById(id);
			return true;
		}
		return false;
	}
	
	
	
	
}
