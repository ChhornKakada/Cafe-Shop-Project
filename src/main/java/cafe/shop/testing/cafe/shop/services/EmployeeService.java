
package cafe.shop.testing.cafe.shop.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cafe.shop.testing.cafe.shop.entities.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	Employee getById(Long id);

	Employee getByUsername(String username);

	void deleteViaId(Long id);

	Employee updateCashier(Long id, Employee newEmp, MultipartFile file);

	List<Employee> getAllCashiers();

	Employee addCashier(Employee emp);

	Employee save(MultipartFile file, Employee emp);
}
