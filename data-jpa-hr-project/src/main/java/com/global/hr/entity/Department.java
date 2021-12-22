package com.global.hr.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;

@Entity
@Table(name = "hr_departments")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class   ,property = "id")
public class Department {


	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
//@GeneratedValue(strategy = GenerationType.TABLE,generator = "department_gen")
//@TableGenerator(name = "department_gen",table = "department_seq",allocationSize = 1,initialValue = 20)

private Long id;

private String name;

//@Autowired
@OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
//@JsonManagedReference
@JsonIgnore
private List<Employee> employee;


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
//@JsonManagedReference
public List<Employee> getEmployee() {
	return employee;
}

public void setEmployee(List<Employee> employee) {
	this.employee = employee;
}

/*
 * public List<Employee> getEmployee() { return employee; }
 * 
 * public void setEmployee(List<Employee> employee) { this.employee = employee;
 * }
 */
	
	
}
