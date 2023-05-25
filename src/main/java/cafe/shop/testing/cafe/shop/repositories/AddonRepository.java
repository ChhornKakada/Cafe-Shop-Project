package cafe.shop.testing.cafe.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cafe.shop.testing.cafe.shop.entities.Addon;

public interface AddonRepository extends JpaRepository <Addon, Long> {
  
}
