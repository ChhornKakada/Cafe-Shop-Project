package cafe.shop.testing.cafe.shop.controllers.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cafe.shop.testing.cafe.shop.entities.Sustenance;
import cafe.shop.testing.cafe.shop.models.DrinkDetail;
import cafe.shop.testing.cafe.shop.services.SustenanceDetailService;
import cafe.shop.testing.cafe.shop.services.SustenanceService;

@Controller
public class drinkController {

  private SustenanceService susService;
  private SustenanceDetailService susDetailSer;

  public drinkController(SustenanceService susService, SustenanceDetailService susDetailSer) {
    super();
    this.susService = susService;
    this.susDetailSer = susDetailSer;
  }

  // view all drinks
  @GetMapping(path = "/admin/drink")
  public String viewDrinkHomepage(Model model){
    List <Sustenance> drinkList = new ArrayList<>();
    drinkList = susService.getAllDrinks();
    // drink for listing
    model.addAttribute("drinkList", drinkList);
    // drink for showing at the right side (drink details)
    model.addAttribute("drinkDetail", susDetailSer.getDrinkDetail(drinkList.get(0).getId()));
    // drink that prepare for add
    model.addAttribute("drinkForAdd", new DrinkDetail());
    return "admin/drink";
  }

  // add new drink
  @PostMapping("/admin/drink/new")
  public String addNewDrink(@RequestParam("file") MultipartFile file,
                           @ModelAttribute("drinkForAdd") DrinkDetail newDrink) {
    susDetailSer.addNewDrink(newDrink, file);
    return "redirect:/admin/drink";
  }


  // view detail of a drink
  @GetMapping(path = "/admin/drink/view/{drinkId}")
  public String viewDrinkHomepage(@PathVariable Long drinkId, Model model){
    List <Sustenance> drinkList = new ArrayList<>();
    drinkList = susService.getAllDrinks();
    // drink for listing
    model.addAttribute("drinkList", drinkList);
    // drink for showing at the right side (drink details)
    model.addAttribute("drinkDetail", susDetailSer.getDrinkDetail(drinkId));
    // drink that prepare for add
    model.addAttribute("drinkForAdd", new DrinkDetail());
    return "admin/drink";
  }

  // delete a drink
  @GetMapping("/admin/drink/{susId}")
  public String deleteDrink(@PathVariable Long susId) {
    susService.setInactive(susId);
    return "redirect:/admin/drink";
  }

  @GetMapping(path = "/admin/drink/update/{drinkId}")
  public String viewUpdateDrinkPage(@PathVariable Long drinkId, Model model){
    List <Sustenance> drinkList = new ArrayList<>();
    drinkList = susService.getAllDrinks();
    // drink for listing
    model.addAttribute("drinkList", drinkList);
    // drink for showing at the right side (drink details)
    model.addAttribute("drinkDetail", susDetailSer.getDrinkDetail(drinkId));
    return "admin/edit_InforDatail/edit_drink";
  }

  @PostMapping("/admin/drink/update/{susId}")
  public String updateDrinkVieId(@PathVariable Long susId, @RequestParam("file") MultipartFile file,
                                   @ModelAttribute("drinkDetail") DrinkDetail newDrink) {
    susDetailSer.updateDrinkVieSusId(susId, newDrink, file);
    return "redirect:/admin/drink/view/{susId}";
  }

}
