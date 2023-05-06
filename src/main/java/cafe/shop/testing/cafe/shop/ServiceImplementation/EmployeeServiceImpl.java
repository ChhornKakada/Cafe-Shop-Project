package cafe.shop.testing.cafe.shop.ServiceImplementation;

import java.util.List;
import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.shop.testing.cafe.shop.entities.Employee;
import cafe.shop.testing.cafe.shop.repositories.EmployeeRepository;
import cafe.shop.testing.cafe.shop.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  // @Autowired
  private EmployeeRepository empRepo;


  public EmployeeServiceImpl(EmployeeRepository empRepo) {
    super();
    this.empRepo = empRepo;
  }

  @Override
  public List<Employee> getAllEmployees() {
    return empRepo.findAll();
  }

  @Override
  public void save(Employee emp) {
    empRepo.save(emp);
  }

  @Override
  public Employee getById(Long id) {
    Optional<Employee> optional = empRepo.findById(id);
    Employee user = null;
    if (optional.isPresent())
      user = optional.get();
    else
      throw new RuntimeException(
          "Employee not found for id : " + id);
    return user;
  }

  @Override
  public void deleteViaId(Long id) {
    empRepo.deleteById(id);
  }

  @Override
  public Employee getByUsername(String username) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getByUsername'");
  }

}
