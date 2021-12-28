package repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import entity.Employees;

public interface EmployeeRepository  extends JpaSpecificationExecutor<Employees>,PagingAndSortingRepository<Employees, Long>{

	
	
	
}
