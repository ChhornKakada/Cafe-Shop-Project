package cafe.shop.testing.cafe.shop.controllers.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cafe.shop.testing.cafe.shop.entities.Tables;
import cafe.shop.testing.cafe.shop.services.InvoiceService;
import cafe.shop.testing.cafe.shop.services.TableService;

@Controller
public class manageTableController {
  private TableService tableSer;
  private InvoiceService invoiceSer;



  public manageTableController(TableService tableSer, InvoiceService invoiceSer) {
    super();
    this.tableSer = tableSer;
    this.invoiceSer = invoiceSer;
  }

  // view all tables
  @GetMapping(path = "/admin/manage_table")
  public String manageTable(Model model) {
    List <Tables> tables = new ArrayList<>();
    tables = tableSer.getAllTables();
    model.addAttribute("tables", tables);
    model.addAttribute("isAdmin", "yes");
    Tables table = new Tables();
    table = tables.get(11);

    // is busy means that have invoice
    if (table.getInvoice_current_id() != null) {
      model.addAttribute("invoice", invoiceSer.getVieId(table.getInvoice_current_id()));
    } 
    // means that the tables is avalible
    model.addAttribute("invoiceIds", invoiceSer.getInvoiceIdsBoughtToday());
    model.addAttribute("table", table);
    return "admin/manageTable";
  }

  // view table detail
  @GetMapping(path = "/admin/manage_table/{tableId}")
  public String viewDetailTable(@PathVariable Long tableId, Model model) {
    List <Tables> tables = new ArrayList<>();
    tables = tableSer.getAllTables();
    model.addAttribute("tables", tables);
    model.addAttribute("isCashier", "no");
    Tables table = new Tables();
    table = tableSer.getVeiId(tableId);
    if (table.getInvoice_current_id() != null) {
      model.addAttribute("invoice", invoiceSer.getVieId(table.getInvoice_current_id()));
    } 
  model.addAttribute("table", table);
  return "admin/manageTable";
  }
}
