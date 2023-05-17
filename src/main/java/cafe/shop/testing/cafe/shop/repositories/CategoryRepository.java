package cafe.shop.testing.cafe.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cafe.shop.testing.cafe.shop.entities.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    Category getCategoryById(Long id); 
}
