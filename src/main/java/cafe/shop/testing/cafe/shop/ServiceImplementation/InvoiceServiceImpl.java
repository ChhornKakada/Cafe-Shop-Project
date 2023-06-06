package cafe.shop.testing.cafe.shop.ServiceImplementation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

// import cafe.shop.testing.cafe.shop.controllers.cashier.receipt;
import cafe.shop.testing.cafe.shop.entities.Addon;
import cafe.shop.testing.cafe.shop.entities.AddonDetail;
import cafe.shop.testing.cafe.shop.entities.Employee;
import cafe.shop.testing.cafe.shop.entities.Invoice;
import cafe.shop.testing.cafe.shop.entities.InvoiceDetail;
import cafe.shop.testing.cafe.shop.entities.Sustenance;
import cafe.shop.testing.cafe.shop.entities.SustenanceDetail;
import cafe.shop.testing.cafe.shop.entities.Tables;
import cafe.shop.testing.cafe.shop.entities.Topping;
import cafe.shop.testing.cafe.shop.repositories.AddonRepository;
import cafe.shop.testing.cafe.shop.repositories.EmployeeRepository;
import cafe.shop.testing.cafe.shop.repositories.InvoiceRepository;
import cafe.shop.testing.cafe.shop.repositories.TableRepository;
import cafe.shop.testing.cafe.shop.services.InvoiceService;
import cafe.shop.testing.cafe.shop.services.SustenanceDetailService;
import cafe.shop.testing.cafe.shop.services.TableService;
import cafe.shop.testing.cafe.shop.services.ToppingService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class InvoiceServiceImpl implements InvoiceService {

  private InvoiceRepository invoiceRepo;
  // private TableRepository tableRepo;
  private TableService tableService;
  private EmployeeRepository empRepo;
  // private SustenanceDetailRepository susDetail;
  private SustenanceDetailService susDetailService;
  private ToppingService toppingSer;
  private AddonRepository addonRepo;

  @PersistenceContext
  private EntityManager entityManager;
  private TableRepository tableRepo;

  public InvoiceServiceImpl(InvoiceRepository invoiceRepo, TableService tableService, EmployeeRepository empRepo,
      SustenanceDetailService susDetailService, ToppingService toppingSer, AddonRepository addonRepo,
      EntityManager entityManager, TableRepository tableRepo) {
    super();
    this.invoiceRepo = invoiceRepo;
    this.tableService = tableService;
    this.empRepo = empRepo;
    this.susDetailService = susDetailService;
    this.toppingSer = toppingSer;
    this.addonRepo = addonRepo;
    this.entityManager = entityManager;
    this.tableRepo = tableRepo;
  }

  @Override
  public Invoice newInvoice(List<InvoiceDetail> orderDetail, Long tableId, Long cashierId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'newInvoice'");
  }

  @Override
  public List<Invoice> getAllInvoices() {
    return invoiceRepo.findAll();
  }

  @Override
  public Invoice getVieId(Long id) {
    return invoiceRepo.findById(id).get();
  }


  @Override
  public Invoice addAnOrderdetailDrink(Sustenance drink, String ctgName, String note, String sizeName, Integer qty, String topping1,
      String topping2, Invoice invoice) {

    InvoiceDetail orderDetail = new InvoiceDetail();

    Topping top1 = new Topping();
    top1 = toppingSer.getByName(topping1);
    Topping top2 = new Topping();
    top2 = toppingSer.getByName(topping2);

    List <AddonDetail> addonDetail = new ArrayList<>();

    Double toppingTotalPrice = 0.0;
    if (top1 != null && top2 != null) {
      addonDetail.add(new AddonDetail(top1));
      addonDetail.add(new AddonDetail(top2));
      toppingTotalPrice = top1.getPrice().doubleValue() + top2.getPrice().doubleValue();
    } else if (top1 == null && top2 != null) {
      addonDetail.add(new AddonDetail(top2));
      toppingTotalPrice =  top2.getPrice().doubleValue();
    } else if (top1 != null && top2 == null){
      addonDetail.add(new AddonDetail(top1));
      toppingTotalPrice = top1.getPrice().doubleValue();
    }

    toppingTotalPrice *= qty;

    Addon addon = new Addon();
    if (addonDetail != null) {
      addon.setAddonDetails(addonDetail);
      BigDecimal totalAddonPrice = new BigDecimal(toppingTotalPrice);
      totalAddonPrice = totalAddonPrice.setScale(2, RoundingMode.HALF_UP);
      addon.setTotalPrice(totalAddonPrice);
    }
    
    
    orderDetail.setAddon(addon);

    // add drink detail
    for (var susDetail : susDetailService.getAll()) {
      if (susDetail.getSust().getName().equals(drink.getName())) {
        if (susDetail.getCtg().getName().equals(ctgName)) {
          if (susDetail.getSize().getSize().equals(sizeName)) {
            orderDetail.setSustDetail(susDetail);
            break;
          }
        }
      }
    }

    BigDecimal totalPrice = BigDecimal.ZERO;
    if (addon != null) totalPrice = totalPrice.add(addon.getTotalPrice());

    Double drinkPrice = orderDetail.getSustDetail().getPrice().doubleValue() * qty;
    totalPrice = totalPrice.add(new BigDecimal(drinkPrice));
    orderDetail.setQty(qty);
    totalPrice = totalPrice.setScale(2, RoundingMode.HALF_UP);
    
    orderDetail.setTotalPrice(totalPrice);
    orderDetail.setNote(note);
    invoice.addNewInvoicedetail(orderDetail);
    return invoice;
    
  }


  // add food to order detail
  @Override
  public Invoice addAnOrderdetailFood(Long foodId, Integer qty, String note, Invoice invoice) {
    SustenanceDetail foodDetail = new SustenanceDetail();
    foodDetail = susDetailService.getSusVieId(foodId).get(0);

    InvoiceDetail orderDetail = new InvoiceDetail();
    orderDetail.setSustDetail(foodDetail);
    orderDetail.setQty(qty);
    orderDetail.setNote(note);

    Double totalPrice = orderDetail.getSustDetail().getPrice().doubleValue() * qty;
    BigDecimal tmpPrice = new BigDecimal(totalPrice);
    tmpPrice = tmpPrice.setScale(2, RoundingMode.HALF_UP);
    orderDetail.setTotalPrice(tmpPrice);
    invoice.addNewInvoicedetail(orderDetail);
    return invoice;
  }


  @Override
  public Invoice checkout(Invoice invoice, Double cashReceived, String cashierUsername, Long tableId) {
    Employee cashier = new Employee();
    cashier = empRepo.findByUsername(cashierUsername);

    Tables table = new Tables();
    table = tableService.getVeiId(tableId);

    // change from free to busy
    tableService.triggerStatus(tableId);

    invoice.setCashReceived(new BigDecimal(cashReceived));
    invoice.setChanged(invoice.getCashReceived().subtract(invoice.getTotalPrice()));
    invoice.setTable(table);
    invoice.setEmp(cashier);
    invoice.setOrderedAt(new Timestamp(System.currentTimeMillis()));

    for (var orderDetail : invoice.getInvoiceDetails()) {
      Addon addon = new Addon();
      addon = orderDetail.getAddon();
      if (addon != null) {
        addon = addonRepo.saveAndFlush(orderDetail.getAddon());
        if (addon != null) {
          orderDetail.setAddon(addon);
        }
      }
    }

    Invoice invoiceTmp = new Invoice();
    invoiceTmp = invoiceRepo.save(invoice);

    if (table != null) {
      table.setInvoice_current_id(invoiceTmp.getId());
      tableRepo.save(table);
    }

    return invoiceTmp;
  }


  // get order that bought today
  @Override
  public List<Long> getInvoiceIdsBoughtToday() {
    // orderedAt match of the class in java not column in sql
    String jpql = "SELECT i.id FROM Invoice i WHERE DATE(i.orderedAt) = :today AND i.table IS NULL";
    TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
    query.setParameter("today", new Date(System.currentTimeMillis()));
    List<Long> invoiceIds = query.getResultList();

    return invoiceIds;
  }
  
}
