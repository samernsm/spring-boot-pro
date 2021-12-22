package com.global.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Department;
import com.global.hr.entity.Employee;

@Repository
//public interface EmployeeRepo extends CrudRepository<Employee, Long> {
	public interface DepartmentRepo extends JpaRepository<Department, Long> {
    
	

}
