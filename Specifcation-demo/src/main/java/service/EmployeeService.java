package service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Component;

import entity.Employees;
import entity.SearchQuery;
import repository.EmployeeRepository;
import com.smaple.app.jpa.specification.SpecificationUtil;



@Component
public class EmployeeService {
 
	private EmployeeRepository employeeRepository;
	
	public List<Employees> findAll(SearchQuery searchQuery){
		Specification<Employees> spec =  SpecificationU
		
		
		
		return ;
		
	}


}
