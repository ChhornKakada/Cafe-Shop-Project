
package cafe.shop.testing.cafe.shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.shop.testing.cafe.shop.entities.Employee;
import cafe.shop.testing.cafe.shop.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	public EmployeeRepository employeeRepository; 


	// Nimith 

	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll(); 
	}
}
