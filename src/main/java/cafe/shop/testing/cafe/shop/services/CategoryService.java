// package cafe.shop.testing.cafe.shop.services;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import cafe.shop.testing.cafe.shop.entities.Category;
// import cafe.shop.testing.cafe.shop.repositories.CategoryRepository;

// @Service
// public class CategoryService {

//     @Autowired
//     public CategoryRepository categoryRepository; 


//     public List<Category> getAllCategories(){
//         return categoryRepository.findAll(); 
//     }

//     public Category addNewCategory(Category category){
//         return categoryRepository.save(category); 
//     }

//     public Category getCategoryById(Long id){
//         return categoryRepository.getCategoryById(id);
//     }

//     public Category updateCategoryById(Category category){
//         return categoryRepository.save(category); 
//     }

//     public void deleteCategoryById(Long id){
//         categoryRepository.deleteById(id);
        
//     }
// }
