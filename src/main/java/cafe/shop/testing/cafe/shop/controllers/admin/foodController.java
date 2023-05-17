package cafe.shop.testing.cafe.shop.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class foodController {

  @GetMapping(path = "/admin/food")
  public ModelAndView food(){
      return new ModelAndView("admin/food");
  }
}
