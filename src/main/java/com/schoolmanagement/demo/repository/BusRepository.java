package com.schoolmanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.demo.entity.Bus;
import com.schoolmanagement.demo.entity.Student;
@Repository
public interface BusRepository extends JpaRepository<Bus,Long>{
	@Query("Select s from Bus s where s.busNumber=:busNumber")
	Bus findByBusNumber(@Param("busNumber") Long busNumber);

}
