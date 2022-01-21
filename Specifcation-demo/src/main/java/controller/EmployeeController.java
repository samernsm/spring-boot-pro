package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.sample.app.model.Employee;
//import com.sample.app.model.SearchQuery;
//import com.sample.app.service.EmployeeService;

import entity.Employees;
import io.swagger.annotations.ApiOperation;
import service.EmployeeService;
import util.SearchQuery;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@ApiOperation(value = "Employees Filter", notes = "Get employees by search criteria")
	@PostMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employees>> getEmployees(@RequestBody SearchQuery searchQuery) {

		List<Employees> emps = empService.findAll(searchQuery);

		return new ResponseEntity<>(emps, HttpStatus.OK);
	}

}
