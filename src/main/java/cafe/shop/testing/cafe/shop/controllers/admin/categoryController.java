package cafe.shop.testing.cafe.shop.controllers.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cafe.shop.testing.cafe.shop.entities.Category;
import cafe.shop.testing.cafe.shop.services.CategoryService;

@Controller
public class categoryController {

  private CategoryService categoryService; 

  public categoryController(CategoryService categoryService) {
    super(); 
    this.categoryService = categoryService; 
  }
  
  @GetMapping(path = "/admin/category")
  public String listCategory(Model model) {
    List<Category> categoryList = categoryService.getAllCategories();
    model.addAttribute("categoryList", categoryList);
    // model.addAttribute("newCategory", new Category());
    model.addAttribute("cashierDetail", categoryList.get(0));
    // newCashier is a object for adding new cashier
    model.addAttribute("newCategory", new Category());
    return "admin/category";
  }

  @PostMapping("/admin/category/new")
  public String addNewCategory(Category newCategory){
    categoryService.save(newCategory); 

    return "redirect:/admin/category"; 
  }

  // update category 
  @GetMapping("/admin/category/update/{id}")
  public String updateCategory(@PathVariable Long id, Model model){
    Category category = new Category(); 
    category = categoryService.getById(id); 

    model.addAttribute("categoryList", categoryService.getAllCategories()); 
    // model.addAttribute(null, categoryService.getById(id)); 
    model.addAttribute("category", category);

    return "admin/edit_InforDatail/edit_category";
  }

  @PostMapping("admin/category/update/{id}")
  public String updateCashierVieId(@PathVariable Long id,
                                   @ModelAttribute("category") Category category) {
    categoryService.updateCategory(id, category);
    return "redirect:/admin/category/view/{id}";
  }

  @GetMapping("/admin/category/{id}")
  public String deleteCategory(@PathVariable Long id){
    categoryService.deleteViaId(id);

    return "redirect:/admin/category"; 
  }


  @GetMapping("admin/category/view/{id}")
  public String viewCategoryDetail(@PathVariable Long id, Model model) {
    // for listing all cashiers
    model.addAttribute("categoryList", categoryService.getAllCategories());
    // cashierDetail is for showing cashier info by Id
    model.addAttribute("categoryDetail", categoryService.getById(id));
    // newCashier is a object for adding new cashier
    model.addAttribute("newCategory", new Category());
    return "admin/category";
  }

}
