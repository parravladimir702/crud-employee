package mx.com.ipcom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mx.com.ipcom.model.*;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Override
	@Query("FROM Employee e WHERE e.id=?1 AND e.status ='ACTIVE'")
	public Employee findOne(Long id);
	
	@Query("FROM Employee e WHERE e.status ='ACTIVE'")
	public List<Employee> findAllActive();
}
