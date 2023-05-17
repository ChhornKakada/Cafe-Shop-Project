package cafe.shop.testing.cafe.shop.login_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cafe.shop.testing.cafe.shop.entities.Employee;
import cafe.shop.testing.cafe.shop.repositories.EmployeeRepository;

public class CustomUserDetailsService implements UserDetailsService {
  
  @Autowired private EmployeeRepository empRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Employee emp = empRepo.findByUsername(username);
    if (emp == null) {
      throw new UsernameNotFoundException("No user found for the given username");
    }
    return new CustomUserDetails(emp);
  }

}
