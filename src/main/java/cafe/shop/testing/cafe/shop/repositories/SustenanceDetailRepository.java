package cafe.shop.testing.cafe.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cafe.shop.testing.cafe.shop.entities.SustenanceDetail;

public interface SustenanceDetailRepository extends JpaRepository <SustenanceDetail, Long> {
  
}
