package cafe.shop.testing.cafe.shop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import cafe.shop.testing.cafe.shop.entities.Employee;
import cafe.shop.testing.cafe.shop.services.EmployeeService;


@Controller
public class EmployeeController {

  @Autowired
  public EmployeeService employeeService;


  @GetMapping("/getAllEmployees")
  public List<Employee> getAllEmployees(){
    return employeeService.getAllEmployees(); 
  }

}
