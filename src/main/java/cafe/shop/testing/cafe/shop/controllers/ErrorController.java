package cafe.shop.testing.cafe.shop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ErrorController {
  
  @GetMapping(path = "/forbidden")
  public ModelAndView errorPage(){
      return new ModelAndView("error");
  }
}
