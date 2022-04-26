package com.endava.internship;

import com.endava.internship.domain.Department;
import com.endava.internship.domain.Employee;
import com.endava.internship.repository.DepartmentRepository;
import com.endava.internship.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class WebApplicationHomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplicationHomeworkApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
		return (args -> {
			Department department = new Department("dept", "Chisinau");
			departmentRepository.save(department);
			Employee employee = new Employee("alex", "lastnamed",
					"a@b", "111-111", BigDecimal.valueOf(2.34), department);
			employeeRepository.save(employee);
			Thread.sleep(1000);
		});
	}
}
