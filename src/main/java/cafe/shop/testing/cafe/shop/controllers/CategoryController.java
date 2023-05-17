package cafe.shop.testing.cafe.shop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import cafe.shop.testing.cafe.shop.entities.Category;
import cafe.shop.testing.cafe.shop.services.CategoryService;


@RestController
@RequestMapping
public class CategoryController {

    @Autowired
    public CategoryService categoryService; 

    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories(); 
    }

    @PostMapping("/addNewCategory")
    public Category addNewCategory(Category category){
        category.setName("salala");
        return categoryService.addNewCategory(category); 
    }
    
    @GetMapping("/getCategoryById/{id}")
    public Category getCategoryById(@PathVariable("id") Long id){
        return categoryService.getCategoryById(id); 
    }

    @PutMapping("/updateCategoryById/{id}")
    public Category updateCategoryById(@PathVariable("id") Long id){
        Category category = new Category(); 
        category = getCategoryById(id); 
        category.setName("Bopha");
        return categoryService.updateCategoryById(category); 
    }
    @DeleteMapping("/deleteCategoryById/{id}")
    public void deleteSustenanceById(@PathVariable("id") Long id) {
        categoryService.deleteCategoryById(id); 
    }
}
