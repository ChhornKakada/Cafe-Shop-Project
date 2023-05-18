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
import cafe.shop.testing.cafe.shop.entities.SustenanceDetail;
import cafe.shop.testing.cafe.shop.services.SustenanceDetailService;
import cafe.shop.testing.cafe.shop.services.SustenanceService;

@Controller
public class foodController {

  private SustenanceService susService;
  private SustenanceDetailService susDetailSer;

  public foodController(SustenanceService susService, SustenanceDetailService susDetailSer) {
    this.susService = susService;
    this.susDetailSer = susDetailSer;
  }

  @GetMapping("admin/food")
  public String viewHomepageFood(Model model) {
    List <Sustenance> foodList = new ArrayList<>();
    foodList = susService.getAllFoods();
    model.addAttribute("foods", foodList);
    model.addAttribute("foodDetail", susDetailSer.getSusVieId(foodList.get(0).getId()).get(0));
    model.addAttribute("foodPrepare", new Sustenance());
    return "admin/food";
  }

  // view detail
  @GetMapping("admin/food/view/{susId}")
  public String viewFoodDaital(@PathVariable Long susId, Model model) {
    model.addAttribute("foods", susService.getAllFoods());
    model.addAttribute("foodDetail", susDetailSer.getSusVieId(susId).get(0));
    model.addAttribute("foodPrepare", new Sustenance());
    return "admin/edit_InforDatail/view_foodDetail";
  }

  @PostMapping("/admin/food/new")
  public String addNewFood(@RequestParam("file") MultipartFile file,
                           @ModelAttribute("foodPrepare") Sustenance food,
                           @RequestParam("foodPrice") Float foodPrice) {
    susDetailSer.addNewFood(food, foodPrice, file);
    return "redirect:/admin/food";
  }

  // detele food
  @GetMapping("/admin/food/{susId}")
  public String deleteFood(@PathVariable Long susId) {
    susDetailSer.deleteSustenanceVieId(susId);
    susService.deleteVieId(susId);
    return "redirect:/admin/food";
  }

  // update food
  @GetMapping("/admin/food/update/{susId}")
  public String viewUpdateFood(@PathVariable Long susId, Model model) {
    model.addAttribute("foods", susService.getAllFoods());
    model.addAttribute("foodDetail", susDetailSer.getSusVieId(susId).get(0));
    // model.addAttribute("foodPrepare", new Sustenance());
    return "admin/edit_InforDatail/edit_food";
  }

  @PostMapping("/admin/food/update/{susId}")
  // @RequestMapping(value = "admin/food/update/{susId}", method = RequestMethod.POST)
  public String updateCashierVieId(@PathVariable Long susId, @RequestParam("file") MultipartFile file,
                                   @ModelAttribute("foodDetail") SustenanceDetail susDetail) {
    susDetailSer.updateFoodVieSusId(susId, susDetail, file);
    return "redirect:/admin/food/view/{susId}";
  }

}
