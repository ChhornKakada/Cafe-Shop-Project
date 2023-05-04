package cafe.shop.testing.cafe.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {
    @GetMapping(path = "/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }
}
