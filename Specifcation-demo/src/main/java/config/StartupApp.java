package config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import com.sample.app.model.Employees;
//import com.sample.app.model.Hobby;
//import com.sample.app.repository.EmployeesRepository;
//import com.sample.app.service.EmployeesService;

import entity.Employees;
import entity.Hobby;
import repository.EmployeeRepository;
import service.EmployeeService;

@SpringBootApplication
public class StartupApp {

	public static void main(String args[]) {
		SpringApplication.run(StartupApp.class, args);
	}

	@Bean
	public CommandLineRunner demo(EmployeeRepository employeeRepository, EmployeeService empService) {
		return (args) -> {

			Hobby hobby1 = new Hobby("Cricket");
			Hobby hobby2 = new Hobby("Blogging");
			Hobby hobby3 = new Hobby("Football");
			Hobby hobby4 = new Hobby("Tennis");
			Hobby hobby5 = new Hobby("Blogging");
			Hobby hobby6 = new Hobby("Cricket");
			Hobby hobby7 = new Hobby("Blogging");
			Hobby hobby8 = new Hobby("Cricket");
			

			Set<Hobby> hobbies1 = new HashSet<>();
			hobbies1.add(hobby1);
			hobbies1.add(hobby2);

			Set<Hobby> hobbies2 = new HashSet<>();
			hobbies2.add(hobby3);
			hobbies2.add(hobby4);

			Set<Hobby> hobbies3 = new HashSet<>();
			hobbies3.add(hobby5);
			hobbies3.add(hobby6);
			
			Set<Hobby> hobbies4 = new HashSet<>();
			hobbies4.add(hobby7);
			hobbies4.add(hobby8);

			Employees emp1 = new Employees(null,"Ram", "Gurram", 32, hobbies1);
			Employees emp2 = new Employees(null,"Gopi", "Battu", 30, hobbies2);
			Employees emp3 = new Employees(null,"Surendra", "Sami", 32, hobbies3);
			Employees emp4 = new Employees(null,"Sai", "Praneet", 30, hobbies4);
			Employees emp5 = new Employees(null,"Sailu", "PTR", 31, null);

			empService.save(emp1);
			empService.save(emp2);
			empService.save(emp3);
			empService.save(emp4);
			empService.save(emp5);

			for (Employees emp : employeeRepository.findAll()) {
				System.out.println(emp);
			}

		};
	}
}