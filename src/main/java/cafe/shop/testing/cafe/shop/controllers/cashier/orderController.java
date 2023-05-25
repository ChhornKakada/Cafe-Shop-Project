package cafe.shop.testing.cafe.shop.controllers.cashier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.shop.testing.cafe.shop.entities.Invoice;
import cafe.shop.testing.cafe.shop.entities.Sustenance;
import cafe.shop.testing.cafe.shop.services.InvoiceService;
import cafe.shop.testing.cafe.shop.services.SustenanceDetailService;
import cafe.shop.testing.cafe.shop.services.SustenanceService;
import cafe.shop.testing.cafe.shop.services.TableService;
import cafe.shop.testing.cafe.shop.services.ToppingService;
import jakarta.servlet.http.HttpSession;

@Controller
public class orderController {

  private SustenanceService susService;
  private SustenanceDetailService susDetailSer;
  private ToppingService toppingService;
  private InvoiceService invoiceService;
  private TableService tableService;

  public orderController(SustenanceService susService, SustenanceDetailService susDetailSer,
      ToppingService toppingService, InvoiceService invoiceService, TableService tableService) {
    super();
    this.susService = susService;
    this.susDetailSer = susDetailSer;
    this.toppingService = toppingService;
    this.invoiceService = invoiceService;
    this.tableService = tableService;
  }

  @GetMapping(path = "/cashier/order")
  public String viewHomepageOrder(Model model, HttpSession session) {
    model.addAttribute("drinkList", susService.getAllDrinks());
    model.addAttribute("foodList", susService.getAllFoods());
    Invoice invoice = new Invoice();
    session.setAttribute("invoice", invoice);
    model.addAttribute("invoice", invoice);

    String tableId = "0";
    session.setAttribute("tableId", tableId);
    model.addAttribute("tableId", tableId);
    model.addAttribute("tables", tableService.getAvailables());
    return "cashier/order";
  }

  @GetMapping(path = "/cashier/order/new/drink/{susId}")
  public String viewOrderDrinkCustom(@PathVariable Long susId, HttpSession session,
      Model model) {
    model.addAttribute("drink", susService.getVieId(susId));
    model.addAttribute("drinkList", susService.getAllDrinks());
    model.addAttribute("invoice", session.getAttribute("invoice"));
    return "cashier/orderDrink";
  }

  @GetMapping(path = "/cashier/order/new/food/{susId}")
  public String viewOrderfoodCustom(@PathVariable Long susId, HttpSession session,
      Model model) {
    model.addAttribute("food", susService.getVieId(susId));
    model.addAttribute("foodList", susService.getAllFoods());
    model.addAttribute("invoice", session.getAttribute("invoice"));
    return "cashier/orderFood";
  }

  // for closing popup
  @GetMapping("/cashier/order/new")
  public String addNewOrder(Model model, HttpSession session) {
    Invoice invoice = (Invoice) session.getAttribute("invoice");
    session.setAttribute("invoice", invoice);
    model.addAttribute("invoice", invoice);
    model.addAttribute("drinkList", susService.getAllDrinks());
    model.addAttribute("foodList", susService.getAllFoods());
    model.addAttribute("tables", tableService.getAvailables());

    String tableId = (String) session.getAttribute("tableId");
    session.setAttribute("tableId", tableId);
    model.addAttribute("tableId", tableId);

    return "cashier/order";
  }

  // add new drink
  @PostMapping("/cashier/order/new")
  public String addNewDrink(@RequestParam("ctg") String ctg, @RequestParam("size") String size,
      @RequestParam("qty") Integer qty, @RequestParam("topping1") String topping1,
      @RequestParam("topping2") String topping2, Model model,
      @ModelAttribute("drink") Sustenance drink,
      @RequestParam("note") String note, HttpSession session) {
    Invoice invoice = (Invoice) session.getAttribute("invoice");
    invoice = invoiceService.addAnOrderdetailDrink(drink, ctg, note, size, qty, topping1, topping2, invoice);
    session.setAttribute("invoice", invoice);
    return "redirect:/cashier/order/new";
  }

  // for selecting table
  @PostMapping("/cashier/order/table/{id}")
  public String selectTableOnOrder(@PathVariable Long id, Model model, HttpSession session) {
    String tableId = (String) session.getAttribute("tableId");
    tableId = id.toString();
    // if (tableId.equals("0L")) tableId = "null";
    session.setAttribute("tableId", tableId);
    return "redirect:/cashier/order/new";
  }

  // add new food
  @PostMapping("/cashier/order/new/food/{id}")
  public String addNewFood(@RequestParam("qty") Integer qty, Model model, @PathVariable Long id,
      @RequestParam("note") String note, HttpSession session) {
    Invoice invoice = (Invoice) session.getAttribute("invoice");
    invoice = invoiceService.addAnOrderdetailFood(id, qty, note, invoice);
    session.setAttribute("invoice", invoice);
    return "redirect:/cashier/order/new";
  }

  // checkout
  @PostMapping("/cashier/order/checkout")
  public String checkoutOrder(@RequestParam("cashierName") String cashierName,
                              HttpSession session, Double cashReceived, Model model) {
    Invoice invoice = (Invoice) session.getAttribute("invoice");
    String tableId = (String) session.getAttribute("tableId");
    invoiceService.checkout(invoice, cashReceived, cashierName, Long.valueOf(tableId));
    return "redirect:/cashier/order";
  }
}