package cafe.shop.testing.cafe.shop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
    
    @GetMapping(path = "/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

}
