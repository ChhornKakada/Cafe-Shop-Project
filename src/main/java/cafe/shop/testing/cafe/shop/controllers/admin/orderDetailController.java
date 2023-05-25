package cafe.shop.testing.cafe.shop.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cafe.shop.testing.cafe.shop.ServiceImplementation.InvoiceServiceImpl;

@Controller
public class orderDetailController {

  private InvoiceServiceImpl invoiceSer;


  public orderDetailController(InvoiceServiceImpl invoiceSer) {
    super();
    this.invoiceSer = invoiceSer;
  }

  @GetMapping(path = "/admin/order_history")
  public String viewHomepageOrderhistory(Model model) {
    model.addAttribute("invoiceList", invoiceSer.getAllInvoices());
    return "admin/orderHistory";
  }

  @GetMapping("/admin/order_history/view/{invoiceId}")
  public String viewOrderhistoryPage(@PathVariable Long invoiceId, Model model){
    model.addAttribute("invoice", invoiceSer.getVieId(invoiceId));
    return "admin/drink";
  }

}
