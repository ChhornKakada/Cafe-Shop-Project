// package cafe.shop.testing.cafe.shop.controllers;

// import java.util.List;

// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Autowired;

// import cafe.shop.testing.cafe.shop.services.TypeService;
// import cafe.shop.testing.cafe.shop.entities.Type; 

// @RestController
// @RequestMapping("/Types")
// public class TypeController {

//     @Autowired 
//     TypeService typeService; 

//     public TypeController(TypeService typeService){
//         this.typeService = typeService;
//     }

//     @GetMapping
//     public List<Type> getAllTypes(){
//         return typeService.getAllTypes(); 
//     }
// }
