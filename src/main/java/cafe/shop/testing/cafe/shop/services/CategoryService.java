
package cafe.shop.testing.cafe.shop.services;

import java.util.List;


import cafe.shop.testing.cafe.shop.entities.Category;

public interface CategoryService {
	List<Category> getAllCategories();

	Category getById(Long id);

	// Category getByUsername(String username);

	void deleteViaId(Long id);

	// Category updateCategory(Long id, Category newEmp, MultipartFile file);

	// List<Category> getAllCategory();

	// Category addCategory(Category category);

	Category save(Category category);

    Category updateCategory(Long id, Category category); 
}
