package com.global.hr.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.hr.HRStatisticProjection;
import com.global.hr.entity.Employee;

@Repository
//public interface EmployeeRepo extends CrudRepository<Employee, Long> {
	public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    
	
	List<Employee> findBySalary(Double salary);
	
	
	List<Employee> findByName(String name);
	
	//List<Employee> findByNameContainingAndDepartmentNameContaining(String name);
	
	List<Employee> findByNameContainingAndDepartmentNameContaining(String empName,String deptName);
     
	Long countByNameContainingAndDepartmentNameContaining(String empName,String deptName);
    
	@Modifying(clearAutomatically = true,flushAutomatically = true)
	@Transactional
	Long deleteByNameContainingAndDepartmentNameContaining(String empName,String deptName);
	
	@Query(value = "select emp from Employee emp where  emp.name like :empName")
	List<Employee> filter(@Param("empName") String name,Sort sort);

	@Query(value = "select * from hr_employees emp where emp.emp_name like '%' + :empName  + '%'",nativeQuery = true)
	List<Employee> filterNative(@Param("empName") String name);

    List<Employee> findByDepartmentId(Long deptId); 

    @Query(value ="select emp from Employee emp join emp.department dept where dept.id = :deptId ")
    List<Employee> findByDepartment(Long deptId);

    @Query(value = "select (select count(*) from hr_departments) deptCount ,"
    		+ "(select count(*) from hr_employees) empCount,"
    		+ "(select count(*) from sec_user) userCount", nativeQuery = true)
    HRStatisticProjection getHRStatistic();
    
    
    //List<Employee> findAll();

}
