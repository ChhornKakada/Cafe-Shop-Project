package cafe.shop.testing.cafe.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cafe.shop.testing.cafe.shop.services.EmployeeService;


@Controller
public class EmployeeController {

  // @Autowired
  private EmployeeService empService;

  public EmployeeController(EmployeeService empService) {
    super();
    this.empService = empService;
  }


  @GetMapping("/showEmployees")
  public String listUsers(Model model){
    model.addAttribute("employees", empService.getAllEmployees());
    return "listEmployees";
  }

  // @GetMapping("/showUsers")
  // public String showUsers(Model model){
  // User user = new User();
  // model.addAttribute("users", user);
  // return "listUsers";
  // }

  // @GetMapping("/new_drink")
  // public String listCategory(Model model){
  // User user = new User();
  // model.addAttribute("users", categoryService.getAllCategories());
  // model.addAttribute("drink", drink);
  // return "addNewDrink";
  // }

  // @GetMapping("/showUsers")
  // public String showUsers(Model model) {
  //   model.addAttribute("users", userServiceImpl.getAllUsers());
  //   return "listUsers";
  // }

}
