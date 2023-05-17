package cafe.shop.testing.cafe.shop.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class orderDetailController {
  @GetMapping(path = "/admin/order_history")
  public ModelAndView orderHistory(){
      return new ModelAndView("admin/orderHistory");
  }
}
