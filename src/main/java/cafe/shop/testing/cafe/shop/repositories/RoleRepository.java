package cafe.shop.testing.cafe.shop.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import cafe.shop.testing.cafe.shop.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {
  
}
