package mx.com.ipcom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mx.com.ipcom.service.EmployeeService;


@SpringBootApplication
@EnableAutoConfiguration
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);

	}

	@Bean
	public CommandLineRunner fillEmployees(EmployeeService employeeService) {
		System.out.println("filling employees...");
		return (args) -> {
			employeeService.fillEmployeeList();
		};
	}
}
