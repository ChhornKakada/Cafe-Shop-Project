package cafe.shop.testing.cafe.shop.ServiceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cafe.shop.testing.cafe.shop.entities.Invoice;
import cafe.shop.testing.cafe.shop.entities.Status;
import cafe.shop.testing.cafe.shop.entities.Tables;
import cafe.shop.testing.cafe.shop.repositories.InvoiceRepository;
import cafe.shop.testing.cafe.shop.repositories.TableRepository;
import cafe.shop.testing.cafe.shop.services.TableService;

@Service
public class TableServiceImpl implements TableService {

  private TableRepository tableRepo;
  private InvoiceRepository invoiceRepo;

  public TableServiceImpl(TableRepository tableRepo, InvoiceRepository invoiceRepo) {
    super();
    this.tableRepo = tableRepo;
    this.invoiceRepo = invoiceRepo;
  }

  @Override
  public Tables getVeiId(Long id) {
    return tableRepo.findById(id).orElse(null);
  }

  @Override
  public List<Tables> getAvailables() {
    List <Tables> tables = new ArrayList<>();
    for (var table : tableRepo.findAll()) {
      if (table.getStatus().equals(Status.available)) {
        tables.add(table);
      }
    }
    return tables;
  }

  @Override
  public void triggerStatus(Long id) {
    Tables table = new Tables();
    table = tableRepo.findById(id).orElse(null);
    if (table != null) {
      if (table.getStatus().equals(Status.available)) {
        table.setStatus(Status.unavailable);
      } else table.setStatus(Status.available);
      tableRepo.save(table);
    }
  }

  @Override
  public List<Tables> getAllTables() {
    return tableRepo.findAll();
  }

   @Override
   public void changeToUnavalible(Long tableId, Long invoiceId){
    Tables table = new Tables();
    table = tableRepo.findById(tableId).orElse(null);

    table.setInvoice_current_id(invoiceId);
    table.setStatus(Status.unavailable);
    tableRepo.save(table);

    Invoice invoice = new Invoice();
    invoice = invoiceRepo.findById(invoiceId).orElse(null);
    invoice.setTable(table);
    invoiceRepo.save(invoice);
   }

  @Override
  public void changeToAvalible(Long tableId) {
    Tables table = new Tables();
    table = tableRepo.findById(tableId).orElse(null);
    table.setInvoice_current_id(null);
    table.setStatus(Status.available);
    tableRepo.save(table);
  }
}
