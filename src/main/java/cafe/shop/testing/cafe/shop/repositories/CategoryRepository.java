package cafe.shop.testing.cafe.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cafe.shop.testing.cafe.shop.entities.Category;



public interface CategoryRepository extends JpaRepository<Category, Long>{

}
