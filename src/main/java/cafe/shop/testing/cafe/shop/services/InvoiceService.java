package cafe.shop.testing.cafe.shop.services;

import java.util.List;

import cafe.shop.testing.cafe.shop.entities.Invoice;
import cafe.shop.testing.cafe.shop.entities.InvoiceDetail;
import cafe.shop.testing.cafe.shop.entities.Sustenance;

public interface InvoiceService {
  Invoice newInvoice(List <InvoiceDetail> orderDetail, Long tableId, Long cashierId);
  List <Invoice> getAllInvoices();
  Invoice getVieId(Long id);
  Invoice addAnOrderdetailDrink(Sustenance drink, String ctg, String note, String size, Integer qty, String topping1String,
                           String topping2, Invoice invoice);
  Invoice addAnOrderdetailFood(Long foodId, Integer qty, String note, Invoice invoice);
  void checkout(Invoice invoice, Double cashReceived, String cashierUsername, Long tableId);
}
