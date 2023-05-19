package cafe.shop.testing.cafe.shop.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class manageTableController {
  @GetMapping(path = "/admin/manage_table")
  public ModelAndView manageTable(){
      return new ModelAndView("admin/manageTable");
  }
}
