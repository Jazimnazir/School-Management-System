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

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String age;
	private String qualification;
	private String addNumber;
	
	@OneToMany()
	@JoinColumn(name = "className_id")
	private List<ClassName> className;
	
	public Teacher() {
		
	}

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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getAddNumber() {
		return addNumber;
	}

	public void setAddNumber(String addNumber) {
		this.addNumber = addNumber;
	}

	public List<ClassName> getClassName() {
		return className;
	}

	public void setClassName(List<ClassName> className) {
		this.className = className;
	}


	
	
}
