package cafe.shop.testing.cafe.shop.repositories;

import org.hibernate.mapping.Table;
import org.springframework.boot.actuate.autoconfigure.health.HealthProperties.Status;
import org.springframework.data.jpa.repository.JpaRepository;


import cafe.shop.testing.cafe.shop.entities.Tables;

public interface TableRepository extends JpaRepository<Tables, Long>{
    Tables getTableById(Long id); 
    Tables save(Tables tables);

}
