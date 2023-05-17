package cafe.shop.testing.cafe.shop.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cafe.shop.testing.cafe.shop.entities.Employee;
import cafe.shop.testing.cafe.shop.services.EmployeeService;

@Controller
public class cashierController {

  private EmployeeService empService;

  public cashierController(EmployeeService empService) {
    super();
    this.empService = empService;
  }

  @GetMapping("/admin/cashier")
  public String listStudents(Model model) {
    Employee emp = new Employee();
    model.addAttribute("employeeList", empService.getAllCashiers());
    model.addAttribute("employee", emp);
    return "admin/cashier";
  }

  // save new cashier
  @PostMapping("/admin/cashier/new")
  public String addNewCashier(@RequestParam("file") MultipartFile file,
                              @ModelAttribute("employee") Employee emp) {
    empService.save(file, emp);
    return "redirect:/admin/cashier";
  }

  // Delete cashier by ID
  @GetMapping("/admin/cashier/{id}")
  public String deleteCashier(@PathVariable Long id) {
    empService.deleteViaId(id);
    return "redirect:/admin/cashier";
  }

  @GetMapping("/admin/cashier/update/{id}")
  public String updateCashier(@PathVariable Long id, Model model) {
    Employee emp = new Employee();
    emp = empService.getById(id);
    model.addAttribute("employeeList", empService.getAllCashiers());
    model.addAttribute("cashier", emp);
    return "admin/edit_InforDatail/edit_cashier";
  }

  // update cashier
  @PostMapping("admin/cashier/update/{id}")
  public String updateCashierVieId(@PathVariable Long id, @RequestParam("file") MultipartFile file,
                                   @ModelAttribute("cashier") Employee cashier) {
    empService.updateCashier(id, cashier, file);
    return "redirect:/admin/cashier";
  }


}
