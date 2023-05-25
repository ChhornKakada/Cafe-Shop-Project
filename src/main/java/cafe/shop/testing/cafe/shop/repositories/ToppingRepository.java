package cafe.shop.testing.cafe.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cafe.shop.testing.cafe.shop.entities.Topping;

public interface ToppingRepository extends JpaRepository <Topping, Long> {
  
}
