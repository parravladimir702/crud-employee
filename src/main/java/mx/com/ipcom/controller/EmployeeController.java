package mx.com.ipcom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.ipcom.model.Employee;
import mx.com.ipcom.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value="insertEmployee")
	public Employee insertEmployee(Employee employee) {
		return employeeService.insertEmployee(employee);
	}
	
	@GetMapping(value="getEmployee")
	public Employee getEmployee(Long id) {
		return employeeService.readActiveEmployee(id);
	}
	
	@GetMapping(value="getAllEmployees")
	public List<Employee> getAllEmployees(){
		return employeeService.readAllEmployees();
	}
	
	@GetMapping(value="getAllActiveEmployees")
	public List<Employee> getAllActiveEmployees(){
		return employeeService.readAllActiveEmployees();
	}
	@PutMapping(value="updateEmployee")
	public Employee updateEmployee(Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping(value="deleteEmployee")
	public Boolean deleteEmployee(Long id) {
		return employeeService.deleteEmployee(id);
	}
	
		

}
