package com.schoolmanagement.demo.service;

import java.util.List;

import com.schoolmanagement.demo.entity.ClassName;

public interface ClassNameService {
	
	public ClassName saveClassName (ClassName className);
	public List<ClassName> getAllClassNames();
	public ClassName getClassNameById(Long id);
	public ClassName updateClassName (Long id,ClassName updateClassname);
	Boolean deleteClassName(Long id);
}
