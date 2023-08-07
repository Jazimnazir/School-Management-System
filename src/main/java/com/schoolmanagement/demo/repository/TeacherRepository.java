package com.schoolmanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.demo.entity.Teacher;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
