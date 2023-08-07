package com.schoolmanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.demo.entity.Attendence;
@Repository
public interface AttendenceRepository extends JpaRepository<Attendence, Long>{

}
