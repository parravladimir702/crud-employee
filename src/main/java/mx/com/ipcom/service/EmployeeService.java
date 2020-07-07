package mx.com.ipcom.service;

import java.util.List;

import mx.com.ipcom.model.Employee;

public interface EmployeeService {
	Employee insertEmployee(Employee employee);
	Employee readActiveEmployee(Long id);
	List<Employee> readAllActiveEmployees();
	List<Employee> readAllEmployees();
	Employee updateEmployee(Employee employee);
	boolean deleteEmployee(Long id);
	void fillEmployeeList();

}
