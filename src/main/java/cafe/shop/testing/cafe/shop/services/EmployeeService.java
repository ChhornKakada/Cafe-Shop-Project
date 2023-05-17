
package cafe.shop.testing.cafe.shop.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cafe.shop.testing.cafe.shop.entities.Employee;


public interface EmployeeService {
	List<Employee> getAllEmployees();
	void save(Employee emp);
	Employee getById(Long id);
	Employee getByUsername(String username);
	void deleteViaId(Long id);
}
