package cafe.shop.testing.cafe.shop.services;

import java.util.List;

import cafe.shop.testing.cafe.shop.entities.Role;

public interface RoleService {
  List <Role> listAllRoles();
  void save(Role role);
  Role getById(Long i);
  void deleteViaId(Long id);
}
