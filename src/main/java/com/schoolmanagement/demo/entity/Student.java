package com.schoolmanagement.demo.entity;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String grade;
	private String address;
	private String phoneNumber;
	private String rollNumber;
	
	
	@ManyToOne
	@JoinColumn(name = "bus_id")
	@JsonIgnore
	private Bus bus;
	
	@ManyToOne
	@JoinColumn(name = "className_id")
	@JsonIgnore
	private ClassName className;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public ClassName getClassName() {
		return className;
	}

	public void setClassName(ClassName className) {
		this.className = className;
	}
	
	
	
	


}	