package cafe.shop.testing.cafe.shop.controllers.cashier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.shop.testing.cafe.shop.entities.Tables;
import cafe.shop.testing.cafe.shop.services.InvoiceService;
import cafe.shop.testing.cafe.shop.services.TableService;

@Controller
public class tableController {

  
  private TableService tableSer;
  private InvoiceService invoiceSer;

  public tableController(TableService tableSer, InvoiceService invoiceSer) {
    super();
    this.tableSer = tableSer;
    this.invoiceSer = invoiceSer;
  }

  // view all tables
  @GetMapping(path = "/cashier/tables")
  public String manageTable(Model model) {
    List<Tables> tables = new ArrayList<>();
    tables = tableSer.getAllTables();
    model.addAttribute("tables", tables);
    model.addAttribute("isCashier", "yes");

    Tables table = new Tables();
    table = tables.get(0);

    // is busy means that have invoice
    if (table.getInvoice_current_id() != null) {
      model.addAttribute("invoice", invoiceSer.getVieId(table.getInvoice_current_id()));
    } else {
      model.addAttribute("invoiceIds", invoiceSer.getInvoiceIdsBoughtToday());
    }

    model.addAttribute("table", table);
    return "cashier/table";
  }


  // view table details
  @GetMapping(path = "/cashier/tables/{tableId}")
  public String viewDetailTable(@PathVariable Long tableId, Model model) {
    List<Tables> tables = new ArrayList<>();
    tables = tableSer.getAllTables();
    model.addAttribute("tables", tables);
    model.addAttribute("isCashier", "yes");

    Tables table = new Tables();
    table = tableSer.getVeiId(tableId);

    // is busy means that have invoice
    if (table.getInvoice_current_id() != null) {
      model.addAttribute("invoice", invoiceSer.getVieId(table.getInvoice_current_id()));
    } else {
      model.addAttribute("invoiceIds", invoiceSer.getInvoiceIdsBoughtToday());
    }

    model.addAttribute("table", table);
    return "cashier/table";
  }


  // update table to unavailable
  @PostMapping(path = "/cashier/tables/updateToUnavailable/{tableId}")
  public String updateToUnavailable(@PathVariable Long tableId, Model model, 
                                    @RequestParam("invoiceId") Long invoiceId){
    tableSer.changeToUnavalible(tableId, invoiceId);
    return "redirect:/cashier/tables/{tableId}";
  }


  // update table to available
  @PostMapping(path = "/cashier/tables/updateToAvailable/{tableId}")
  public String updateToAvailable(@PathVariable Long tableId, Model model) {
    tableSer.changeToAvalible(tableId);
    return "redirect:/cashier/tables/{tableId}";
  }

}
