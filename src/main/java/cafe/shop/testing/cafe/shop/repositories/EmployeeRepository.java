package cafe.shop.testing.cafe.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cafe.shop.testing.cafe.shop.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {

  Employee findByUsername(String username);
  
}
