package cafe.shop.testing.cafe.shop.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cafe.shop.testing.cafe.shop.entities.Role;
import cafe.shop.testing.cafe.shop.repositories.RoleRepository;
import cafe.shop.testing.cafe.shop.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
  private RoleRepository roleRepo;

  public RoleServiceImpl(RoleRepository roleRepo) {
    super();
    this.roleRepo = roleRepo;
  }

  @Override
  public List<Role> listAllRoles() {
    return roleRepo.findAll();
  }

  @Override
  public void save(Role role) {
    roleRepo.save(role);
  }

  @Override
  public Role getById(Long id) {
    Optional <Role> opt = roleRepo.findById(id);
    Role role = null;
    if (opt.isPresent()) {
      role = opt.get();
    } else {
      throw new RuntimeException(
        "role not found for id : " + id
      );
    }
    return role;
  }

  @Override
  public void deleteViaId(Long id) {
    roleRepo.deleteById(id);
  }
  
  
}
