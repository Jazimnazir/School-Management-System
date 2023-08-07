package com.schoolmanagement.demo.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.demo.entity.Fee;

@Repository
public interface FeeRepository extends JpaRepository<Fee,Long> {
	
	@Query("SELECT d FROM Fee d WHERE MONTH(d.paymentDate)=:month AND YEAR(d.paymentDate)=:year")
	List<Fee> existsByPaymentDate(@Param("month") int month,@Param("year")int year);

	
	

}
