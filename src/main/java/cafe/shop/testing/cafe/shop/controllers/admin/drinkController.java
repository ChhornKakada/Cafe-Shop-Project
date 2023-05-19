package cafe.shop.testing.cafe.shop.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class drinkController {

  @GetMapping(path = "/admin/drink")
  public ModelAndView drink(){
      return new ModelAndView("admin/drink");
  }
}
