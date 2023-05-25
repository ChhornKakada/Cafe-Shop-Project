package cafe.shop.testing.cafe.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cafe.shop.testing.cafe.shop.entities.Size;

public interface SizeRepository extends JpaRepository <Size, Long> {
  
}
