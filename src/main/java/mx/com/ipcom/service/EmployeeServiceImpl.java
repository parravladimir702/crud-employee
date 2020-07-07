package mx.com.ipcom.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.ipcom.model.Employee;
import mx.com.ipcom.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee insertEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee readActiveEmployee(Long id) {
		return employeeRepository.findOne(id);
	}

	public List<Employee> readAllActiveEmployees() {
		List<Employee> listEmployee = new ArrayList<Employee>();
		employeeRepository.findAllActive().iterator().forEachRemaining(listEmployee::add);
		return listEmployee;
	}

	public List<Employee> readAllEmployees() {
		List<Employee> listEmployee = new ArrayList<Employee>();
		employeeRepository.findAll().iterator().forEachRemaining(listEmployee::add);
		return listEmployee;
	}


	public Employee updateEmployee(Employee employee) {
		System.out.println(employee.getId() + " " + employee.getFirstName());
		Employee emp = employeeRepository.findOne(employee.getId());
		System.out.println(emp);
		if(emp!=null) {
			System.out.println("Not null, updating employee");
			emp.setDateOfBirth(employee.getDateOfBirth());
			emp.setDateOfEmployment(employee.getDateOfEmployment());
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setMiddleInitial(employee.getMiddleInitial());
			emp.setStatus(employee.getStatus());
			return employeeRepository.save(emp);
		}
		return null;
	}

	public boolean deleteEmployee(Long id) {
		Employee employee = employeeRepository.findOne(id);
		if(employee!= null) {
			employee.setStatus("INACTIVE");
			employeeRepository.save(employee);
			return true;			
		} else return false;
	}

	@Override
	public void fillEmployeeList() {
		try {
		BufferedReader csvReader = new BufferedReader(new FileReader("employees.csv"));
		String row;
		while ((row = csvReader.readLine()) != null) {
		    String[] data = row.split(",");
		    Employee employee = new Employee();
		    employee.setFirstName(data[0]);
		    employee.setMiddleInitial(data[1]);
		    employee.setLastName(data[2]);
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		    employee.setDateOfBirth(format.parse(data[3]));
		    employee.setDateOfEmployment(format.parse(data[4]));
		    employee.setStatus("ACTIVE");
		    employeeRepository.save(employee);
		}
		csvReader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}



}
