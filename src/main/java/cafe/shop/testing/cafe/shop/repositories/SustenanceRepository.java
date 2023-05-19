package cafe.shop.testing.cafe.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cafe.shop.testing.cafe.shop.entities.Sustenance;

@Repository
public interface SustenanceRepository extends JpaRepository<Sustenance, Long>{

    Sustenance findByName(String name);
}
