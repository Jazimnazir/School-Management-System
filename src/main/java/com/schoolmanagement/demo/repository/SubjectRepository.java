package com.schoolmanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmanagement.demo.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
