package cafe.shop.testing.cafe.shop.ServiceImplementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import cafe.shop.testing.cafe.shop.entities.Employee;
import cafe.shop.testing.cafe.shop.entities.Role;
import cafe.shop.testing.cafe.shop.repositories.EmployeeRepository;
import cafe.shop.testing.cafe.shop.repositories.RoleRepository;
import cafe.shop.testing.cafe.shop.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  // @Autowired
  private EmployeeRepository empRepo;

  @Autowired
  private RoleRepository roleRepo;


  public EmployeeServiceImpl(EmployeeRepository empRepo) {
    super();
    this.empRepo = empRepo;
  }

  @Override
  public List<Employee> getAllEmployees() {
    return empRepo.findAll();
  }

  // save new studetn
  @Override
  public void save(MultipartFile file, Employee emp) {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    if (fileName.contains("..")) {
      System.out.println("not a valid file");
    }
    try { 
      emp.setImg(Base64.getEncoder().encodeToString(file.getBytes()));
    } catch(IOException e) {
      e.printStackTrace();
    }
    Calendar currentDate = Calendar.getInstance();
    java.util.Date dateUtil = currentDate.getTime();
    emp.setHiredDate(new java.sql.Date(dateUtil.getTime()));
    emp.setRole(roleRepo.findById(2l).get());
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

  @Override
  public Employee addCashier(Employee emp) {
    Role role = new Role();
    role = roleRepo.findById(2l).get();
    emp.setRole(role);
    return empRepo.save(emp);
  }

  @Override
  public List<Employee> getAllCashiers() {
    List<Employee> employees = new ArrayList<>();
    employees = empRepo.findAll();

    List<Employee> cashiers = new ArrayList<>();
    for (var emp : employees) {
      if (emp.getRole().getType().equals("Cashier"))
        cashiers.add(emp);
    }
    return cashiers;
  }

  // update cashier
  @Override
  public Employee updateCashier(Long id, Employee newEmp, MultipartFile file) {
    Employee existEmp = new Employee();
    existEmp = empRepo.findById(id).get();
    existEmp.setDob(newEmp.getDob());
    existEmp.setImg(newEmp.getImg());
    existEmp.setName(newEmp.getName());
    existEmp.setSex(newEmp.getSex());
    existEmp.setPassword(newEmp.getPassword());
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    if (fileName.contains("..")) {
      System.out.println("not a valid file");
    }
    try { 
      existEmp.setImg(Base64.getEncoder().encodeToString(file.getBytes()));
    } catch(IOException e) {
      e.printStackTrace();
    }
    return empRepo.save(existEmp);
  }

}
