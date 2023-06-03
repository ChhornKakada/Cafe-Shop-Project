package cafe.shop.testing.cafe.shop.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.shop.testing.cafe.shop.entities.Category;
import cafe.shop.testing.cafe.shop.repositories.CategoryRepository;
import cafe.shop.testing.cafe.shop.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        super(); 
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // @Override
    // public Category save(Category category) {
    //     return categoryRepository.save(category);
    // }   

    // new category 
    @Override
    public Category save(Category newCategory){
        Category category = new Category(); 

        category.setName(newCategory.getName());

        return categoryRepository.save(newCategory); 
    }

    // get by id 
    @Override
    public Category getById(Long id) {
        Optional <Category> opt = categoryRepository.findById(id);
        Category category = null;
        if (opt.isPresent()) {
        category = opt.get();
        } else {
        throw new RuntimeException(
            "category not found for id : " + id
        );
        }
        return category;
    }

    // delete

    @Override
    public void deleteViaId(Long id) {
        categoryRepository.deleteById(id);
    }

    // Update category
    @Override
    public Category updateCategory(Long id, Category newCategory){
        Category existCategory = new Category(); 
        existCategory = categoryRepository.findById(id).get(); 
        
        existCategory.setName(newCategory.getName());

        return categoryRepository.save(existCategory); 
    }
}
