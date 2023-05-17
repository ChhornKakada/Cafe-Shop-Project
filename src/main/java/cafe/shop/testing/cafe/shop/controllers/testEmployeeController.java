package cafe.shop.testing.cafe.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cafe.shop.testing.cafe.shop.entities.Employee;
import cafe.shop.testing.cafe.shop.entities.Role;
import cafe.shop.testing.cafe.shop.repositories.EmployeeRepository;
import cafe.shop.testing.cafe.shop.repositories.RoleRepository;
import cafe.shop.testing.cafe.shop.services.EmployeeService;

@RestController
@RequestMapping("/cashier")
public class testEmployeeController {

  @Autowired private RoleRepository roleRepo;
  @Autowired private EmployeeRepository empRepo;
  @Autowired private EmployeeService empService;

  @PostMapping("/new")
  public Employee addNewCashier(@RequestBody Employee emp) {
    return empService.addCashier(emp);
  }
}
