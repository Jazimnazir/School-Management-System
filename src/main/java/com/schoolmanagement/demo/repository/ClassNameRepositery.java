package com.schoolmanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.demo.entity.ClassName;

@Repository
public interface ClassNameRepositery extends JpaRepository<ClassName, Long>{
	

}
