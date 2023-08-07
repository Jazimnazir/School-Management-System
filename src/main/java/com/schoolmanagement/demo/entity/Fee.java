package com.schoolmanagement.demo.entity;



import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Fee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double amount;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate paymentDate;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	@JsonIgnore
	private Student student;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Double getAmount() {
		return amount;
	}



	public void setAmount(Double amount) {
		this.amount = amount;
	}



	



	public LocalDate getPaymentDate() {
		return paymentDate;
	}



	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}



	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	@Override
	public String toString() {
		return "Fee [id=" + id + ", amount=" + amount + ", paymentDate=" + paymentDate + ", student=" + student + "]";
	}
	
	

	
	
	

}
