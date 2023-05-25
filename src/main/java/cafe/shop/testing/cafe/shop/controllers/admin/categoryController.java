package cafe.shop.testing.cafe.shop.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class categoryController {
  @GetMapping(path = "/admin/category")
  public ModelAndView categoryList(){
      return new ModelAndView("admin/category");
  }
}
