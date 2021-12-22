package com.global.hr.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import org.springframework.stereotype.Service;
//import org.springframework.data.domain.Sort;
import com.global.hr.HRStatisticProjection;
import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;

@Service
public class EmployeeService {
  
	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	DepartmentService departmentService;
	
    //**
	@Autowired
    UserService userService;
	   
public Employee findById(Long id) {
		return employeeRepo.findById(id).orElseThrow();
}


  public List<Employee> findByName(String name){ return
  employeeRepo.findByName(name); }
 

public List<Employee> findByEmpAndDept(String empName,String deptName){
	return employeeRepo.findByNameContainingAndDepartmentNameContaining(empName,deptName);
}

public Long countByEmpAndDept(String empName,String deptName){
	return employeeRepo.countByNameContainingAndDepartmentNameContaining(empName,deptName);
}

public Long deleteByEmpAndDept(String empName,String deptName){
	return employeeRepo.deleteByNameContainingAndDepartmentNameContaining(empName,deptName);
}


public List<Employee> filter(String name){
	
	//if(name.isEmpty() || name.isBlank() || name == null) {
		//name = null;
	//}
	
	
	return employeeRepo.filter(name,Sort.by("emp.name"));
}


public Employee insert(Employee emp) {
	
	if(emp.getDepartment() != null && emp.getDepartment().getId() != null) {
	    emp.setDepartment(departmentService.findById(emp.getDepartment().getId())); 	
	    //**add usr data
	   // emp.setUser(userService.findById(emp.getUser().getId() ));
	}
	
	
	return employeeRepo.save(emp);
}

public Employee update(Employee emp) {
	Employee current = employeeRepo.findById(emp.getId()).orElseThrow();
	current.setName(emp.getName());
	current.setSalary(emp.getSalary());
	current.setDepartment(emp.getDepartment());
	
	return employeeRepo.save(current);
}

/*
 * public List<Employee> findByDepartmentId(Long deptId){ return
 * employeeRepo.findByDepartmentId(deptId); }
 */

public List<Employee> findByDepartmentId(Long deptId){
	return employeeRepo.findByDepartment(deptId); 
}

public Page<Employee> findAll(int pageNum,int pageSize,Direction  dir,String sortCol){
	       // List<Order>  orders = new ArrayList<Order>();
          	//Order order1 = new Order(Sort.Direction.ASC,"name");
  	
	Pageable pg = PageRequest.of(pageNum, pageSize, Sort.by(dir,sortCol)); 
	return employeeRepo.findAll(pg);
}

public List<Employee> findBySalary(Double salary){
return  employeeRepo.findBySalary(salary);	
}


public HRStatisticProjection getHRStatistic() {
return employeeRepo.getHRStatistic();
}
}
