package cafe.shop.testing.cafe.shop.controllers.admin;

import java.util.ArrayList;
import java.util.List;

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
  public String listCashier(Model model) {
    List <Employee> employeeList = new ArrayList<>();
    employeeList = empService.getAllCashiers();
    model.addAttribute("employeeList", employeeList);
    // cashierDetail is for showing cashier info by Id
    model.addAttribute("cashierDetail", employeeList.get(0));
    // newCashier is a object for adding new cashier
    model.addAttribute("newCashier", new Employee());
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
    model.addAttribute("cashierDetail", empService.getById(id));
    model.addAttribute("cashier", emp);
    return "admin/edit_InforDatail/edit_cashier";
  }

  // update cashier
  @PostMapping("admin/cashier/update/{id}")
  public String updateCashierVieId(@PathVariable Long id, @RequestParam("file") MultipartFile file,
                                   @ModelAttribute("cashier") Employee cashier) {
    empService.updateCashier(id, cashier, file);
    return "redirect:/admin/cashier/view/{id}";
  }

  // view cashier detail
  @GetMapping("admin/cashier/view/{id}")
  public String viewCashierDetail(@PathVariable Long id, Model model) {
    // for listing all cashiers
    model.addAttribute("employeeList", empService.getAllCashiers());
    // cashierDetail is for showing cashier info by Id
    model.addAttribute("cashierDetail", empService.getById(id));
    // newCashier is a object for adding new cashier
    model.addAttribute("newCashier", new Employee());
    return "admin/cashier";
  }

}
