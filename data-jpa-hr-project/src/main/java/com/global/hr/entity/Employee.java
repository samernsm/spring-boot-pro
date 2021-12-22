package com.global.hr.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.util.ParallelSorter.Generator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Table(name = "hr_employees")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class   ,property = "id")
@NamedQuery(name = "Employee.findBySalary",query = "select emp from Employee emp where emp.salary >= :salary" )
public class Employee {

@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "emp_id")
private Long id;
@Column(name = "emp_name")
private String name;
private Double salary;

//@Autowired
//@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
@ManyToOne()
@JoinColumn(name = "department_id")
//@JsonIgnore
//@JsonBackReference
private Department department;





//@Autowired
//@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@OneToOne()
@JoinColumn(name  = "user_id")
//**
//@JsonBackReference
private User user;	

//@Version
//private Long version;

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
public Double getSalary() {
	return salary;
}
public void setSalary(Double salary) {
	this.salary = salary;
}

//@JsonBackReference
public Department getDepartment() {
	
	
	
	return department;
	
	
	
	
	//return obj.g;//(mapper.createObjectNode() ( JsonGenerator, department));
	
	 
}

public void setDepartment(Department department) {
	this.department = department;
}
//@JsonBackReference
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

}
