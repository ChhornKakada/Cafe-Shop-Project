package cafe.shop.testing.cafe.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cafe.shop.testing.cafe.shop.entities.Type; 

public interface TypeRepository extends JpaRepository<Type, Long>{
    // List<Type> findBySustenance(Sustenance sustenance); 
}
