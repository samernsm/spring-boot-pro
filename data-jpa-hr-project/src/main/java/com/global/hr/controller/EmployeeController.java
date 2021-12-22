package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.HRStatisticProjection;
import com.global.hr.entity.Employee;
import com.global.hr.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
    EmployeeService employeeService;
	
	
	  @GetMapping("/{id}") 
	  public EmployeeResponse findById(@PathVariable Long id)
	  {
	  
	  Employee emp = employeeService.findById(id); 
	  EmployeeResponse res = new  EmployeeResponse();
	  
	  res.setId(emp.getId()); 
	  res.setName(emp.getName());
	  res.setDepartment(emp.getDepartment()); res.setUser(emp.getUser());
	  
	  return res; }
	 
	  @GetMapping("/emp-dept")
	  public List<Employee> findByEmpAndDept(@RequestParam String empName,@RequestParam String deptName){
			return employeeService.findByEmpAndDept(empName,deptName);
		}
    
	  @GetMapping("/count-emp-dept")
	  public ResponseEntity<Long>  countByEmpAndDept(String empName,String deptName){
			return  ResponseEntity.ok(employeeService.countByEmpAndDept(empName,deptName));
		}
	  
	  @DeleteMapping("/emp-dept")
	  public ResponseEntity<Long>  deleteByEmpAndDept(String empName,String deptName){
			return  ResponseEntity.ok(employeeService.deleteByEmpAndDept(empName,deptName));
		}
	  
	  
	  /*
	 * @GetMapping("/{id}") public Employee findById(@PathVariable Long id) {
	 * 
	 * return employeeService.findById(id);
	 * 
	 * 
	 * 
	 * }
	 */
	
	@GetMapping("/filter")
    public List<Employee> filter(@RequestParam String name){
    	return employeeService.filter(name);
    }

    @PostMapping()
    public Employee insert(@RequestBody Employee emp) {
    	return employeeService.insert(emp);
    }

    @PostMapping("/insertEmp")
    public String insertEmp(@RequestBody Employee emp) {
    	Employee empTest = employeeService.insert(emp); 
    	return "good employee no :"+empTest.getId().toString();
    }
    
    
    
    @PutMapping()
    public Employee update(@RequestBody Employee emp) {
    	    	
    	return employeeService.update(emp);
    }    
    
    @GetMapping("/department/{deptId}")
    public List<Employee> findByDepartmentId(@PathVariable Long deptId){
    	return employeeService.findByDepartmentId(deptId); 
    }
    
    
	/*
	 * @GetMapping() public List<Employee> findAll(@RequestParam Direction
	 * dir,@RequestParam String sortCol){ return
	 * employeeService.findAll(dir,sortCol); }
	 */
    @GetMapping()
    public  ResponseEntity<?> findAll(int pageNum,int pageSize,Direction  dir,String sortCol){
    	
    	 
    	return  ResponseEntity.ok(employeeService.findAll(pageNum,pageSize,dir,sortCol));
    }
    
    
    
    
    @GetMapping("/name")
    public List<Employee> findByName(@RequestParam String name){
		return employeeService.findByName(name);
	}
    
    @GetMapping("/salary")
    public ResponseEntity<?> findBySalary(@RequestParam Double salary){
    return ResponseEntity.ok(employeeService.findBySalary(salary));	
    }
    
    
    @GetMapping("/statistic")
    public  ResponseEntity<?> getHRStatistic() {
    	return ResponseEntity.ok(employeeService.getHRStatistic());
    	}
}

