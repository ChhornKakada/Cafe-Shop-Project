package cafe.shop.testing.cafe.shop.controllers.cashier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class tableController {

  @GetMapping(path = "/cashier/tables")
  public ModelAndView manageTableList(){
      return new ModelAndView("cashier/table");
  }
}
