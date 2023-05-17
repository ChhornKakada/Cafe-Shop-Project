package cafe.shop.testing.cafe.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cafe.shop.testing.cafe.shop.entities.Sustenance;

public interface SustenanceRepository extends JpaRepository<Sustenance, Long>{
    Sustenance getSustenanceById(Long id); 
    Sustenance save(Sustenance tables);

}
